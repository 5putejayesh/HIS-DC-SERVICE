package com.jayesh.his.dc.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {
	@Id
	private Integer planCatId;
	private String planCatName;
	private String activeSW;
	private LocalDate createDate;
	private LocalDate updateDate;
	private String createdBy;
	private String updatedBy;

}
