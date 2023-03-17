package com.laptrinhjavaweb.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class NewDTO extends AbstractDTO <NewDTO>{
	private String title;
	private String content;
	private String shortDescription;
	private String categoryCode;
	private String thumbnail;
}
