package com.ld.codeGenerate.configuration;

import java.util.List;

import com.ld.codeGenerate.factory.BaseCodeFactory;
import com.ld.codeGenerate.pojo.DtoAttribute;
import com.ld.codeGenerate.utils.CodeResourceUtil;

public class Configuration {
	
	private BaseCodeFactory baseCodeFactory;
	private String pkName ;
	private String entityName;  //entity simple name
	private String dtoName;  //entity simple name
	private String daoName;  //entity simple name
	private String serviceName;  //entity simple name
	private String actionName;
	private String routeXmlName;
	private String search_dtoName;  //entity simple name
	public static String file_seperator="/";
	public static String suffix=".java";
	public static String dtoTemplateName="single_dtoTemplate.ftl";
	public static String searchDtoTemplateName="single_searchDtoTemplate.ftl";
	public static String daoTemplateName="single_daoTemplate.ftl";
	public static String serviceTemplateName="single_serviceTemplate.ftl";
	public static String actionTemplateName="single_actionTemplate.ftl";
	public static String routeXmlTemplateName="single_routeXmlTemplate.ftl";
	public static String jspManageTemplateName="single_jspManageTemplate.ftl";
	public static String jspRegisterTemplateName="single_jspRegisterTemplate.ftl";
	public static String jspResultTemplateName="single_jspResultTemplate.ftl";
	public static String jsManageTemplateName="single_jsManageTemplate.ftl";
	public static String jsRegisterTemplateName="single_jsRegisterTemplate.ftl";
	public static String dtoPackageURL = CodeResourceUtil.DTO_URL;
	public static String daoPackageURL = CodeResourceUtil.DAO_URL;
	public static String servicePackageURL = CodeResourceUtil.SERVICE_URL;
	public static String actionPackageURL = CodeResourceUtil.ACTION_URL;
	public static String routeXmlPackageURL = CodeResourceUtil.ROUTE_XML_URL;
	public static String jspPackageURL = CodeResourceUtil.JSP_URL;
	public static String jsPackageURL = CodeResourceUtil.JS_URL;
	public static String entityFullName=CodeResourceUtil.entityFullName; //entity full name
	public static String moduleName=CodeResourceUtil.moduleName;
	public static String moduleChName=CodeResourceUtil.module_name_ch;
	public static String moduleURI=CodeResourceUtil.MODULE_URL_INX;
	public static String dtoPackageName=CodeResourceUtil.DTO_URL_INX;
	public static String daoPackageName=CodeResourceUtil.DAO_URL_INX;
	public static String servicePackageName=CodeResourceUtil.SERVICE_URL_INX;
	public static String actionPackageName=CodeResourceUtil.ACTION_URL_INX;
	public List<DtoAttribute> columns; //columns for all properties
	
	public Configuration(BaseCodeFactory baseCodeFactory){
		this.baseCodeFactory=baseCodeFactory;
	}

	public BaseCodeFactory getBaseCodeFactory() {
		return baseCodeFactory;
	}

	public void setBaseCodeFactory(BaseCodeFactory baseCodeFactory) {
		this.baseCodeFactory = baseCodeFactory;
	}

	public String getPkName() {
		return pkName;
	}

	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getDtoName() {
		return dtoName;
	}

