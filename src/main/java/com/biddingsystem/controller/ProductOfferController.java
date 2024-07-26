package com.biddingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biddingsystem.dto.CommonApiResponse;
import com.biddingsystem.dto.ProductOfferRequestDto;
import com.biddingsystem.dto.ProductOfferResponse;
import com.biddingsystem.resource.ProductOfferResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/product/offer")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductOfferController {

	@Autowired
	private ProductOfferResource productOfferResource;

	@PostMapping("add")
	@Operation(summary = "Api to add product offer")
	public ResponseEntity<CommonApiResponse> addOffer(@RequestBody ProductOfferRequestDto request) {
		return this.productOfferResource.addProductOffer(request);
	}

	@GetMapping("fetch/product")
	@Operation(summary = "Api to fetch product offers by product")
	public ResponseEntity<ProductOfferResponse> fetchProductOffersByProduct(@RequestParam("productId") int productId) {
		return this.productOfferResource.fetchProductOffersByProduct(productId);
	}

	@GetMapping("fetch/user")
	@Operation(summary = "Api to add product offers by user")
	public ResponseEntity<?> fetchProductOffersByUser(@RequestParam("userId") int userId) {
		return this.productOfferResource.fetchProductOffersByUser(userId);
	}

	@DeleteMapping("/id")
	@Operation(summary = "Api to delete the product offer")
	public ResponseEntity<CommonApiResponse> deleteOffer(@RequestParam("offerId") int offerId) {
		return this.productOfferResource.deleteOffer(offerId);
	}

}
