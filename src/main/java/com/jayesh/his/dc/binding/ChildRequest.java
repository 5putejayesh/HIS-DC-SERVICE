package com.jayesh.his.dc.binding;

import java.util.List;

import lombok.Data;

@Data
public class ChildRequest {

	private Long caseNo;
	private List<Child> childs;
}
