package com.jayesh.his.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_CASES")
public class DcCase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer caseId;
	//@GeneratedValue-->try this to generate caseNo
	private Long caseNo;
	private Integer appId;
	private Integer planId;
	
	
}
