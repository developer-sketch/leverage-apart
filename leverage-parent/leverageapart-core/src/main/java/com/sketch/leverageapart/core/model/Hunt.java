package com.sketch.leverageapart.core.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Hunt {
	@Id private int id;
	private int huntDate;
	
	@ManyToOne
	@JoinColumn(name="hunt_type_id")
	private HuntType huntType;
	
	@ManyToOne
	@JoinColumn(name="hunt_area_id")
	private Area area;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hunt_apart_id")
	private HuntApart huntApart;
	
	@ManyToOne
	@JoinColumn(name="hunt_apart_room_id")
	private HuntApartRoom huntApartRoom;
	
	@Transient
	private Map<Integer, UserChoiceAnswer> userChoiceAnswers;
	
	@Transient
	private Map<Integer, UserEssayAnswer> userEssayAnswers;
}
