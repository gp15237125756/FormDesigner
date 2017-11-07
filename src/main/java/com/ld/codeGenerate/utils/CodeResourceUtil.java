package com.ld.codeGenerate.utils;

import java.util.ResourceBundle;
/**
 * Code Generator Resource utility
 * this class encapsulate some basic common resource,
 * most of which is derived from .properties file.
 * As a consequence,you could launch the code generator
 * application after change the key property externally.
 * @author Cruz
 * @Date 2017/9/18 13:26
 * @version 1.0
 */
public class CodeResourceUtil {

	private static final ResourceBundle bundlePath = ResourceBundle
			.getBundle("code_templates/code_config");
	public static String FREEMARKER_CLASSPATH = "/code_templates/single";
	public static String entityFullName = "";
	public static String project_path = "d:/workspace/LongMuseum";
	public static String web_root_package = "WebRoot";
	public static String source_root_package = "src";
	public static String resource_root_package = "src";
	public static String bussiPackage = "sun";
	public static String moduleName = "";
	public static String module_name_ch ="";
	public static String entity_package = "entity";
	public static String dto_package = "dto";
	public static String dao_package = "dao";
	public static String service_package = "service";
	public static String action_package = "action";
	public static String page_package = "page";
	public static String ENTITY_URL;
	public static String DTO_URL;
	public static String DAO_URL;
	public static String SERVICE_URL;
	public static String ACTION_URL;
	public static String ROUTE_XML_URL;
	public static String JSP_URL;
	public static String JS_URL;
	public static String PAGE_URL;
	public static String MODULE_URL_INX;
	public static String ENTITY_URL_INX;
	public static String DTO_URL_INX;
	public static String DAO_URL_INX;
	public static String SERVICE_URL_INX;
	public static String ACTION_URL_INX;
	public static String PAGE_URL_INX;
	public static String TEMPLATEPATH;
	public static String CODEPATH;
	public static String JSPPATH;
	public static String SYSTEM_ENCODING;
	public static boolean routeXmlFlag;
	public static boolean actionFlag;
	public static boolean serviceIFlag;
	public static boolean entityFlag;
	public static boolean dtoFlag;
	public static boolean daoFlag;
	public static boolean searchDtoFlag;
	public static boolean serviceImplFlag;
	public static boolean jspFlag;
	public static boolean jsFlag;
	public static String tableName;
	public static Integer product_type;
	
