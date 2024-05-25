package com.sketch.leverageapart.collector.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.sketch.leverageapart.collector.model.Area;

@Repository
public interface AreaRepository extends R2dbcRepository<Area, String> {
}
