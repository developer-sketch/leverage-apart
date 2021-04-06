package com.hakoohakoo.leverageapart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hakoohakoo.leverageapart.model.HuntType;


@Repository
public interface HuntTypeRepository extends JpaRepository<HuntType, Integer> {

}
