package com.hakoohakoo.leverageapart.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.hakoohakoo.leverageapart.core.model.Area;

@Mapper
public interface AreaMapper {
	@Select("SELECT do_code, do_name FROM area WHERE do_code IS NOT NULL GROUP BY do_code")
	List<Area> findAllDo();
	
	@Select("SELECT city_code, city_name FROM area WHERE do_code IS NULL GROUP BY city_code")
	List<Area> findAllSpecialCity();

	@Select("SELECT city_code, city_name FROM area WHERE do_code = #{doCode} GROUP BY city_code")
	List<Area> findCitysByDoCode(@Param("doCode") String doCode);
	
	@Select("SELECT gu_code, gu_name FROM area WHERE do_code =#{doCode} AND city_code = #{cityCode} AND gu_code IS NOT NULL GROUP BY gu_code")
	List<Area> findGusByDoCodeAndCityCode(@Param("doCode") String doCode, @Param("cityCode") String cityCode);
	
	@Select("SELECT gu_code, gu_name FROM area WHERE city_code = #{cityCode} AND gu_code IS NOT NULL GROUP BY gu_code")
	List<Area> findGusByCityCode(@Param("cityCode") String cityCode);
	
	@Select("SELECT dong_code, dong_name FROM area WHERE do_code =#{doCode} AND city_code = #{cityCode} AND gu_code = #{guCode} AND dong_code IS NOT NULL GROUP BY dong_code")
	List<Area> findDongsByDoCodeAndCityCodeAndGuCode(@Param("doCode") String doCode, @Param("cityCode") String cityCode, @Param("guCode") String guCode);
	
	@Select("SELECT dong_code, dong_name FROM area WHERE city_code = #{cityCode} AND gu_code = #{guCode} AND dong_code IS NOT NULL GROUP BY dong_code")
	List<Area> findDongsByCityCodeAndGuCode(@Param("cityCode") String cityCode, @Param("guCode") String guCode);
	
	@Select("SELECT dong_code, dong_name FROM area WHERE do_code =#{doCode} AND city_code = #{cityCode} AND dong_code IS NOT NULL GROUP BY dong_code")
	List<Area> findDongsByDoCodeAndCityCode(@Param("doCode") String doCode, @Param("cityCode") String cityCode);
	
	@Select("SELECT * FROM area WHERE city_name=#{cityName}")
	List<Area> findDongsByCityName(@Param("cityName") String cityName);
}
