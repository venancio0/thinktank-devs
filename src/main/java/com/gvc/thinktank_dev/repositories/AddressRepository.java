package com.gvc.thinktank_dev.repositories;

import com.gvc.thinktank_dev.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
