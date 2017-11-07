/*******************************************************************************
 * ${actionName}.java 1.0
 *
 * Copyright 2014 by LD, Ltd. All right reserved.
 *
 *	2017/09/19 Cruz
 *******************************************************************************/
package ${actionPackageName};
<#-- Action共通import代码生成 -->
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
<#-- Action业务import代码生成 -->
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import com.ld.basic.entity.CodeType;
import com.ld.common.exception.ExclusiveException;
import com.ld.common.web.BasicActionSupport;

import ${moduleURI}.${moduleName?cap_first}Constants;
import ${entityFullName};
import ${daoPackageName}.${daoName};
import ${dtoPackageName}.${dtoName};
import ${dtoPackageName+ '.search'}.${search_dtoName};
import ${servicePackageName}.${entityName}Service;




/**   
 * @Title: ${moduleChName+'Action'}   
 * @Description: ${moduleChName+' Action'}
 * @author ${author}
 * @date   ${create_time}
 * @version ${version}
 *
 */
@Controller
@Scope("prototype")
public class ${actionName} extends BasicActionSupport {
	/** 序列ID */
	private static final long serialVersionUID = 2020103147209065573L;
	
	@Autowired
	private ${dtoName} ${dtoName?uncap_first};
	@Autowired
	private ${entityName}Service ${entityName?uncap_first}Service;
	//search dto
	private ${search_dtoName} ${search_dtoName?uncap_first};
	//search result
	private Page<${dtoName}> ${dtoName?uncap_first+ 's'};

	/**
	 * 画面初期表示
	 * @return String
	 * @since 01-00
	 */
	public String init() {
		// 权限验证
		// 验证出错设置出错信息
		// 验证出错返回error画面
		return SUCCESS;
	}

	/**
	 * ${moduleChName}查询
	 * @return String
	 * @since 01-00
	 */
	public String ${entityName?uncap_first}Search() {
		// 权限验证
		// 验证出错设置出错信息
		// 验证出错返回error画面
		${dtoName?uncap_first+ 's'}=${entityName?uncap_first}Service.search${entityName}(${search_dtoName?uncap_first},this.pb);
		return SUCCESS;
	}
	
	/**
	 * ${moduleChName}登记画面初期化
	 * @return String
	 * @since 01-00
	 */
	public String ${entityName?uncap_first}RegisterInit() {
		// 权限验证
		// 验证出错设置出错信息
		// 验证出错返回error画面
		return SUCCESS;
	}
	
	/**
	 * @return String
	 * @since 01-00
	 */
	@SuppressWarnings("unchecked")
	public String ${entityName?uncap_first}Delete() {
		// 权限验证
		// 验证出错设置出错信息
		// 验证出错返回error画面
		if(${dtoName?uncap_first}==null){
			return error400();
		}
		//default no exception
		String msg="${moduleChName}删除成功！"; 
		try{
			${dtoName?uncap_first}=${entityName?uncap_first}Service.delete${entityName}(${dtoName?uncap_first});
			resultJson.setResult(true);
		}catch(ExclusiveException exclusive){
			exclusive.printStackTrace();
			msg="请求的资源已经被他人修改，请重新查询！"; 
		}catch(Exception ex){
			ex.printStackTrace();
			msg="${moduleChName}删除失败，请联系管理员！"; 
		}
		resultJson.setMessage(msg);
		return SUCCESS;
	}
	
	/**
	 * @return String
	 * @since 01-00
	 */
	@SuppressWarnings("unchecked")
	public String ${entityName?uncap_first}Edit() {
		if(${dtoName?uncap_first}==null){
			return error400();
		}
		${dtoName?uncap_first}=${entityName?uncap_first}Service.find${entityName}(${dtoName?uncap_first});
		resultJson.setResult(true);
		resultJson.setData(${dtoName?uncap_first});
		return SUCCESS;
	}
	
	/**
	 * @return String
	 * @since 01-00
	 */
	@SuppressWarnings("unchecked")
	public String ${entityName?uncap_first}Show() {
		if(${dtoName?uncap_first}==null){
			return error400();
		}
		${dtoName?uncap_first}=${entityName?uncap_first}Service.findMemberArticle(${dtoName?uncap_first});
		resultJson.setResult(true);
		resultJson.setData(${dtoName?uncap_first});
		return SUCCESS;
	}

	/**
	 * @return String
	 * @since 01-00
	 */
	@SuppressWarnings("unchecked")
	public String ${entityName?uncap_first}Save() {
		// 权限验证
		// 验证出错设置出错信息
		// 验证出错返回error画面
		if(${dtoName?uncap_first}==null){
			return error400();
		}
		//default no exception
		String hintMsg=null,typeMsg=null;
		if(${dtoName?uncap_first}.get${pkName?cap_first}()==null){
			typeMsg="保存";
		}else{
			typeMsg="修改";
		}
		try{
			${entityName?uncap_first}Service.save${entityName}(${dtoName?uncap_first});
			resultJson.setResult(true);
			hintMsg="${moduleChName}"+typeMsg+"成功！";
		}catch(ExclusiveException exclusive){
			exclusive.printStackTrace();
			hintMsg="请求的资源已经被他人修改，请重新查询！"; 
		}catch(Exception ex){
			ex.printStackTrace();
			hintMsg="${moduleChName}"+typeMsg+"失败，请联系管理员！"; 
		}
		resultJson.setMessage(hintMsg);
		return SUCCESS;
	}

	public ${dtoName} getMemberArticleDto() {
		return ${dtoName?uncap_first};
	}

	public void set${dtoName}(${dtoName} ${dtoName?uncap_first}) {
		this.${dtoName?uncap_first} = ${dtoName?uncap_first};
	}


	public ${search_dtoName} get${search_dtoName}() {
		return ${search_dtoName?uncap_first};
	}

	public void set${search_dtoName}(
			${search_dtoName} ${search_dtoName?uncap_first}) {
		this.${search_dtoName?uncap_first} = ${search_dtoName?uncap_first};
	}

	public Page<${dtoName}> get${dtoName}s() {
		return ${dtoName?uncap_first+ 's'};
	}

	public void set${dtoName}s(Page<${dtoName}> ${dtoName?uncap_first+ 's'}) {
		this.${dtoName?uncap_first+ 's'} = ${dtoName?uncap_first+ 's'};
	}
	
}
