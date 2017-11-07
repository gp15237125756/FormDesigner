<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/page/common/ctx.jsp"%>

<div class="page-module">
	<div class="module-header">
		<span class="page-left">查询结果</span> 
	</div>
	<s:if test="${dtoName?uncap_first+ 's'}.content != null &&${dtoName?uncap_first+ 's'}.content.size() > 0">
	<div class="smaple-spanper">
		<tags:pagination page="${dtoName?uncap_first+ 's'}" paginationSize="5" onclick="search${entityName}" />
	</div>
	<div class="table-responsive">
		<table
			class="table table-striped table-bordered table-hover dataTable table-overlt table-flow"
			id="sample-table-dialog">
			<thead>
				<tr role="row">
					<th class="center" width="45">序号</th>
					<#list searchColumns as col>
					<th width="120"><#if col.comment?exists>${col.comment}<#else>${col.propertyName}</#if></th>
					</#list>
					<th width="60">操作</th>
				</tr>
			</thead>

			<tbody role="alert" aria-live="polite" aria-relevant="all">
			<s:iterator value="${dtoName?uncap_first+ 's'}.content" status="st" var="each">
				<tr>
					<s:hidden name="${pkName}"/>
					<s:hidden name="updateDateTime"/>
					<td style="text-align: center">
						<s:property value="(pb.pageNumber - 1) * pb.pageSize + #st.index + 1" />
					</td>
					<#list searchColumns as col>
					<#if col_index?number==0>
					<td title="" style="text-align:left">
						<div class="divflow">
							<a onclick="show${entityName}('<s:property value="${pkName}"/>')"><span class="medium_titidly"><s:property value="${col.propertyName}" /></span></a>
						</div>
					</td>
					<#else>
					<td title="" style="text-align:center">
						<div class="divflow">
							<s:property value="${col.propertyName}" />
						</div>
					</td>
					</#if>
					</#list>
					
					<td>
						<a href="javascript:void(0);" onclick="edit${entityName}('<s:property value="${pkName}"/>');">
							<span id="medium_title1" class="medium_titidly">修改</span>
						</a>
						<a href="javascript:void(0);" onclick="delete${entityName}('<s:property value="${pkName}"/>','<s:property value="updateDateTime" />');">
							<span id="medium_title1" class="medium_titidly">删除</span>
						</a>
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

</div>
<div style="width: 100%; height: 1px;"></div>
</s:if>
<s:else>
		<!-- 数据为空的处理 start -->
		<div class="nodata">
		<s:text name="N.COMM.SELECT.NODATA" />
		</div>
		<!-- 数据为空的处理 end -->
</s:else>
</div>