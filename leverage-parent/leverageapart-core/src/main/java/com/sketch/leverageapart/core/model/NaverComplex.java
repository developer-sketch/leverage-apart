package com.sketch.leverageapart.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class NaverComplex {
	@JsonProperty("complexNo")
	@Id private String id;
	@JsonProperty("complexName")
	private String name;
	@JsonProperty("cortarNo")
	private String areaId;
	
	private String deepLink;
	private String highFloor;
	private float latitude;
	private float longitude;
	private float maxSupplyArea;
	private float maxTotalArea;
	private float minSupplyArea;
	private float minTotalArea;
	private float maxSupplyPyung;
	private float maxTotalPyung;
	private float minSupplyPyung;
	private float minTotalPyung;
	private int totalDongCount;
	private int totalHouseholdCount;
	private String useApproveYmd;
}
