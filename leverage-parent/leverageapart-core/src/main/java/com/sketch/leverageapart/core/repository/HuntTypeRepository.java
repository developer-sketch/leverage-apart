package com.sketch.leverageapart.core.repository;

import com.sketch.leverageapart.core.model.HuntType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HuntTypeRepository extends JpaRepository<HuntType, Integer> {

}
