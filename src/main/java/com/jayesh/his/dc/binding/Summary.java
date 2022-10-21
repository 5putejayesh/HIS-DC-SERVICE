package com.jayesh.his.dc.binding;

import java.util.List;

import lombok.Data;

@Data
public class Summary {

	private Income income;
	private Education education;
	private List<Child> childs;
	private String plan;
}
