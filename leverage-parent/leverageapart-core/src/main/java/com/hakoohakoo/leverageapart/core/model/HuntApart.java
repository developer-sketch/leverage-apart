package com.hakoohakoo.leverageapart.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class HuntApart {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String huntAreaId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="naver_complex_id")
	private NaverComplex naverComplex;
}
