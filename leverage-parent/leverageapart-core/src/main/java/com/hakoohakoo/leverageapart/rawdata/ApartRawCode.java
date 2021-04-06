package com.hakoohakoo.leverageapart.rawdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class ApartRawCode {
	@XmlElement
	private String kaptCode;
	@XmlElement
	private String kaptName;
}
