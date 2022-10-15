package com.jayesh.his.dc.binding;

import java.util.Set;

import lombok.Data;
@Data
public class DcChildrenDto {

	private Integer caseNo;
	private Set<DcChildDto> children;
}
