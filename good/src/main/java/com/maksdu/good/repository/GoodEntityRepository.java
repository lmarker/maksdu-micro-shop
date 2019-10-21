package com.maksdu.good.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maksdu.good.domain.Good;

@Repository
public interface GoodEntityRepository extends JpaRepository<Good, String>{

}
