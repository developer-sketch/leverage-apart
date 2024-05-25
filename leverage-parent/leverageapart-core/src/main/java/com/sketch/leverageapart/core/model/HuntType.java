package com.sketch.leverageapart.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class HuntType {
	@Id private int id;
	private String name;
}
