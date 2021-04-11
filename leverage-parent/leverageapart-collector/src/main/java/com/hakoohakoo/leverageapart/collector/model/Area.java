package com.hakoohakoo.leverageapart.collector.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDoCode() {
		return doCode;
	}
	public void setDoCode(String doCode) {
		this.doCode = doCode;
	}
	public String getDoName() {
		return doName;
	}
	public void setDoName(String doName) {
		this.doName = doName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getGuCode() {
		return guCode;
	}
	public void setGuCode(String guCode) {
		this.guCode = guCode;
	}
	public String getGuName() {
		return guName;
	}
	public void setGuName(String guName) {
		this.guName = guName;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getTownId() {
		return townId;
	}
	public void setTownId(String townId) {
		this.townId = townId;
	}
	public String getNewCityId() {
		return newCityId;
	}
	public void setNewCityId(String newCityId) {
		this.newCityId = newCityId;
	}
}
