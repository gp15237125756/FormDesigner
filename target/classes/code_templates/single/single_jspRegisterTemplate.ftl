<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/page/common/ctx.jsp"%>

<style>
	.proportion-span {
		border: 1px solid rgb(204, 204, 204); 
		line-height: 1; 
		display: table-cell; 
		text-align: center; 
		color: #848484;
		background-color: #eee;
	}
</style>

<script type="text/javascript">
</script>

<form id="${entityName?uncap_first}Form">
<%@ include file="/page/common/message.jsp"%>
	<table id="sample-table-2"
		class="table table-striped table-bordered dataTable">
		<input type="hidden" name="${dtoName?uncap_first}.${pkName}" value="<s:property value="${dtoName?uncap_first}.${pkName}"/>">
		<tbody aria-relevant="all" aria-live="polite" role="alert">
			<#list searchColumns as col>
			<tr>
				<td class="tabctmg tab-fittd" style="padding-top: 10px; text-align: center;"><span class="required">*</span><#if col.comment?exists>${col.comment}：<#else>${col.propertyName}：</#if>
				</td>
				<td style="text-align: left; padding-left: 5px;" colspan="3">
					<input name="${dtoName?uncap_first}.${col.propertyName}" maxlength="32" value="<s:property value="${dtoName?uncap_first}.${col.propertyName}"/>" id="" style="width: 96%;" type="text" >
				</td>
			</tr>
			</#list>
			<tr>
				<td colspan="4" style="text-align: right; padding-right: 27px;">
					<input data-dismiss="modal" value="保 存" name="" class="btncet" onclick="save${entityName}('<s:property value="${dtoName?uncap_first}.updateDateTime" />');" id="save" type="button"> 
					<input data-dismiss="modal" value="取 消" name="" class="btncet" onclick="closeDialogForm();" type="button">
				</td>
			</tr>
		</tbody>
	</table>
</form>
<script type="text/javascript" src="<%=ctx%>/assets/module/${moduleName}/${entityName?uncap_first}/register.js"></script>
