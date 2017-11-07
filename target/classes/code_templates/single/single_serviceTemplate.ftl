package ${servicePackageName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import ${moduleURI}.${moduleName?cap_first}Constants;
import ${entityFullName};
import ${daoPackageName}.${daoName};
import ${dtoPackageName}.${dtoName};
import ${dtoPackageName+ '.search'}.${search_dtoName};
import com.ld.basic.BasicConstants;
import com.ld.basic.dao.CodeTypeDao;
import com.ld.basic.entity.CodeType;
import com.ld.basic.entity.UserInfo;
import com.ld.basic.service.CodeService;
import com.ld.basic.service.NumberMasterService;
import com.ld.common.components.PageBean;
import com.ld.common.exception.ExclusiveException;
import com.ld.common.exception.ResourceNotFoundException;
import com.ld.common.utils.BeanUtils;
import com.ld.common.utils.LDSecurityUtils;
import com.ld.common.utils.SearchUtils;

/**   
 * @Title: ${moduleChName+'Service'}
 * @Description: ${moduleChName+' Service'}
 * @author ${author}
 * @date ${create_time}
 * @version ${version}
 *
 */
@Component
@Transactional(rollbackFor = java.lang.Exception.class)
public class ${entityName}Service{
	@Autowired
	private CodeService codeService;
	@Autowired
	private CodeTypeDao codeTypeDao;
	@Autowired
	private ${daoName} ${daoName?uncap_first};
	@Autowired
	private NumberMasterService numberMasterService;
	
	/**
	 * @param ${search_dtoName?uncap_first}
	 * @return List<${dtoName}>
	 */
	public Page<${dtoName}> search${entityName}(${search_dtoName} ${search_dtoName?uncap_first},PageBean pb){
		List<${dtoName}> ret=new LinkedList<${dtoName}>();
		// 定义sf-设定查询条件以及查询结果类型
		Specification<${entityName}> sf = SearchUtils.buildSpecification(${search_dtoName?uncap_first},
				${entityName}.class);
		PageRequest pageRequest = SearchUtils.buildPageRequest(pb);
		Page<${entityName}> resultPage=${daoName?uncap_first}.findAll(sf,pageRequest);
		// resultPage为null时，直接返回
		if (null == resultPage) {
			return new PageImpl<${dtoName}>(
					new ArrayList<${dtoName}>(), pageRequest, 0);
		}
		while(resultPage!=null&&resultPage.getContent().size()==0){
			if(resultPage.isFirst()){
				return new PageImpl<${dtoName}>(
						new ArrayList<${dtoName}>(), pageRequest, 0);
			}else{
				pb.setPageNumber(pb.getPageNumber()-1);
				pageRequest = SearchUtils.buildPageRequest(pb);
				resultPage = ${daoName?uncap_first}.findAll(sf, pageRequest);
			}
		}
		List<${entityName}> contents=resultPage.getContent();
		contents.forEach((m)->{
			${dtoName} dto=new ${dtoName}();
			BeanUtils.objectCopy(m, dto);
			ret.add(dto);
		});
		return  new PageImpl<${dtoName}>(ret,pageRequest,resultPage.getTotalElements());
	}
 	
 	/**
	 * @param ${dtoName?uncap_first}
	 */
	public void save${entityName}(${dtoName} ${dtoName?uncap_first}){
		UserInfo user=LDSecurityUtils.getCurrentUser();
		Long _Id=${dtoName?uncap_first}.get${pkName?cap_first}();
		//add
		if(_Id==null){
			${entityName} entity=new ${entityName}();
			BeanUtils.objectCopy(${dtoName?uncap_first}, entity);
			entity.setDelFlag(BasicConstants.DEL_FLAG_F);
			entity.setCreateDateTime(new Date());
			entity.setCreateUserId(user.getUserId());
			entity.setUpdateDateTime(new Date());
			entity.setUpdateUserId(user.getUserId());
			${daoName?uncap_first}.save(entity);
		}else{
		//mend
			//update
			${entityName} previousEntity=${daoName?uncap_first}.findOne(_Id);
			//**exclude handle start*//*
			if(null==previousEntity){
				throw new ExclusiveException();
			}
			if(!${daoName?uncap_first}.isExclusive(${dtoName?uncap_first}.getUpdateDateTime(), previousEntity)){
				throw new ExclusiveException();
			}
			<#list updateColumns as col>
				<#if col.propertyName=='updateDateTime'>
			previousEntity.setUpdateDateTime(new Date());
				<#elseif col.propertyName=='updateUserId'>
			previousEntity.setUpdateUserId(user.getUserId());
				<#else>
			previousEntity.set${col.propertyName?cap_first}(${dtoName?uncap_first}.${col.getMathodName}());
				</#if>
			</#list>
			${daoName?uncap_first}.save(previousEntity);
		}
	}
 	
	/**
	 * find${entityName}
	 * @param ${dtoName?uncap_first}
	 */
	public ${dtoName} find${entityName}(${dtoName} ${dtoName?uncap_first}){
		${dtoName} result=new ${dtoName}();
		${entityName} entity=${daoName?uncap_first}.findOne(${dtoName?uncap_first}.get${pkName?cap_first}());
		if(entity==null){
			throw new ResourceNotFoundException();
		}
		BeanUtils.objectCopy(entity, result);
		return result;
	}
	
	
		
	/**
	 * delete ${entityName}
	 * @param ${dtoName?uncap_first}
	 */
	public ${dtoName} delete${entityName}(${dtoName} ${dtoName?uncap_first}){
		UserInfo user=LDSecurityUtils.getCurrentUser();
		${entityName} entity=${daoName?uncap_first}.findOne(${dtoName?uncap_first}.get${pkName?cap_first}());
		if(null==entity){
			throw new ExclusiveException();
		}
		if(!${daoName?uncap_first}.isExclusive(${dtoName?uncap_first}.getUpdateDateTime(), entity)){
			throw new ExclusiveException();
		}
		entity.setUpdateUserId(user.getUserId());
		entity.setUpdateDateTime(new Date());
		entity.setDelFlag(true);
		${entityName} persisted=${daoName?uncap_first}.save(entity);
		${dtoName} resultDto=new ${dtoName}();
		BeanUtils.objectCopy(persisted, resultDto);
		return resultDto;
	}
	
}