package com.hakoohakoo.leverageapart.rawdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;

@Getter
@XmlRootElement(name = "response")
public class ApartRawCodeResponse {
	@XmlElement private ApartRawCodeHeader header;
	@XmlElement private ApartRawCodeBody body;
}
