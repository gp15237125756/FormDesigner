package com.ld.codeGenerate.pojo;

public class MysqlMetaData extends BaseMetaData {

	@Override
	public String toString() {
		return "MysqlMetaData [tableName=" + tableName + ", tableType="
				+ tableType + ", tableCatalog=" + tableCatalog
				+ ", tableSchema=" + tableSchema + ", tableComment="
				+ tableComment + ", columnName=" + columnName
				+ ", columnDefault=" + columnDefault + ", isNullable="
				+ isNullable + ", columnType=" + columnType + ", columnKey="
				+ columnKey + ", columnComment=" + columnComment
				+ ", columnSize=" + columnSize + "]";
	}

	
}
