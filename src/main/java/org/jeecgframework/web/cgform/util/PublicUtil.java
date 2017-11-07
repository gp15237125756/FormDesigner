package org.jeecgframework.web.cgform.util;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.util.ReflectHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.cgform.common.CgAutoListConstant;

/**
 * 公共方法
 * @author jueyue
 *
 */
public class PublicUtil {
	
	public static final String createDateTime_ColumnName="C999991";
	
	public static final String createUserId_ColumnName="C999992";
	
	public static final String updateDateTime_ColumnName="C999993";
	
	public static final String updateUserId_ColumnName="C999994";
	
	public static final String delFlag_ColumnName="C999995";
	/**
	 * 表格一般通用字段
	 * C999991-C999995
	 * @param obj
	 * @param isUpdate
	 */
	public static void addCommonForTable(final Map<String,Object> data){
		data.put(createDateTime_ColumnName, new Date());
		data.put(createUserId_ColumnName, "U000001");
		data.put(updateDateTime_ColumnName, new Date());
		data.put(updateUserId_ColumnName,"U000001");
		data.put(delFlag_ColumnName,0);
	}
	/**
	 * 表格一般通用字段
	 * C999991-C999995
	 * @param obj
	 * @param isUpdate
	 */
	public static void updateCommonForTable(final Map<String,Object> data){
		data.put(updateDateTime_ColumnName, new Date());
		data.put(updateUserId_ColumnName,"U000001");
	}
	/**
	 * 表格一般通用字段createDate,createBy,createName
	 * updateDate,updateBy,updateName
	 * @param obj
	 * @param isUpdate
	 */
	public static void setCommonForTable(Object obj, boolean isCreate){
		ReflectHelper reflectHelper=new ReflectHelper(obj);
		if(isCreate){
			reflectHelper.setMethodValue("createDate", new Date());
			reflectHelper.setMethodValue("createBy", ResourceUtil.getSessionUserName().getId());
			reflectHelper.setMethodValue("createName", ResourceUtil.getSessionUserName().getUserName());
		}
		reflectHelper.setMethodValue("updateDate", new Date());
		reflectHelper.setMethodValue("updateBy", ResourceUtil.getSessionUserName().getId());
		reflectHelper.setMethodValue("updateName", ResourceUtil.getSessionUserName().getUserName());
	}
	/**
	 * 设置checkbox的值 -- Y/N
	 * @param obj
	 * @param params 以逗号隔开  "isNull,isShow,isQuery,isKey,fieldMustInput"
	 */
	public static void judgeCheckboxValue(Object obj,String params){
		ReflectHelper reflectHelper=new ReflectHelper(obj);
		String [] paramsArr = params.split(",");
		for(int i = 0;i<paramsArr.length;i++){
		    String checked = "N";
		    if(reflectHelper.getMethodValue(paramsArr[i])!=null
		    		&&!"N".equalsIgnoreCase((String)reflectHelper.getMethodValue(paramsArr[i]))){
		    	checked = "Y";
		    }
			reflectHelper.setMethodValue(paramsArr[i],checked);
		}
		
	}

	
	/**
	 * 对比值是否相同
	 * return true(相同) false(不同)
	 */
	public static boolean compareValue(Object oldvalue,Object newvalue){
		if(oldvalue==null){
			if(newvalue!=null){
				return false;
			}
		}else{
			if(newvalue==null){
				return false;
			}else{
				if(!oldvalue.equals(newvalue)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 通过sql获取表名
	 * @param s
	 * @return
	 */
	public static String getTableName(String s){
		s = s.substring(s.indexOf("from")+4);
		if(s.indexOf("where")>1){
			s = s.substring(0, s.indexOf("where"));
		}
		return s.trim();
	}

	/**
	 * online配置表截取下划线获取真实物理表名称
	 */
	public static String replaceTableName(String tableName) {
		if(tableName.indexOf(CgAutoListConstant.ONLINE_TABLE_SPLIT_STR)> -1){
			int indexOf = tableName.indexOf(CgAutoListConstant.ONLINE_TABLE_SPLIT_STR);
			tableName = tableName.substring(0, indexOf);
			return tableName;
		}
		//否则返回原数据
		return tableName;
	}
	
	/**
	 * 获取参数主键名
	 * @param field
	 * @return String
	 */
	public static String getPrimaryKeyName(final String field){
		if(StringUtils.isBlank(field)){
			return null;
		}
		return StringUtils.split(field, ",")[0];
	}
	
	

}
