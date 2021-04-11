package com.hakoohakoo.leverageapart.core.rawdata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KaptResponse {
	@JsonProperty
	private Kapt kapt;
	@JsonProperty
	private List<KaptPyong> pyongList;
}
