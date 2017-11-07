
package ${dtoPackageName}.search;

import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.math.BigDecimal;
<#assign DateFlag = 0 />
<#assign ListFlag = 0 />
<#assign MapFlag = 0 />
<#assign SetFlag = 0 />
<#list dtoColumns as column>
	<#if column.typeName=='Date'&&(DateFlag=0)>
	<#assign DateFlag = DateFlag + 1 />
import java.util.Date;
	<#elseif column.typeName=='List'&&(ListFlag=0)>
	<#assign DateFlag = ListFlag + 1 />
import java.util.List;
	<#elseif column.typeName=='Map'&&(MapFlag=0)>
	<#assign DateFlag = MapFlag + 1 />
import java.util.Map;
	<#elseif column.typeName=='Set'&&(SetFlag=0)>
	<#assign DateFlag = MapFlag + 1 />
import java.util.Set;
	<#else>
	</#if>
</#list>


/**   
 * @Title: ${search_dtoName}
 * @Description: ${search_dtoName+' Dto'}
 * @author ${author}
 * @date ${create_time}
 * @version ${version}
 *
 */
public class ${search_dtoName}{
	
    public ${search_dtoName}(){
    	super();
    }
    
    <#list dtoColumns as column>
    <#if column.comment?exists>
    //${column.comment}
    <#else>
    </#if>
	private <#if column.typeName=='Blob'>byte[]<#else>${column.typeName}</#if> <#if column.typeName=='String'>${'search_LIKE_'+column.propertyName}<#else>${'search_EQ_'+column.propertyName}</#if> <#if column.propertyName=='delFlag'>= BasicConstants.DEL_FLAG_F;<#else></#if>;
	</#list>
	
	<#list dtoColumns as column>
	public ${column.typeName} get<#if column.typeName=='String'>${'Search_LIKE_'+column.propertyName}<#else>${'Search_EQ_'+column.propertyName}</#if>() {
		return <#if column.typeName=='String'>${'search_LIKE_'+column.propertyName}<#else>${'search_EQ_'+column.propertyName}</#if>;
	}
	
	public void set<#if column.typeName=='String'>${'Search_LIKE_'+column.propertyName}<#else>${'Search_EQ_'+column.propertyName}</#if>(${column.typeName} <#if column.typeName=='String'>${'search_LIKE_'+column.propertyName}<#else>${'search_EQ_'+column.propertyName}</#if>) {
		this.<#if column.typeName=='String'>${'search_LIKE_'+column.propertyName}<#else>${'search_EQ_'+column.propertyName}</#if> = <#if column.typeName=='String'>${'search_LIKE_'+column.propertyName}<#else>${'search_EQ_'+column.propertyName}</#if>;
	}
	</#list>
	
	
}
