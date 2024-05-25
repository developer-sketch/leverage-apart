package com.sketch.leverageapart.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sketch.leverageapart.core.mapper.AreaMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MapperTest {
	@Autowired
	private AreaMapper areaMapper;
	
	@Test
	public void getAreas() {
		assertThat(areaMapper.findAllDo() != null);
		log.debug("areaMapper.findAllDo() : {}", areaMapper.findAllDo().size());
	}
}
