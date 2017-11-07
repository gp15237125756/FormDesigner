package com.ld.codeGenerate.factory;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.ld.codeGenerate.utils.CodeResourceUtil;

import freemarker.cache.SoftCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * base code factory
 * encapsulate basic variables which could be rendered on ftl template lately.
 * the factory abstract the produce method as basic method,which can be override 
 * by specified sub class.
 * At this moment,only single table code generator is implemented.
 * In regard of one to many & one to one canonical object mapping,they can be extended 
 * depends on {@code OneTableCodeFactory}
 * @see {@code OneTableCodeFactory}
 * @author Cruz 
 * @version 1.0
 */
public abstract class BaseCodeFactory {
	
	private static Configuration config=new Configuration();
	protected static String PROJECT_PATH="Cruz";
	protected static String AUTHOR="Cruz";
	protected static Date CREATE_DATE=new Date();
	protected static String VERSION="1.0";
	protected static String TABLE_NAME="";
	protected static boolean routeXmlFlag=false;
	protected static boolean actionFlag=false;
	protected static boolean serviceIFlag=false;
	protected static boolean entityFlag=false;
	protected static boolean dtoFlag=false;
	protected static boolean daoFlag=false;
	protected static boolean searchDtoFlag=false;
	protected static boolean serviceImplFlag=false;
	protected static boolean jspFlag=false;
	protected static boolean jsFlag=false;
	static{
		config.setClassForTemplateLoading(BaseCodeFactory.class,
				CodeResourceUtil.FREEMARKER_CLASSPATH);
		config.setLocale(Locale.CHINA);
		config.setDefaultEncoding("UTF-8");
		config.setCacheStorage(new SoftCacheStorage());
		TABLE_NAME=CodeResourceUtil.tableName;
		routeXmlFlag=CodeResourceUtil.routeXmlFlag;
		actionFlag=CodeResourceUtil.actionFlag;
		serviceIFlag=CodeResourceUtil.serviceIFlag;
		entityFlag=CodeResourceUtil.entityFlag;
		dtoFlag=CodeResourceUtil.dtoFlag;
		daoFlag=CodeResourceUtil.daoFlag;
		searchDtoFlag=CodeResourceUtil.searchDtoFlag;
		serviceImplFlag=CodeResourceUtil.serviceImplFlag;
		jspFlag=CodeResourceUtil.jspFlag;
		jsFlag=CodeResourceUtil.jsFlag;
	}
	
	abstract BaseCodeFactory wrapCommonData(final Map<String,Object> data);
	
	abstract BaseCodeFactory wrapDtoData(final Map<String,Object> data);
	
	abstract BaseCodeFactory wrapSearchDtoData(final Map<String,Object> data);
	
	abstract BaseCodeFactory wrapDaoData(final Map<String,Object> data);
	
	abstract BaseCodeFactory wrapServiceData(final Map<String,Object> data);
	
	abstract BaseCodeFactory wrapActionData(final Map<String,Object> data);
	
	abstract BaseCodeFactory wrapXmlData(final Map<String,Object> data);
	
	abstract BaseCodeFactory wrapJspData(final Map<String,Object> data);
	
	public abstract void produce() throws TemplateException, IOException;
		

	public static Configuration getConfig() {
		return config;
	}

	public static void setConfig(Configuration config) {
		BaseCodeFactory.config = config;
	}
	
	public static Template getTemplate(String templateName) throws IOException{
		return config.getTemplate(templateName);
	}
	
	public static void clearTemplateCache(){
		config.clearTemplateCache();
	}
	
}
