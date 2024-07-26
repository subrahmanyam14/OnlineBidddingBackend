package com.biddingsystem.service;

import java.util.List;

import com.biddingsystem.entity.Address;
import com.biddingsystem.entity.User;

public interface AddressService {
	
	Address addAddress(Address address);
	
	Address updateAddress(Address address);
	
	Address getAddressById(int addressId);

}
