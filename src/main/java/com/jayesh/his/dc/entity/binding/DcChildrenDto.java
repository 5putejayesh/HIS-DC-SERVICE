package com.jayesh.his.dc.entity.binding;

import java.util.Set;

import lombok.Data;
@Data
public class DcChildrenDto {

	private Integer caseNo;
	private Set<DcChildDto> children;
}
