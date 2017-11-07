package com.ld.codeGenerate.pojo;
/**
 * Dto attributes descriptions
 * @author Cruz
 * @version 1.0
 */
public class DtoAttribute {
	
	private String typeName;
	
	private String fulltypeName;
	
	private String propertyName;
	
	private String getMathodName;
	
	private String setMethodName;
	
	private boolean isPrimaryKey = false;
	
	private String comment;
	
	private String columnName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getFulltypeName() {
		return fulltypeName;
	}

	public void setFulltypeName(String fulltypeName) {
		this.fulltypeName = fulltypeName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getGetMathodName() {
		return getMathodName;
	}

	public void setGetMathodName(String getMathodName) {
		this.getMathodName = getMathodName;
	}

	public String getSetMethodName() {
		return setMethodName;
	}

	public void setSetMethodName(String setMethodName) {
		this.setMethodName = setMethodName;
	}

	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	
	
}
