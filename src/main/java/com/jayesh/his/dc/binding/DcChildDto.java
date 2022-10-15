package com.jayesh.his.dc.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DcChildDto {
	private LocalDate childDOB;
	private Integer childSSN;
}
