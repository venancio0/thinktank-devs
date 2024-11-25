package com.gvc.thinktank_dev.repositories;

import com.gvc.thinktank_dev.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {
}
