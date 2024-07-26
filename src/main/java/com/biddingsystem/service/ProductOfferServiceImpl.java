package com.biddingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biddingsystem.dao.ProductOfferDao;
import com.biddingsystem.entity.Product;
import com.biddingsystem.entity.ProductOffer;
import com.biddingsystem.entity.User;

@Repository
public class ProductOfferServiceImpl implements ProductOfferService {

	@Autowired
	private ProductOfferDao productOfferDao;

	@Override
	public ProductOffer addOffer(ProductOffer offer) {
		return productOfferDao.save(offer);
	}

	@Override
	public ProductOffer updateOffer(ProductOffer offer) {
		return productOfferDao.save(offer);
	}

	@Override
	public ProductOffer getOfferById(int offerId) {
		Optional<ProductOffer> optionalOffer = this.productOfferDao.findById(offerId);

		if (optionalOffer.isPresent()) {
			return optionalOffer.get();
		} else {
			return null;
		}
	}

	@Override
	public List<ProductOffer> getOffersByUserAndStatus(User user, List<String> status) {
		return productOfferDao.findByUserAndStatusIn(user, status);
	}

	@Override
	public List<ProductOffer> getOffersByProductAndStatus(Product product, List<String> status) {
		return productOfferDao.findByProductAndStatusIn(product, status);
	}

}
