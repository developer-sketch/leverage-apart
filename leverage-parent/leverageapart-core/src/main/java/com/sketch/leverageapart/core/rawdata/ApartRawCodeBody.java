package com.sketch.leverageapart.core.rawdata;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="body")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartRawCodeBody {
	@XmlElementWrapper(name="items")
	@XmlElement(name="item") 
	private List<ApartRawCode> items;
	
	@XmlElement private int numOfRows;
	@XmlElement private int pageNo;
	@XmlElement private int totalCount;
	
	public List<ApartRawCode> getItems() {
		return this.items;
	}
}
