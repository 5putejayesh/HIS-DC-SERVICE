package com.jayesh.his.dc.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name ="DC_INCOME")
public class DcIncome {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer incomeId;
	private Integer caseNo;
	private Integer empIncome;
	private Integer propertyIncome;
}
