package com.biddingsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class StorageServiceImpl implements StorageService {

    @Value("${com.onlinebidding.image.folder.path:./uploads/images/}")
    private String BASEPATH;

    private String actualStoragePath;

    @PostConstruct
    public void init() {
        try {
            // Resolve the path to absolute path
            Path basePath = Paths.get(BASEPATH).toAbsolutePath().normalize();
            this.actualStoragePath = basePath.toString();
            
            // Create directory if it doesn't exist
            File directory = new File(actualStoragePath);
            if (!directory.exists()) {
                boolean created = directory.mkdirs();
                if (created) {
                    System.out.println("✅ Storage directory created: " + actualStoragePath);
                } else {
                    throw new IOException("❌ Failed to create directory: " + actualStoragePath);
                }
            }
            
            // Test if directory is writable
            File testFile = new File(directory, "test-write.tmp");
            if (testFile.createNewFile()) {
                testFile.delete();
                System.out.println("✅ Storage directory is writable");
            }
            
            System.out.println("📁 Storage Service Initialized:");
            System.out.println("   - Configured path: " + BASEPATH);
            System.out.println("   - Actual path: " + actualStoragePath);
            
        } catch (Exception e) {
            System.err.println("❌ Storage initialization failed: " + e.getMessage());
            throw new RuntimeException("Storage service initialization failed", e);
        }
    }

    @Override
    public List<String> loadAll() {
        File dirPath = new File(actualStoragePath);
        if (!dirPath.exists()) {
            return Arrays.asList();
        }
        String[] files = dirPath.list();
        return files != null ? Arrays.asList(files) : Arrays.asList();
    }

    @Override
    public String store(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be null or empty");
        }

        try {
            // Generate unique filename
            String originalFileName = file.getOriginalFilename();
            String ext = ".png"; // default extension
            if (originalFileName != null && originalFileName.contains(".")) {
                ext = originalFileName.substring(originalFileName.lastIndexOf("."));
            }
            
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
            File filePath = new File(actualStoragePath, fileName);
            
            System.out.println("💾 Storing file: " + fileName);
            System.out.println("   - Full path: " + filePath.getAbsolutePath());
            
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                FileCopyUtils.copy(file.getInputStream(), out);
                System.out.println("✅ File stored successfully: " + fileName);
                return fileName;
            }
            
        } catch (Exception e) {
            System.err.println("❌ Failed to store file: " + e.getMessage());
            throw new RuntimeException("Failed to store file: " + e.getMessage(), e);
        }
    }

    @Override
    public Resource load(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return null;
        }
        
        File filePath = new File(actualStoragePath, fileName);
        if (filePath.exists() && filePath.isFile()) {
            return new FileSystemResource(filePath);
        }
        System.err.println("❌ File not found: " + fileName);
        return null;
    }

    @Override
    public void delete(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return;
        }
        
        File filePath = new File(actualStoragePath, fileName);
        if (filePath.exists() && filePath.isFile()) {
            boolean deleted = filePath.delete();
            if (deleted) {
                System.out.println("✅ File deleted: " + fileName);
            } else {
                System.err.println("❌ Failed to delete file: " + fileName);
            }
        }
    }

    // Utility method to get storage info
    public String getStorageInfo() {
        File dir = new File(actualStoragePath);
        return String.format(
            "Storage Path: %s%nExists: %s%nWritable: %s%nFile Count: %d",
            actualStoragePath,
            dir.exists(),
            dir.canWrite(),
            dir.list() != null ? dir.list().length : 0
        );
    }
}