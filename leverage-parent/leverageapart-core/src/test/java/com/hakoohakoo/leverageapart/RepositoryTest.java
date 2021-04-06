package com.hakoohakoo.leverageapart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hakoohakoo.leverageapart.repository.AreaRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RepositoryTest {
	@Autowired
	private AreaRepository areaRepository;
	
	@Test
	public void getAreas() {
		assertThat(areaRepository.count() == 0);
		log.debug("areaRepository.count() : {}", areaRepository.count());
	}
}
