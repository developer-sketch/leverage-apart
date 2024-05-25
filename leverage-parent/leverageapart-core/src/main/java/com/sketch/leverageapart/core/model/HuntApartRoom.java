package com.sketch.leverageapart.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class HuntApartRoom {
	@Id private int id;
	private int dong;
	private int ho;
}
