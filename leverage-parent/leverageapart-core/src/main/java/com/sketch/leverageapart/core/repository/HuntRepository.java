package com.sketch.leverageapart.core.repository;

import java.util.List;

import com.sketch.leverageapart.core.model.Hunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HuntRepository extends JpaRepository<Hunt, Integer>{
	List<Hunt> findByHuntDate(int huntDate);
	List<Hunt> findByHuntTypeId(int huntTypeId);
}
