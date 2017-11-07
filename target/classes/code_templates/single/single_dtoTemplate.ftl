
package ${dtoPackageName};

import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.math.BigDecimal;
<#assign DateFlag = 0 />
<#assign ListFlag = 0 />
<#assign MapFlag = 0 />
<#assign SetFlag = 0 />
<#list columns as column>
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
 * @Title: ${dtoName}
 * @Description: ${description}
 * @author ${author}
 * @date ${create_time}
 * @version ${version}
 *
 */
public class ${dtoName}{
	
    public ${dtoName}(){
    	super();
    }
    
    <#list columns as column>
    <#if column.comment?exists>
    //${column.comment}
    <#else>
    </#if>
	private <#if column.typeName=='Blob'>byte[]<#else>${column.typeName}</#if> ${column.propertyName};
	</#list>
	
	<#list columns as column>
	public ${column.typeName} ${column.getMathodName}() {
		return ${column.propertyName};
	}
	
	public void ${column.setMethodName}(${column.typeName} ${column.propertyName}) {
		this.${column.propertyName} = ${column.propertyName};
	}
	</#list>
	
	
}
