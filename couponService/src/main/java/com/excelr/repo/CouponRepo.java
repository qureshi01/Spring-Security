package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.model.Coupon;
@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {
	public Coupon findByCode(String code);
}
