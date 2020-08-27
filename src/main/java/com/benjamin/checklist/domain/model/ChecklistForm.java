package com.benjamin.checklist.domain.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ChecklistForm {

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date registDate;	// 登録日
	
	private boolean habitNo01;	// 習慣01
	
	private boolean habitNo02;	// 習慣02
	
	private boolean habitNo03;	// 習慣03
	
	private boolean habitNo04;	// 習慣04
	
	private boolean habitNo05;	// 習慣05
	
	private boolean habitNo06;	// 習慣06
	
	private boolean habitNo07;	// 習慣07
	
	private boolean habitNo08;	// 習慣08
	
	private boolean habitNo09;	// 習慣09
	
	private boolean habitNo10;	// 習慣10
	
	private boolean habitNo11;	// 習慣11
	
	private boolean habitNo12;	// 習慣12

	private boolean habitNo13;	// 習慣13
	
}
