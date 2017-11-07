package com.ld.codeGenerate.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ld.codeGenerate.pojo.BaseMetaData;
import com.ld.codeGenerate.pojo.MysqlMetaData;
/**
 * TABLE_COLUMN -> TABLES
 * @author Cruz
 * @version 1.0
 *
 */
public class MysqlDatabaseMetaDataService implements DatabaseMetaDataService{

	  private static final String DRIVER = "com.mysql.jdbc.Driver";

	  private static final String URL = "jdbc:mysql://192.168.1.87/ld_wenbo_pingtai";

	  private static final String USERNAME = "root";

	  private static final String PASSWORD = "root";

	 
	@Override
	public  List<BaseMetaData> select(String tableName) {
		List<BaseMetaData> resultList=new LinkedList<BaseMetaData>();
		Connection connection=null;
		 try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    DatabaseMetaData metadata = connection.getMetaData();
		    ResultSet resultSet = metadata.getColumns(null, null, tableName, null);
		    while (resultSet.next()) {
		      BaseMetaData meta=new MysqlMetaData();
		      String schema = resultSet.getString("TABLE_SCHEM");
		      String tName = resultSet.getString("TABLE_NAME");
		      String name = resultSet.getString("COLUMN_NAME");
		      String type = resultSet.getString("TYPE_NAME");
		      int size = resultSet.getInt("COLUMN_SIZE");
		      int nullable = resultSet.getInt("NULLABLE");
		      String columnComment = resultSet.getString("REMARKS");
		      String columnDefault = resultSet.getString("COLUMN_DEF");
		      meta.setTableSchema(schema);
		      meta.setTableName(tName);
		      meta.setColumnName(name);
		      meta.setColumnSize(size);
		      meta.setColumnType(type);
		      meta.setIsNullable(nullable);
		      meta.setColumnDefault(columnDefault);
		      meta.setColumnComment(columnComment);
		      resultList.add(meta);
		    }
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
		 }
	   return resultList;
	}
	
	 public static void main(String[] args) throws Exception {
		 new MysqlDatabaseMetaDataService().select("t145");
	  }

}
