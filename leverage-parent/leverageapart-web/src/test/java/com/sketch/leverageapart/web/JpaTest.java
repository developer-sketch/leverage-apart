package com.sketch.leverageapart.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sketch.leverageapart.core.repository.AreaRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class JpaTest {
	@Autowired
	private AreaRepository areaRepository;
	
	@Test
	public void getAreas() {
		assertThat(areaRepository.count() == 0);
		log.debug("areaRepository.count() : {}", areaRepository.count());
	}
}