	public void setDtoName(String dtoName) {
		this.dtoName = dtoName;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getRouteXmlName() {
		return routeXmlName;
	}

	public void setRouteXmlName(String routeXmlName) {
		this.routeXmlName = routeXmlName;
	}

	public String getSearch_dtoName() {
		return search_dtoName;
	}

	public void setSearch_dtoName(String search_dtoName) {
		this.search_dtoName = search_dtoName;
	}

	public static String getFile_seperator() {
		return file_seperator;
	}

	public static void setFile_seperator(String file_seperator) {
		Configuration.file_seperator = file_seperator;
	}

	public static String getSuffix() {
		return suffix;
	}

	public static void setSuffix(String suffix) {
		Configuration.suffix = suffix;
	}

	public static String getDtoTemplateName() {
		return dtoTemplateName;
	}

	public static void setDtoTemplateName(String dtoTemplateName) {
		Configuration.dtoTemplateName = dtoTemplateName;
	}

	public static String getSearchDtoTemplateName() {
		return searchDtoTemplateName;
	}

	public static void setSearchDtoTemplateName(String searchDtoTemplateName) {
		Configuration.searchDtoTemplateName = searchDtoTemplateName;
	}

	public static String getDaoTemplateName() {
		return daoTemplateName;
	}

	public static void setDaoTemplateName(String daoTemplateName) {
		Configuration.daoTemplateName = daoTemplateName;
	}

	public static String getServiceTemplateName() {
		return serviceTemplateName;
	}

	public static void setServiceTemplateName(String serviceTemplateName) {
		Configuration.serviceTemplateName = serviceTemplateName;
	}

	public static String getActionTemplateName() {
		return actionTemplateName;
	}

	public static void setActionTemplateName(String actionTemplateName) {
		Configuration.actionTemplateName = actionTemplateName;
	}

	public static String getRouteXmlTemplateName() {
		return routeXmlTemplateName;
	}

	public static void setRouteXmlTemplateName(String routeXmlTemplateName) {
		Configuration.routeXmlTemplateName = routeXmlTemplateName;
	}

	public static String getJspManageTemplateName() {
		return jspManageTemplateName;
	}

	public static void setJspManageTemplateName(String jspManageTemplateName) {
		Configuration.jspManageTemplateName = jspManageTemplateName;
	}

	public static String getJspRegisterTemplateName() {
		return jspRegisterTemplateName;
	}

	public static void setJspRegisterTemplateName(String jspRegisterTemplateName) {
		Configuration.jspRegisterTemplateName = jspRegisterTemplateName;
	}

	public static String getJspResultTemplateName() {
		return jspResultTemplateName;
	}

	public static void setJspResultTemplateName(String jspResultTemplateName) {
		Configuration.jspResultTemplateName = jspResultTemplateName;
	}

	public static String getJsManageTemplateName() {
		return jsManageTemplateName;
	}

	public static void setJsManageTemplateName(String jsManageTemplateName) {
		Configuration.jsManageTemplateName = jsManageTemplateName;
	}

	public static String getJsRegisterTemplateName() {
		return jsRegisterTemplateName;
	}

	public static void setJsRegisterTemplateName(String jsRegisterTemplateName) {
		Configuration.jsRegisterTemplateName = jsRegisterTemplateName;
	}

	public static String getDtoPackageURL() {
		return dtoPackageURL;
	}

	public static void setDtoPackageURL(String dtoPackageURL) {
		Configuration.dtoPackageURL = dtoPackageURL;
	}

	public static String getDaoPackageURL() {
		return daoPackageURL;
	}

	public static void setDaoPackageURL(String daoPackageURL) {
		Configuration.daoPackageURL = daoPackageURL;
	}

	public static String getServicePackageURL() {
		return servicePackageURL;
	}

	public static void setServicePackageURL(String servicePackageURL) {
		Configuration.servicePackageURL = servicePackageURL;
	}

	public static String getActionPackageURL() {
		return actionPackageURL;
	}

	public static void setActionPackageURL(String actionPackageURL) {
		Configuration.actionPackageURL = actionPackageURL;
	}

	public static String getRouteXmlPackageURL() {
		return routeXmlPackageURL;
	}

	public static void setRouteXmlPackageURL(String routeXmlPackageURL) {
		Configuration.routeXmlPackageURL = routeXmlPackageURL;
	}

	public static String getJspPackageURL() {
		return jspPackageURL;
	}

	public static void setJspPackageURL(String jspPackageURL) {
		Configuration.jspPackageURL = jspPackageURL;
	}

	public static String getJsPackageURL() {
		return jsPackageURL;
	}

	public static void setJsPackageURL(String jsPackageURL) {
		Configuration.jsPackageURL = jsPackageURL;
	}

	public static String getEntityFullName() {
		return entityFullName;
	}

	public static void setEntityFullName(String entityFullName) {
		Configuration.entityFullName = entityFullName;
	}

	public static String getModuleName() {
		return moduleName;
	}

	public static void setModuleName(String moduleName) {
		Configuration.moduleName = moduleName;
	}

	public static String getModuleChName() {
		return moduleChName;
	}

	public static void setModuleChName(String moduleChName) {
		Configuration.moduleChName = moduleChName;
	}

	public static String getModuleURI() {
		return moduleURI;
	}

	public static void setModuleURI(String moduleURI) {
		Configuration.moduleURI = moduleURI;
	}

	public static String getDtoPackageName() {
		return dtoPackageName;
	}

	public static void setDtoPackageName(String dtoPackageName) {
		Configuration.dtoPackageName = dtoPackageName;
	}

	public static String getDaoPackageName() {
		return daoPackageName;
	}

	public static void setDaoPackageName(String daoPackageName) {
		Configuration.daoPackageName = daoPackageName;
	}

	public static String getServicePackageName() {
		return servicePackageName;
	}

	public static void setServicePackageName(String servicePackageName) {
		Configuration.servicePackageName = servicePackageName;
	}

	public static String getActionPackageName() {
		return actionPackageName;
	}

	public static void setActionPackageName(String actionPackageName) {
		Configuration.actionPackageName = actionPackageName;
	}

	public List<DtoAttribute> getColumns() {
		return columns;
	}

	public void setColumns(List<DtoAttribute> columns) {
		this.columns = columns;
	}
	
	
	
}
