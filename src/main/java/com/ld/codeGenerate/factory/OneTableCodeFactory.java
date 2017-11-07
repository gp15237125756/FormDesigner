package com.ld.codeGenerate.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.ld.codeGenerate.configuration.Configuration;
import com.ld.codeGenerate.pojo.BaseMetaData;
import com.ld.codeGenerate.pojo.DtoAttribute;
import com.ld.codeGenerate.service.DatabaseMetaDataService;
import com.ld.codeGenerate.service.MysqlDatabaseMetaDataService;
import com.ld.codeGenerate.utils.CodeResourceUtil;
import com.ld.codeGenerate.utils.DateUtil;
import com.ld.codeGenerate.utils.ModelReflection;
import com.ld.codeGenerate.utils.PathUtil;
import com.ld.codeGenerate.constant.Constant;

import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * single table code factory(major table abstraction).<br>
 * construct controller,service,dao,dto,jsp,js etc. files
 * every switch ultimately externalize on file <pre><b>code_property.properties</b></pre> flexibly。
 * @author Cruz
 * @version 1.0
 */
public class OneTableCodeFactory extends BaseCodeFactory {
	
	private Configuration config=new Configuration(this);
		//whole data cached for multiple freemarker templates
	private Map<String,Object> data=new WeakHashMap<String, Object>();
	
	public OneTableCodeFactory(){
		DatabaseMetaDataService service=new MysqlDatabaseMetaDataService();
		List<BaseMetaData> metaDatas=service.select(TABLE_NAME);
		this.config.setEntityName(StringUtils.substringAfterLast(Configuration.entityFullName, "."));
		//此处实现基于Model
		this.config.setColumns(Collections.unmodifiableList(ModelReflection.reflectProperties(Configuration.entityFullName)));
		//重置Model中文名称
		ModelReflection.retriveComment(this.config.getColumns(),metaDatas);
		this.config.setPkName(ModelReflection.getPrimaryKeyPropertyName(this.config.getColumns()));
		this.config.setDtoName(this.config.getEntityName()+"Dto");
		this.config.setSearch_dtoName(this.config.getEntityName()+"SearchDto");
		this.config.setDaoName(this.config.getEntityName()+"Dao");
		this.config.setServiceName(this.config.getEntityName()+"Service");
		this.config.setActionName(this.config.getEntityName()+"Action");
		this.config.setRouteXmlName(PathUtil.costructXmlFileName(Configuration.getModuleName(), this.config.getEntityName()));
		//wrap data
		this.wrapData(data);
	}
	
	public BaseCodeFactory wrapData(final Map<String,Object> data){
		return this.wrapCommonData(data).wrapDtoData(data).wrapSearchDtoData(data)
				.wrapDaoData(data).wrapServiceData(data).wrapActionData(data)
				.wrapXmlData(data).wrapJspData(data);
	}
	
	
	/** wrap engine data*/
	public BaseCodeFactory wrapCommonData(final Map<String,Object> data){
		data.put("moduleURI", Configuration.moduleURI);
		data.put("moduleName", Configuration.moduleName);
		data.put("moduleChName", Configuration.moduleChName);
		data.put("pkName", this.config.getPkName());
		data.put("entityFullName", Configuration.getEntityFullName());
		data.put("entityName", this.config.getEntityName());
		data.put("create_time", DateUtil.dateToString(CREATE_DATE, Constant.DB_FORMAT_DATE_TIME));
		data.put("description", this.config.getEntityName()+" "+"Dto");
		data.put("author", AUTHOR);
		data.put("version", VERSION);
		data.put("columns", this.config.getColumns());
		return this;
		
	}
	
	public BaseCodeFactory wrapDtoData(final Map<String,Object> data){
		data.put("dtoPackageURL", Configuration.dtoPackageURL);
		data.put("dtoPackageName", Configuration.dtoPackageName);
		data.put("dtoName", this.config.getDtoName());
		return this;
	}
	
	public BaseCodeFactory wrapSearchDtoData(final Map<String,Object> data){
		List<DtoAttribute> dtoColumns=ModelReflection.filterProperties(this.config.getColumns());
		data.put("search_dtoName", this.config.getSearch_dtoName());
		data.put("dtoColumns", dtoColumns);
		return this;
	}
	
	public BaseCodeFactory wrapDaoData(final Map<String,Object> data){
		data.put("daoPackageName", Configuration.daoPackageName);
		data.put("daoName", this.config.getDaoName());
		return this;
	}
	
	public BaseCodeFactory wrapServiceData(final Map<String,Object> data){
		List<DtoAttribute> updateColumns=ModelReflection.filterUpdateProperties(this.config.getColumns());
		data.put("servicePackageName", Configuration.servicePackageName);
		data.put("pkPropertyName", Configuration.servicePackageName);
		data.put("updateColumns", updateColumns);
		return this;
	}
	
