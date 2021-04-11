package com.hakoohakoo.leverageapart.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hakoohakoo.leverageapart.core.model.HuntType;


@Repository
public interface HuntTypeRepository extends JpaRepository<HuntType, Integer> {

}
