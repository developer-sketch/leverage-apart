package com.hakoohakoo.leverageapart.rawdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="header")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartRawCodeHeader {
	@XmlElement private String resultCode;
	@XmlElement private String resultMsg;
}
