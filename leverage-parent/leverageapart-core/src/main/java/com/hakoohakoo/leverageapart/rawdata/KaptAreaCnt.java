package com.hakoohakoo.leverageapart.rawdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KaptAreaCnt {
	@JsonProperty("KAPTDA_CNT")
	private String count;

	@JsonProperty("AREA_GBN")
	private String areaType;
}
