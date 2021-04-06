package com.hakoohakoo.leverageapart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AreaRawCode {
	@Id private String code;
	private String name;
}