	static{
		product_type=getProductType();
		tableName=getTableName();
		entityFullName=getEntityFullName();
		project_path=getProject_path();
		SYSTEM_ENCODING = getSYSTEM_ENCODING();
		TEMPLATEPATH = getTEMPLATEPATH();
		source_root_package = getSourceRootPackage();
		resource_root_package= getResourceRootPackage();
		web_root_package = getWebRootPackage();
		bussiPackage = getBussiPackage();
		moduleName=getModuleName();
		module_name_ch=getModuleChName();
		entity_package=getEntityPackage();
		source_root_package = source_root_package.replace(".", "/");
		resource_root_package = resource_root_package.replace(".", "/");
		web_root_package = web_root_package.replace(".", "/");
		String bussiPackageUrl = bussiPackage.replace(".", "/");//com.ld
		ENTITY_URL = source_root_package + "/" + bussiPackageUrl + "/"+moduleName+ "/"
				+ entity_package + "/";
		DTO_URL= source_root_package + "/" + bussiPackageUrl + "/"+moduleName+ "/"
				+ dto_package + "/";
		DAO_URL= source_root_package + "/" + bussiPackageUrl + "/"+moduleName+ "/"
				+ dao_package + "/";
		SERVICE_URL= source_root_package + "/" + bussiPackageUrl + "/"+moduleName+ "/"
				+ service_package + "/";
		ACTION_URL =source_root_package + "/" + bussiPackageUrl + "/"+moduleName+ "/"
				+ action_package + "/";
		ROUTE_XML_URL=resource_root_package + "/" +"struts"+"/";
		JSP_URL= web_root_package + "/" +  "WEB-INF"+"/"+"page"+"/"+moduleName+ "/";
		JS_URL=web_root_package + "/" +  "assets"+"/"+"module"+"/"+moduleName+ "/";
		PAGE_URL = source_root_package + "/" + bussiPackageUrl + "/"+moduleName+ "/"
				+ page_package + "/";
		MODULE_URL_INX= bussiPackage + "." +moduleName;
		ENTITY_URL_INX = bussiPackage + "." +moduleName+ "."+ entity_package + ".";
		DTO_URL_INX= bussiPackage + "." +moduleName+ "."+ dto_package;
		DAO_URL_INX= bussiPackage + "." +moduleName+ "."+ dao_package;
		SERVICE_URL_INX= bussiPackage + "." +moduleName+ "."+ service_package;
		ACTION_URL_INX= bussiPackage + "." +moduleName+ "."+ action_package;
		PAGE_URL_INX = bussiPackage + "."  +moduleName+ "."+ page_package + ".";
		CODEPATH = source_root_package + "/" + bussiPackageUrl + "/";
		JSPPATH = web_root_package + "/" + "webpage" + "/" + bussiPackageUrl
				+ "/";
		routeXmlFlag=getCreateFlag("routeXmlFlag");
		actionFlag=getCreateFlag("actionFlag");
		serviceIFlag=getCreateFlag("serviceIFlag");
		entityFlag=getCreateFlag("entityFlag");
		dtoFlag=getCreateFlag("dtoFlag");
		daoFlag=getCreateFlag("daoFlag");
		searchDtoFlag=getCreateFlag("searchDtoFlag");
		serviceImplFlag=getCreateFlag("serviceImplFlag");
		jspFlag=getCreateFlag("jspFlag");
		jsFlag=getCreateFlag("jsFlag");
	}
	
	
	public static final String getTableName(){
		return bundlePath.getString("table_name");
	}
	
	public static final Integer getProductType(){
		Object objV=bundlePath.getObject("product_type");
		if(objV instanceof String){
			return Integer.parseInt((String)objV);
		}
		return 0;
	}
	
	/** get boolean property*/
	public static final boolean getCreateFlag(String key) {
		Object objV=bundlePath.getObject(key);
		if(objV instanceof String){
			return Boolean.parseBoolean((String)objV);
		}
		return true;
	}
	
	public static final String getEntityFullName(){
		return bundlePath.getString("entityFullName");
	}
	
	public static final String getModuleName(){
		return bundlePath.getString("module_name");
	}
	
	public static final String getModuleChName(){
		return bundlePath.getString("module_name_ch");
	}
	
	public static final String getSYSTEM_ENCODING() {
		return bundlePath.getString("system_encoding");
	}
	
	private static String getBussiPackage() {
		return bundlePath.getString("bussi_package");
	}

	public static final String getEntityPackage() {
		return bundlePath.getString("entity_package");
	}

	public static final String getPagePackage() {
		return bundlePath.getString("page_package");
	}

	public static final String getTEMPLATEPATH() {
		return bundlePath.getString("templatepath");
	}
	
	public static final String getSourceRootPackage() {
		return bundlePath.getString("source_root_package");
	}
	
	public static final String getResourceRootPackage() {
		return bundlePath.getString("resource_root_package");
	}

	public static final String getWebRootPackage() {
		return bundlePath.getString("webroot_package");
	}
	
	public static String getProject_path() {
		String projp = bundlePath.getString("project_path");
		if (projp != null && !"".equals(projp)) {
			project_path = projp;
		}

		return project_path;
	}

	public static void setProject_path(String project_path) {
		CodeResourceUtil.project_path = project_path;
	}
	
	public static void main(String[] args) {
		System.out.println(getCreateFlag("dtoFlag"));
	}
}
