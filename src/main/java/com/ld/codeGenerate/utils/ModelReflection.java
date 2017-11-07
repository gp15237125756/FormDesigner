package com.ld.codeGenerate.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Id;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.ld.codeGenerate.pojo.BaseMetaData;
import com.ld.codeGenerate.pojo.DtoAttribute;

/**
 * reflect utility，which fetch fundamental properties from domain model.<br>
 * In fact,the model properties should have been fetched from database meta data,
 * for some reason,the database column  is not named semantically,
 * so the property name is got from entity.<br>
 * Also,the Chinese property name can be fetched from  column comment of Table if available
 * (if unavailable,use English property name as substitute).
 * @author Cruz
 * @version 1.0
 *
 */
public class ModelReflection {

	private static Log logger=LogFactory.getLog(ModelReflection.class);
	/**
	 * reflect from Class
	 * @param classFullName
	 * @return {List<DtoAttribute>}
	 */
	public static List<DtoAttribute> reflectProperties(final String classFullName){
		List<DtoAttribute> list=new LinkedList<DtoAttribute>();
		Assert.notNull(classFullName, "the input class full name must not be null!");
		Class<?> cls=null;
		BeanInfo beanInfo = null;
		try {
			//load class
			cls=Class.forName(classFullName);
		} catch (ClassNotFoundException e) {
			if(logger.isErrorEnabled()){
				logger.error("Class load fail,please check out the input property entityFullName with full name ["+classFullName+"]");
			}
			return list;
		}
		try {
			beanInfo = Introspector.getBeanInfo(cls);
		} catch (IntrospectionException arg3) {
			if(logger.isErrorEnabled()){
			logger.error(
					"Error when inspecting class " + cls,
					arg3);
			}
			return list;
		}
		final PropertyDescriptor[] descriptors=beanInfo.getPropertyDescriptors();
		Stream.of(descriptors).filter((o)->!StringUtils.equals("serialVersionUID", o.getName())&&!StringUtils.equals("class", o.getName())).forEach((m)->{
			DtoAttribute attr=new DtoAttribute();
			Method readMethod=m.getReadMethod();
			Id id=readMethod.getAnnotation(Id.class);
			//primary key
			if(Objects.nonNull(id)){
				attr.setPrimaryKey(true);
			}
			//column name corresponding to Table 
			Column column=readMethod.getAnnotation(Column.class);
			if(Objects.nonNull(column)&&StringUtils.isNotBlank(column.name())){
				attr.setColumnName(column.name());
			}
			attr.setTypeName(m.getPropertyType().getSimpleName());
			attr.setFulltypeName(m.getPropertyType().getCanonicalName());
			attr.setPropertyName(m.getName());
			attr.setGetMathodName(m.getReadMethod().getName());
			attr.setSetMethodName(readMethod.getName());
			list.add(attr);
		});
		return list;
		
	}
	/**
	 * filter List,Map,createDateTime,createUserId,Object,etc.
	 * @param list
	 * @return {@code List<DtoAttribute>}
	 */
	public static List<DtoAttribute> filterProperties(final List<DtoAttribute> list) {
		if(CollectionUtils.isEmpty(list)){
			return new LinkedList<DtoAttribute>();
		}
		return list.stream().filter((o)->{
			if(StringUtils.endsWithAny(o.getPropertyName(), "createDateTime","createUserId","updateDateTime","updateUserId")){
				return false;
			}
			String canonicalTypeName=o.getFulltypeName(),simpleTypeName=o.getTypeName();
			Class<?> typeClass=null;
			try {
				typeClass=ClassUtils.getClass(canonicalTypeName);
			} catch (Exception e) {
				e.printStackTrace();
				if(logger.isErrorEnabled()){
					logger.error("Class load fail!full name is "+canonicalTypeName);
				}
			}
			if(StringUtils.equals(simpleTypeName, "Date")){
				return true;
			}
			if(!ClassUtils.isPrimitiveOrWrapper(typeClass)){
				return false;
			}
			if(StringUtils.endsWithAny(simpleTypeName,"List","Map","Set","Object")){
				return false;
			}
			return true;
		}).collect(Collectors.toList());
	}
	
	
	/**
	 * filter properties which require to update.
	 * exclude createDateTime,createUserId,Id,etc.
	 * @param list
	 * @return {@code List<DtoAttribute>}
	 */
	public static List<DtoAttribute> filterUpdateProperties(final List<DtoAttribute> list) {
		if(CollectionUtils.isEmpty(list)){
			return new LinkedList<DtoAttribute>();
		}
		return list.stream().filter((o)->{
			if(StringUtils.endsWithAny(o.getPropertyName(), "createDateTime","createUserId","delFlag",getPrimaryKeyPropertyName(list))){
				return false;
			}
			String canonicalTypeName=o.getFulltypeName(),simpleTypeName=o.getTypeName();
			if(StringUtils.endsWithAny(simpleTypeName,"String","Date")){
				return true;
			}
			Class<?> typeClass=null;
			try {
				typeClass=ClassUtils.getClass(canonicalTypeName);
			} catch (Exception e) {
				e.printStackTrace();
				if(logger.isErrorEnabled()){
					logger.error("Class load fail!full name is "+canonicalTypeName);
				}
			}
			if(!ClassUtils.isPrimitiveOrWrapper(typeClass)){
				return false;
			}
			if(StringUtils.endsWithAny(simpleTypeName,"List","Map","Set","Object")){
				return false;
			}
			return true;
		}).collect(Collectors.toList());
	}
	
	
	/**
	 * filter properties which require to update.
	 * exclude createDateTime,createUserId,Id,etc.
	 * @param list
	 * @return {@code List<DtoAttribute>}
	 */
	public static List<DtoAttribute> filterJspSearchProperties(final List<DtoAttribute> list) {
		if(CollectionUtils.isEmpty(list)){
			return new LinkedList<DtoAttribute>();
		}
		return list.stream().filter((o)->{
			if(StringUtils.endsWithAny(o.getPropertyName(), "createDateTime","createUserId","updateDateTime","updateUserId","delFlag",getPrimaryKeyPropertyName(list))){
				return false;
			}
			String canonicalTypeName=o.getFulltypeName(),simpleTypeName=o.getTypeName();
			if(StringUtils.endsWithAny(simpleTypeName,"String","Date")){
				return true;
			}
			Class<?> typeClass=null;
			try {
				typeClass=ClassUtils.getClass(canonicalTypeName);
			} catch (Exception e) {
				e.printStackTrace();
				if(logger.isErrorEnabled()){
					logger.error("Class load fail!full name is "+canonicalTypeName);
				}
			}
			if(!ClassUtils.isPrimitiveOrWrapper(typeClass)){
				return false;
			}
			if(StringUtils.endsWithAny(simpleTypeName,"List","Map","Set","Object")){
				return false;
			}
			return true;
		}).collect(Collectors.toList());
	}
	
	
	/** filter primary key 
	 * @param String
	 * @return {@code List<DtoAttribute>}
	 */
	public static String getPrimaryKeyPropertyName(final List<DtoAttribute> list) {
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list.stream().filter(DtoAttribute::isPrimaryKey).findFirst().get().getPropertyName();
		 
	}
	
	
	/**
	 * reset comment for {@code DtoAttribute}
	 * @param columns
	 * @return {@code List<DtoAttribute>}
	 */
	public static List<DtoAttribute> retriveComment(final List<DtoAttribute> columns,final List<BaseMetaData> metaDatas){
		if(Objects.isNull(columns)||CollectionUtils.isEmpty(columns)){
			return new LinkedList<DtoAttribute>();
		}
		columns.stream().forEach((x)->{
			String columnName=x.getColumnName();
			for(BaseMetaData b:metaDatas){
				if(StringUtils.equals(columnName, b.getColumnName())){
					x.setComment(b.getColumnComment());
					break;
				}
			}
		});
		return columns;
	}
	
	
	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		System.out.println(ModelReflection.reflectProperties("com.stylefeng.guns.common.persistence.model.Persons").size());
	}
}
