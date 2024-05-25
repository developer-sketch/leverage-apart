package com.hakoohakoo.leverageapart.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakoohakoo.leverageapart.core.mapper.AreaRawCodeMapper;
import com.hakoohakoo.leverageapart.core.model.Area;
import com.hakoohakoo.leverageapart.core.repository.AreaRepository;

@RestController
@RequestMapping("/api/area/collect")
public class AreaCollectionController {
	@Autowired
	private AreaRawCodeMapper areaRawCodeMapper;
	@Autowired
	private AreaRepository areaRepository;

	@GetMapping
	public void collect() {
		// 특별시&광역시 적재
		List<Area> specialCities = getSpecialCities();
		specialCities.stream().forEach(specialCity -> areaRepository.save(specialCity));

		// 특별시&광역시 구 적재
		List<Area> guOfSpecialCities = getAllGuOfSpecialCities(specialCities);
		guOfSpecialCities.stream().forEach(gu -> areaRepository.save(gu));
		

		// 특별시&광역시 동 적재
		List<Area> dongOfSpecialCities = getAllDongsOfSpecialCities(guOfSpecialCities);
		dongOfSpecialCities.stream().parallel().forEach(dong -> areaRepository.save(dong));
	}

	@GetMapping("/do")
	public void collectDo() {
		List<Area> does = getAllDo();

		List<Area> citiesInDo = getCitiesInDo(does);
		citiesInDo.stream().forEach(city -> areaRepository.save(city));
		
		List<Area> guOfCitiesInDo = getAllGuOfCitiesIndo(citiesInDo);
		guOfCitiesInDo.stream().forEach(city -> areaRepository.save(city));
		
		List<Area> dongOfCitiesInDo = getAllDongsOfCitiesIndo(guOfCitiesInDo);
		dongOfCitiesInDo.stream().forEach(dong -> areaRepository.save(dong));
	}

	private List<Area> getSpecialCities() {
		return areaRawCodeMapper.findAllSpecialCities().stream()
				.map(areaRawCode -> Area.builder().id(areaRawCode.getCode())
						.cityCode(areaRawCode.getCode().substring(0, 2)).cityName(areaRawCode.getName()).build())
				.collect(Collectors.toList());
	}
	
	private List<Area> getAllGuOfSpecialCities(List<Area> specialCities) {
		return specialCities.stream().parallel()
		.map(area -> areaRawCodeMapper.findAllGu(area.getCityCode()))
		.flatMap(list -> list.stream())
		.map(areaRawCode -> Area.builder().id(areaRawCode.getCode())
				.cityCode(areaRawCode.getCode().substring(0, 2))
				.cityName(areaRawCode.getName().split(" ")[0])
				.guCode(areaRawCode.getCode().substring(2, 5))
				.guName(areaRawCode.getName().split(" ")[1]).build())
		.collect(Collectors.toList());
	}
	
	
	private List<Area> getAllDongsOfSpecialCities(List<Area> guOfSpecialCities) {
		return guOfSpecialCities.stream().parallel()
				.map(area -> areaRawCodeMapper.findAllDongOfSpecialCities(area.getCityCode().concat(area.getGuCode())))
				.flatMap(list -> list.stream())
				.filter(areaRawCode -> areaRawCode.getName().split(" ").length == 3)
				.map(areaRawCode -> Area.builder().id(areaRawCode.getCode())
						.cityCode(areaRawCode.getCode().substring(0, 2))
						.cityName(areaRawCode.getName().split(" ")[0])
						.guCode(areaRawCode.getCode().substring(2, 5))
						.guName(areaRawCode.getName().split(" ")[1])
						.dongCode(areaRawCode.getCode().substring(5, 10))
						.dongName(areaRawCode.getName().split(" ")[2])
						.build())
				.collect(Collectors.toList());
	}
	
	public List<Area> getAllDo() {
		return areaRawCodeMapper.findAllDo().stream()
				.map(areaRawCode -> Area.builder().id(areaRawCode.getCode())
						.doCode(areaRawCode.getCode().substring(0, 2))
						.doName(areaRawCode.getName())
						.build())
				.collect(Collectors.toList());
	}
	
	public List<Area> getCitiesInDo(List<Area> does) {
		return does.stream()
				.map(area -> areaRawCodeMapper.findAllCitiesInDo(area.getDoCode()))
				.flatMap(list -> list.stream())
				.filter(areaRawCode -> areaRawCodeMapper.findAllGu(areaRawCode.getCode().substring(0, 4)).size() > 0) //구가 있는 경우만 적재
				.map(areaRawCode -> Area.builder()
						.id(areaRawCode.getCode())
						.doCode(areaRawCode.getCode().substring(0, 2))
						.doName(areaRawCode.getName().split(" ")[0])
						.cityCode(areaRawCode.getCode().substring(2, 4))
						.cityName(areaRawCode.getName().split(" ")[1])
						.build())
				.collect(Collectors.toList());
	}
	
	private List<Area> getAllGuOfCitiesIndo(List<Area> citiesIndo) {
		return citiesIndo.stream().parallel()
		.map(area -> areaRawCodeMapper.findAllGu(area.getDoCode().concat(area.getCityCode())))
		.flatMap(list -> list.stream())
		.filter(areaRawCode -> areaRawCode.getName().split(" ").length == 3)
		.map(areaRawCode -> Area.builder().id(areaRawCode.getCode())
				.doCode(areaRawCode.getCode().substring(0, 2))
				.doName(areaRawCode.getName().split(" ")[0])
				.cityCode(areaRawCode.getCode().substring(2, 4))
				.cityName(areaRawCode.getName().split(" ")[1])
				.guCode(areaRawCode.getCode().substring(4, 5))
				.guName(areaRawCode.getName().split(" ")[2]).build())
		.collect(Collectors.toList());
	}
	
	
	private List<Area> getAllDongsOfCitiesIndo(List<Area> guOfCitiesIndo) {
		return guOfCitiesIndo.stream().parallel()
				.map(area -> areaRawCodeMapper.findAllDongOfCitiesInDo(String.join("", area.getDoCode(), area.getCityCode(), area.getGuCode())))
				.flatMap(list -> list.stream())
				.filter(areaRawCode -> areaRawCode.getName().split(" ").length == 4)
				.map(areaRawCode -> Area.builder().id(areaRawCode.getCode())
						.doCode(areaRawCode.getCode().substring(0, 2))
						.doName(areaRawCode.getName().split(" ")[0])
						.cityCode(areaRawCode.getCode().substring(2, 4))
						.cityName(areaRawCode.getName().split(" ")[1])
						.guCode(areaRawCode.getCode().substring(4, 5))
						.guName(areaRawCode.getName().split(" ")[2])
						.dongCode(areaRawCode.getCode().substring(5, 10))
						.dongName(areaRawCode.getName().split(" ")[3])
						.build())
				.collect(Collectors.toList());
	}

	public void collectWithoutGu() {
		// 이름으로 시 검색
		// 해당 시의 동 적재
		// 구는 0에서 null로 변경
	}
}
