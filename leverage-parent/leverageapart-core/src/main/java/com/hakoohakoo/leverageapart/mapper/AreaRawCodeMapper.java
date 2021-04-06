package com.hakoohakoo.leverageapart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hakoohakoo.leverageapart.model.AreaRawCode;

@Mapper
public interface AreaRawCodeMapper {
	@Select("SELECT LEFT(code, 2), code, name FROM area_raw_code WHERE code LIKE '%00000000' AND name LIKE '%시';")
	List<AreaRawCode> findAllSpecialCities();
	
	@Select("SELECT * FROM area_raw_code WHERE code LIKE '%00000000' AND name LIKE '%도'")
	List<AreaRawCode> findAllDo();
	
	@Select("SELECT * FROM area_raw_code WHERE name LIKE '%시' AND code LIKE CONCAT(#{doCode},'%')")
	List<AreaRawCode> findAllCitiesInDo(String doCode);
	
	@Select("SELECT * FROM area_raw_code WHERE name LIKE '%구' AND code LIKE CONCAT(#{doAndCityCode},'%')")
	List<AreaRawCode> findAllGu(String doAndCityCode);
	
	//@Select("SELECT LEFT(code,2) AS city_code, MID(code,3,3) AS gu_code, MID(code,6,5) AS dong_code, code, name FROM area_raw_code WHERE code LIKE CONCAT(#{guFullCode},'%')")
	@Select("SELECT * FROM area_raw_code WHERE code LIKE CONCAT(#{cityAndGuCode},'%')")
	List<AreaRawCode> findAllDongOfSpecialCities(String cityAndGuCode);
	
	@Select("SELECT * FROM area_raw_code WHERE code LIKE CONCAT(#{doAndCityAndGuCode},'%')")
	List<AreaRawCode> findAllDongOfCitiesInDo(String doAndCityAndGuCode);
	
	
}