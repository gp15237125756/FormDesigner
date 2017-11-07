<!DOCTYPE struts PUBLIC
    "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
    "http://struts.apache.org/dtds/struts-2.3.dtd">
<struts>
	<package name="${moduleName}-<#list separateEntityWrods as wrod>${wrod+'-'}</#list>-manage" namespace="/${moduleName}/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>manage" extends="ld-default">
		<!--  ${moduleChName}管理初期化 -->
		<action name="init" class="${actionName}" method="init">
			<result name="success">/WEB-INF/page/${moduleName}/${entityName?uncap_first}Manage/${entityName?uncap_first}Manage.jsp</result>
		</action>
		
		<!--  ${moduleChName}查询 -->
		<action name="<#list separateEntityWrods as wrod>${wrod+'_'}</#list>search" class="${actionName}" method="${entityName?uncap_first}Search">
			<result name="success">/WEB-INF/page/${moduleName}/${entityName?uncap_first}Manage/${entityName?uncap_first}Result.jsp</result>
		</action>
		
		<!--  ${moduleChName}登记画面初期化 -->
		<action name="<#list separateEntityWrods as wrod>${wrod+'_'}</#list>register_init" class="${actionName}" method="${entityName?uncap_first}RegisterInit">
			<result name="success">/WEB-INF/page/${moduleName}/${entityName?uncap_first}Manage/${entityName?uncap_first}Register.jsp</result>
		</action>
		
		<!-- 	${moduleChName}删除 -->
		<action name="<#list separateEntityWrods as wrod>${wrod+'_'}</#list>delete" class="${actionName}" method="${entityName?uncap_first}Delete">
			<result type="json">
				<param name="root">resultJson</param>
			</result>
		</action>
		
		<!-- 	${moduleChName}编辑 -->
		<action name="<#list separateEntityWrods as wrod>${wrod+'_'}</#list>edit" class="${actionName}" method="${entityName?uncap_first}Edit">
			<result name="success">/WEB-INF/page/${moduleName}/${entityName?uncap_first}Manage/${entityName?uncap_first}Register.jsp</result>
		</action>
		
		<!-- 	${moduleChName}查看 -->
		<action name="<#list separateEntityWrods as wrod>${wrod+'_'}</#list>show" class="${actionName}" method="${entityName?uncap_first}Show">
			<result name="success">/WEB-INF/page/${moduleName}/${entityName?uncap_first}Manage/${entityName?uncap_first}Register.jsp</result>
		</action>
		
		<!-- 	${moduleChName}保存 -->
		<action name="<#list separateEntityWrods as wrod>${wrod+'_'}</#list>save" class="${actionName}" method="${entityName?uncap_first}Save">
			<result type="json">
				<param name="root">resultJson</param>
			</result>
		</action>
	</package>
</struts>