package com.hakoohakoo.leverageapart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hakoohakoo.leverageapart.core.mapper.AreaMapper;
import com.hakoohakoo.leverageapart.core.model.Area;
import com.hakoohakoo.leverageapart.core.repository.AreaRepository;

@RestController
@RequestMapping("/api/area")
public class AreaController {
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private AreaMapper areaMapper;
	
	@GetMapping
	public Area getArea(@RequestParam("doCode") String doCode, @RequestParam("cityCode") String cityCode, @RequestParam("guCode") String guCode, @RequestParam("dongCode") String dongCode) {
		if (doCode.isBlank()) {
			if (dongCode.isBlank()) return areaRepository.findByCityCodeAndGuCode(cityCode, guCode);
			else return areaRepository.findByCityCodeAndGuCodeAndDongCode(cityCode, guCode, dongCode);
		} else {
			if (dongCode.isBlank()) return areaRepository.findByDoCodeAndCityCodeAndGuCode(doCode, cityCode, guCode);
			else if (guCode.isBlank()) return areaRepository.findByDoCodeAndCityCodeAndDongCode(doCode, cityCode, dongCode);
			else return areaRepository.findByDoCodeAndCityCodeAndGuCodeAndDongCode(doCode, cityCode, guCode, dongCode);
		}
	}
	
	@GetMapping("/does")
	@ResponseBody
	public List<Area> findAllDo() {
		return areaMapper.findAllDo();
	}
	
	@GetMapping("/citys")
	@ResponseBody
	public List<Area> findCitys(@RequestParam("doCode") String doCode) {
		if (doCode.isBlank()) return areaMapper.findAllSpecialCity();
		else return areaMapper.findCitysByDoCode(doCode);
	}
	
	@GetMapping("/gus")
	public List<Area> findGus(@RequestParam("doCode") String doCode, @RequestParam("cityCode") String cityCode) {
		if (doCode.isBlank()) return areaMapper.findGusByCityCode(cityCode);
		else return areaMapper.findGusByDoCodeAndCityCode(doCode, cityCode);
	}
	
	@GetMapping("/dongs")
	public List<Area> findDongs(@RequestParam("doCode") String doCode, @RequestParam("cityCode") String cityCode, @RequestParam("guCode") String guCode) {
		if (doCode.isBlank()) return areaMapper.findDongsByCityCodeAndGuCode(cityCode, guCode);
		else if (guCode.isBlank()) return areaMapper.findDongsByDoCodeAndCityCode(doCode, cityCode);
		else return areaMapper.findDongsByDoCodeAndCityCodeAndGuCode(doCode, cityCode, guCode);
	}
}
