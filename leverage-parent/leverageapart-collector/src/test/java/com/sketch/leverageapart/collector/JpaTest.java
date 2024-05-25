package com.sketch.leverageapart.collector;

import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sketch.leverageapart.collector.model.Area;
import com.sketch.leverageapart.collector.repository.AreaRepository;
import com.sketch.leverageapart.collector.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class JpaTest {
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void findById() {
		customerRepository.findByName("woojin").log().doOnNext(customer -> {
			log.debug(customer.toString());
		}).block(Duration.ofSeconds(10));
		
		Area area = areaRepository.findById("1100000000").log().block();
		
				log.debug("result : {}", area.getId());
	}
}
