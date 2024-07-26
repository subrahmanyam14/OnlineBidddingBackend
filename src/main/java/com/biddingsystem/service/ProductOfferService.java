package com.biddingsystem.service;

import java.util.List;

import com.biddingsystem.entity.Product;
import com.biddingsystem.entity.ProductOffer;
import com.biddingsystem.entity.User;

public interface ProductOfferService {
	
	ProductOffer addOffer(ProductOffer offer);
	
	ProductOffer updateOffer(ProductOffer offer);
	
	ProductOffer getOfferById(int offerId);
	
	List<ProductOffer> getOffersByUserAndStatus(User user, List<String> status);
	
	List<ProductOffer> getOffersByProductAndStatus(Product product, List<String> status);
	

}
