package com.jayesh.his.dc.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Child {
	private Integer childId;
	private LocalDate childDOB;
	private Integer childSSN;
}
