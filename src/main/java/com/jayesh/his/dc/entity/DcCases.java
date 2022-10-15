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
public class DcCases {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer caseId;
	private Integer caseNo;
	private Integer appId;
	private Integer planId;
	
	
}
