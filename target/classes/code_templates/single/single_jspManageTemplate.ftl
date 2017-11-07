<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/page/common/ctx.jsp"%>

<div class="page-content">
	<!--${moduleName}查询条件  start -->
	<form id="searchInfoForm">
		<table width="100%" border="0" cellpadding="5" cellspacing="0" class="tabcang tabbny">
			<tr style="border-bottom: 1px solid #bdbfbe;">
				<#list searchColumns as col>
				<td style="text-align: right; font-weight: bold; height: 50px; min-width: 90px; width: 6%;"><#if col.comment?exists>${col.comment}：<#else>${col.propertyName}：</#if></td>
				<td style="width: 9%">
					<input name="${search_dtoName?uncap_first}.<#if col.typeName=='String'>${'search_LIKE_'+col.propertyName}<#else>${'search_EQ_'+col.propertyName}</#if>" maxlength="20" value="" id="" style="width: 100%; min-width:130px;" type="text">
				</td>
				</#list>
		   		<!--<td style="width:110px;text-align:right;font-weight:bold;height:50px;">物品名称：</td>
				<td style="width: 8%">
					<input name="memberArticleSearchDto.search_LIKE_articleName" maxlength="20" value="" id="" style="width: 100%; min-width:130px;" type="text">
				</td>-->
				
				<td style="text-align: left;padding-left: 20px;">
					<input class="btncet" onclick="search${entityName}();" value="查  询" name="" type="button">
					<input class="btncet" onclick="clearSearch();" value="清  空" name="" type="button">
					<input class="btncet" onclick="${entityName?uncap_first}Register();" value="${moduleChName}登记" name="" type="button" style="width: 105px;">
				</td>
			</tr>
		</table>
		<div style="width:100%;height:1px"></div>
	</form>
	<!--${moduleChName}条件  end -->
	
	<!--${moduleChName}信息列表  start -->
	<div id="${entityName?uncap_first}ListDiv" class="tab-pane active">
		
	</div>
	<!--${moduleChName}信息列表  end  -->
</div>


<script type="text/javascript" src="<%=ctx%>/assets/module/${moduleName}/${entityName?uncap_first}/manage.js"></script>
