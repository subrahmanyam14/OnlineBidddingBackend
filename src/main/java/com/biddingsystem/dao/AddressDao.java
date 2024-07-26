package com.biddingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biddingsystem.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