	public BaseCodeFactory wrapActionData(final Map<String,Object> data){
		data.put("actionPackageName", Configuration.actionPackageName);
		data.put("actionName", this.config.getActionName());
		return this;
	}
	
	public BaseCodeFactory wrapXmlData(final Map<String,Object> data){
		List<String> separateEntityWrods=PathUtil.splitCamelCaseString(this.config.getEntityName());
		data.put("separateEntityWrods", separateEntityWrods);
		return this;
	}
	
	public BaseCodeFactory wrapJspData(final Map<String,Object> data){
		List<DtoAttribute> searchColumns=ModelReflection.filterJspSearchProperties(this.config.getColumns());
		data.put("searchColumns", searchColumns);
		return this;
	}
	
	
	@Override
	public void produce() throws TemplateException, IOException {
		if(BaseCodeFactory.dtoFlag){
			this.generateDtoFile(Configuration.dtoTemplateName,data);
		}
		
		if(BaseCodeFactory.searchDtoFlag){
			this.generateSearchDtoFile(Configuration.searchDtoTemplateName,data);
		}
		
		if(BaseCodeFactory.daoFlag){
			this.generateDaoFile(Configuration.daoTemplateName,data);
		}
		
		if(BaseCodeFactory.serviceImplFlag){
			this.generateServiceFile(Configuration.serviceTemplateName,data);
		}
		
		if(BaseCodeFactory.actionFlag){
			this.generateActionFile(Configuration.actionTemplateName,data);
		}
		
		if(BaseCodeFactory.routeXmlFlag){
			this.generateRouteXmlFile(Configuration.routeXmlTemplateName,data);
		}
		
		if(BaseCodeFactory.jspFlag){
			this.generateJspManageFile(Configuration.jspManageTemplateName,data);
			this.generateJspRegisterFile(Configuration.jspRegisterTemplateName,data);
			this.generateJspResultFile(Configuration.jspResultTemplateName,data);
		}
		
		if(BaseCodeFactory.jsFlag){
			this.generateJsManageFile(Configuration.jsManageTemplateName,data);
			this.generateJsRegisterFile(Configuration.jsRegisterTemplateName,data);
		}
	}
	
	/** generate file by template*/
	public void generateDtoFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getDtoPath(entityName,Configuration.file_seperator,Configuration.dtoPackageURL,this.config.getDtoName(),Configuration.suffix);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	/** generate file by template*/
	public void generateSearchDtoFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getSearchDtoPath(entityName,Configuration.file_seperator,Configuration.dtoPackageURL,this.config.getSearch_dtoName(),Configuration.suffix);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateDaoFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getDaoPath(entityName,Configuration.file_seperator,Configuration.daoPackageURL,this.config.getDaoName(),Configuration.suffix);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	
	public void generateServiceFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getDaoPath(entityName,Configuration.file_seperator,Configuration.servicePackageURL,this.config.getServiceName(),Configuration.suffix);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateActionFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getDaoPath(entityName,Configuration.file_seperator,Configuration.actionPackageURL,this.config.getActionName(),Configuration.suffix);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateRouteXmlFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getXmlPath(entityName,Configuration.file_seperator,Configuration.routeXmlPackageURL,this.config.getRouteXmlName());
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateJspManageFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getJspManagePath(entityName,Configuration.file_seperator,Configuration.jspPackageURL);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateJspRegisterFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getJspRegisterPath(entityName,Configuration.file_seperator,Configuration.jspPackageURL);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateJspResultFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getJspResultPath(entityName,Configuration.file_seperator,Configuration.jspPackageURL);
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateJsManageFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getJsPath(entityName,Configuration.file_seperator,Configuration.jsPackageURL,"manage");
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
	
	public void generateJsRegisterFile(String templateFileName,Map<String,Object> data)
			throws TemplateException, IOException {
		String entityName = data.get("entityName").toString();
		String fileNamePath = PathUtil.getJsPath(entityName,Configuration.file_seperator,Configuration.jsPackageURL,"register");
		String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
		Template template = getTemplate(
				templateFileName);
		OutputStreamWriter out = null ;
		try {
			FileUtils.forceMkdir(new File(fileDir + "/"));
			out = new OutputStreamWriter(
					new FileOutputStream(fileNamePath),
					CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException arg9) {
			arg9.printStackTrace();
			throw arg9;
		} catch (IOException arg10) {
			arg10.printStackTrace();
			throw arg10;
		}finally{
			out.close();
		}
	}
}
