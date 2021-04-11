package com.hakoohakoo.leverageapart.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hakoohakoo.leverageapart.core.model.Area;


public interface AreaRepository extends JpaRepository<Area, String>{
	Area findByDoCodeAndCityCodeAndGuCode(String doCode, String cityCode, String guCode);
	Area findByCityCodeAndGuCode(String cityCode, String guCode);
	Area findByCityCodeAndGuCodeAndDongCode(String cityCode, String guCode, String dongCode);
	Area findByDoCodeAndCityCodeAndGuCodeAndDongCode(String doCode, String cityCode, String guCode, String dongCode);
	Area findByDoCodeAndCityCodeAndDongCode(String doCode, String cityCode, String dongCode);
}
