package com.maksdu.good.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maksdu.good.domain.ShopType;

@Repository
public interface GoodTypeRepository extends JpaRepository<ShopType, Long>{

}
