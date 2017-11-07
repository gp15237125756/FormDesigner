package com.ld.codeGenerate.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * code generate type
 * @author Cruz
 *
 */
public enum CodeGenType {

	SINGLE("单表",0),ONE_TO_MANY("一对多",1),ONE_TO_ONE("一对一",2);
	
	private String name;
	
	private Integer type;

	private CodeGenType(String name, Integer type) {
		this.name = name;
		this.type=type;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
