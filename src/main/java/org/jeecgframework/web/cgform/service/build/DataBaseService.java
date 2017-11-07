package org.jeecgframework.web.cgform.service.build;

import java.util.List;
import java.util.Map;

import org.jeecgframework.web.cgform.entity.enhance.CgformEnhanceJavaEntity;
import org.jeecgframework.web.cgform.exception.BusinessException;

/**
 * 
 * @author  张代浩
 *
 */
public interface DataBaseService {

	public void insertTable(String tableName, Map<String, Object> data) throws BusinessException ;
	/** 返回key*/
	public Object getInsertTableKey(String tableName, Map<String, Object> data) throws BusinessException ;

	public int updateTable(String tableName,Object id, Map<String, Object> data) throws BusinessException ;

	public int updateTable(String tableName,Object id,String pkName, Map<String, Object> data) throws BusinessException ;
	
	public Map<String, Object>  findOneForJdbc(String tableName, String id);
	
	public Map<String, Object>  findOneForJdbc(String tableName, String id, String pkName);
	
	public Map<String, Object> insertTableMore(Map<String,List<Map<String,Object>>> mapMore,String mainTableName) throws BusinessException;
	
	public Map<String, Object> insertTableMore(Map<String,List<Map<String,Object>>> mapMore,String mainTableName,String pkName) throws BusinessException;

	
	public boolean updateTableMore(Map<String,List<Map<String,Object>>> mapMore,String mainTableName) throws BusinessException;
	
	public boolean updateTableMore(Map<String,List<Map<String,Object>>> mapMore,String mainTableName,String pkName) throws BusinessException;
	
	/**
	 * sql业务增强
	 * 
	 */
	public void executeSqlExtend(String formId,String buttonCode,Map<String, Object> data);

	public Object getPkValue(String tableName);

	/**
	 * java业务增强
	 * @param formId
	 * @param buttonCode
	 * @param data
	 */
	public void executeJavaExtend(String formId, String buttonCode,Map<String, Object> data) throws BusinessException;

	public List<CgformEnhanceJavaEntity> getCgformEnhanceJavaEntityByFormId(String formId);

}
