package com.biddingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biddingsystem.entity.Product;
import com.biddingsystem.entity.ProductOffer;
import com.biddingsystem.entity.User;

@Repository
public interface ProductOfferDao extends JpaRepository<ProductOffer, Integer> {
	
	List<ProductOffer> findByProductAndStatusIn(Product product, List<String> status);
	List<ProductOffer> findByUserAndStatusIn(User user, List<String> status);

}
