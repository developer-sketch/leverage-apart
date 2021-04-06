package com.hakoohakoo.leverageapart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Area {
	@Id private String id;
	private String doCode;
	private String doName;
	private String cityCode;
	private String cityName;
	private String guCode;
	private String guName;
	private String dongCode;
	private String dongName;
	private String townId;
	private String newCityId;
}
