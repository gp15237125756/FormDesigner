<#setting number_format="0.#####################">
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <base href="${basePath}/"/>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>表单信息</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${basePath}/online/template/ledefault/css/vendor.css">
  <link rel="stylesheet" href="${basePath}/online/template/ledefault/css/bootstrap-theme.css">
  <link rel="stylesheet" href="${basePath}/online/template/ledefault/css/bootstrap.css">
  <link rel="stylesheet" href="${basePath}/online/template/ledefault/css/app.css">
  
  <link rel="stylesheet" href="${basePath}/plug-in/Validform/css/metrole/style.css" type="text/css"/>
  <link rel="stylesheet" href="${basePath}/plug-in/Validform/css/metrole/tablefrom.css" type="text/css"/>
  <link rel="stylesheet" href="${basePath}/plug-in/easyui/themes/metrole/easyui.css" type="text/css">
  <link rel="stylesheet" href="${basePath}/plug-in/easyui/themes/metrole/main.css" type="text/css">
  <link rel="stylesheet" href="${basePath}/plug-in/easyui/themes/metrole/icon.css" type="text/css">
  
  <script type="text/javascript" src="${basePath}/plug-in/jquery/jquery-1.8.3.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/tools/dataformat.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/easyui/jquery.easyui.min.1.3.2.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/easyui/locale/zh-cn.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/tools/syUtil.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/lhgDialog/lhgdialog.min.js"></script>
  <#--update--begin--author:scott Date:20170304 for:替换layer风格提示框-->
  <script type="text/javascript" src="${basePath}/plug-in/layer/layer.js"></script>
  <#--update--end--author:scott Date:20170304 for:替换layer风格提示框-->
  <script type="text/javascript" src="${basePath}/plug-in/tools/curdtools_zh-cn.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/tools/easyuiextend.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/Validform/js/datatype_zh-cn.js"></script>
  <script type="text/javascript" src="${basePath}/plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
  <link rel="stylesheet" href="${basePath}/plug-in/uploadify/css/uploadify.css" type="text/css"></link>
  <script type="text/javascript" src="${basePath}/plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript"  charset="utf-8" src="${basePath}/plug-in/ueditor/ueditor.config.js"></script>
  <script type="text/javascript"  charset="utf-8" src="${basePath}/plug-in/ueditor/ueditor.all.min.js"></script>
								
  
  <style type="text/css">
  	.combo_self{height: 30px !important;}
  	.layout-header .btn {
	    margin:0;
	   float: none !important;
	}
	.btn-default {
	    height: 35px;
	    line-height: 35px;
	    font-size:14px;
	}
  </style>
  
  <script type="text/javascript">
  		$(function(){
  			$(".combo").removeClass("combo").addClass("combo combo_self");
  			$(".combo").each(function(){
  				$(this).parent().css("line-height","0px");
  			});   
  		});
  </script>
  
</head>

 <body>
  <#--update-start--Author:luobaoli  Date:20150614 for：表单单表属性中增加了扩展参数 ${po.extend_json?if_exists}-->
  <form id="formobj" action="${basePath}/cgFormBuildController.do?saveOrUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="tableName" value="${tableName?if_exists?html}" >
			<input type="hidden" name="id" value="${id?if_exists?html}" >
			<input type="hidden" name="pkName" value="${pkName?if_exists}" >
			<#if data['${tableName}']?has_content>
			  <#list columnhidden as po>
			  <input type="hidden" id="${po.field_name}" name="${po.field_name}" 
			  <#if data['${tableName}']['${po.field_name}']?is_boolean>
			    value="${data['${tableName}']['${po.field_name}']?string("1","0")}" >
				<#else>
				value="${data['${tableName}']['${po.field_name}']?if_exists?html}" >
			  </#if>
			</#list>
			</#if>
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">表单信息管理</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
			        <#list columns as po>
				        <#if (columns?size>10)>
							<#if po_index%2==0>
							<div class="row show-grid">
							</#if>
						<#else>
							<div class="row show-grid">
						</#if>
			          <div class="col-xs-3 text-center">
			          	<b><@mutiLang langKey="${po.content}"/>：</b>
			          </div>
			          <div class="col-xs-3">
			          	<#if head.isTree=='Y' && head.treeParentIdFieldName==po.field_name>
							<!--如果为树形菜单，父id输入框设置为select-->
							<input id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}" type="text"
							        class="inputxt easyui-combotree" value="${data['${tableName}']['${po.field_name}']?if_exists?html}"
					               <#if po.operationCodesReadOnly?exists> readonly = "readonly"</#if>
					                <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
						       <#if po.field_valid_type?if_exists?html != ''>
					               datatype="${po.field_valid_type?if_exists?html}"
					               <#else>
					               <#if po.type == 'int'>
					               datatype="n"  
					               <#elseif po.type=='double'>
					               datatype="/^(-?\d+)(\.\d+)?$/" 
					               <#else>
					               <#if po.is_null != 'Y'>datatype="*"</#if>
					               </#if>
					               </#if> 
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
				               data-options="
				                    panelHeight:'220',
				                    url: '${basePath}/cgAutoListController.do?datagrid&configId=${tableName?if_exists?html}&field=id,${head.treeFieldname}',  
				                    loadFilter: function(data) {
				                    	var rows = data.rows || data;
				                    	var win = frameElement.api.opener;
				                    	var listRows = win.getDataGrid().treegrid('getData');
				                    	joinTreeChildren(rows, listRows);
				                    	convertTreeData(rows, '${head.treeFieldname}');
				                    	return rows; 
				                    },
				                    onLoadSuccess: function() {
				                    	var win = frameElement.api.opener;
				                    	var currRow = win.getDataGrid().treegrid('getSelected');
				                    	if(!'${id?if_exists?html}') {
				                    		//增加时，选择当前父菜单
				                    		if(currRow) {
				                    			$('#${po.field_name}').combotree('setValue', currRow.id);
				                    		}
				                    	}else {
				                    		//编辑时，选择当前父菜单
				                    		if(currRow) {
				                    			$('#${po.field_name}').combotree('setValue', currRow._parentId);
				                    		}
				                    	}
				                    }
				            ">
				        <#--update-end--Author:钟世云  Date:20150610 for：online支持树配置-->
						<#elseif po.show_type=='text'>
							<input id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}" type="text"
							        class="form-control" value="${data['${tableName}']['${po.field_name}']?if_exists?html}"
					               <#if po.operationCodesReadOnly?exists> readonly = "readonly"</#if>
					                <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
						       <#if po.field_valid_type?if_exists?html != ''>
					               datatype="${po.field_valid_type?if_exists?html}"
					               <#else>
					               <#if po.type == 'int'>
					               datatype="n"  
					               <#elseif po.type=='double'>
					               datatype="/^(-?\d+)(\.\d+)?$/" 
					               <#else>
					               <#if po.is_null != 'Y'>datatype="*"</#if>
					               </#if>
					               </#if>>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
						<#elseif po.show_type=='password'>
							<input id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}"  type="password"
							        class="form-control" value="${data['${tableName}']['${po.field_name}']?if_exists?html}"
					               <#if po.operationCodesReadOnly?if_exists> readonly = "readonly"</#if>
					                <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
						       <#if po.field_valid_type?if_exists?html != ''>
					               datatype="${po.field_valid_type?if_exists?html}"
					               <#else>
					               <#if po.is_null != 'Y'>datatype="*"</#if>
					               </#if>>
						
						<#elseif po.show_type=='radio'>
					        <@DictData name="${po.dict_field?if_exists?html}" text="${po.dict_text?if_exists?html}" tablename="${po.dict_table?if_exists?html}" var="dataList">
								<#list dataList as dictdata> 
								<input value="${dictdata.typecode?if_exists?html}" ${po.extend_json?if_exists} name="${po.field_name}" type="radio"
								 <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
					            <#if dictdata_index==0&&po.is_null != 'Y'>datatype="*"</#if> 
								<#if po.operationCodesReadOnly?if_exists>onclick="return false;"</#if>
								<#if dictdata.typecode?if_exists?html=="${data['${tableName}']['${po.field_name}']?if_exists?html}"> checked="true" </#if>>
									${dictdata.typename?if_exists?html}
								</#list> 
							</@DictData>
					               
						<#elseif po.show_type=='checkbox'>
							<#assign checkboxstr>${data['${tableName}']['${po.field_name}']?if_exists?html}</#assign>
							<#assign checkboxlist=checkboxstr?split(",")>
							<@DictData name="${po.dict_field?if_exists?html}" text="${po.dict_text?if_exists?html}" tablename="${po.dict_table?if_exists?html}" var="dataList">
								<#list dataList as dictdata> 
								<input value="${dictdata.typecode?if_exists?html}" ${po.extend_json?if_exists} name="${po.field_name}" type="checkbox"
								 <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
								<#if po.operationCodesReadOnly?if_exists>onclick="return false;"</#if>
					            <#if dictdata_index==0&&po.is_null != 'Y'>datatype="*"</#if> 
								<#list checkboxlist as x >
								<#if dictdata.typecode?if_exists?html=="${x?if_exists?html}"> checked="true" </#if></#list>>
									${dictdata.typename?if_exists?html}
								</#list> 
							</@DictData>
					               
						<#elseif po.show_type=='list'>
							<@DictData name="${po.dict_field?if_exists?html}" text="${po.dict_text?if_exists?html}" tablename="${po.dict_table?if_exists?html}" var="dataList">
								<select id="${po.field_name}" ${po.extend_json?if_exists} class="form-control" name="${po.field_name}" <#if po.operationCodesReadOnly?if_exists>onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;"</#if>
								 <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
								<#if po.is_null != 'Y'>datatype="*"</#if> >
									<#list dataList as dictdata> 
									<option value="${dictdata.typecode?if_exists?html}" 
									<#if dictdata.typecode?if_exists?html=="${data['${tableName}']['${po.field_name}']?if_exists?html}"> selected="selected" </#if>>
										${dictdata.typename?if_exists?html}
									</option> 
									</#list> 
								</select>
							</@DictData>
							
						<#elseif po.show_type=='date'>
							<input id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}" type="text" value="<#if data['${tableName}']['${po.field_name}']??>${data['${tableName}']['${po.field_name}']?if_exists?string("yyyy-MM-dd")}</#if>"
							       style="background: url('${basePath}/plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;" class="form-control Wdate" onClick="WdatePicker({<#if po.operationCodesReadOnly?if_exists> readonly = true</#if>})" 
					              <#if po.operationCodesReadOnly?exists> readonly = "readonly"</#if>
					               <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
						       <#if po.field_valid_type?if_exists?html != ''>
					               datatype="${po.field_valid_type?if_exists?html}"
					               <#else>
					               <#if po.is_null != 'Y'>datatype="*"</#if> 
					               </#if>>
						
						<#elseif po.show_type=='datetime'>
							<input id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}" type="text" value="<#if data['${tableName}']['${po.field_name}']??>${data['${tableName}']['${po.field_name}']?if_exists?string("yyyy-MM-dd HH:mm:ss")}</#if>"
							        style="background: url('${basePath}/plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;" class="form-control Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'<#if po.operationCodesReadOnly?if_exists> ,readonly = true</#if>})"
						         <#if po.operationCodesReadOnly?exists> readonly = "readonly"</#if>
						          <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
						       <#if po.field_valid_type?if_exists?html != ''>
					               datatype="${po.field_valid_type?if_exists?html}"
					               <#else>
					               <#if po.is_null != 'Y'>datatype="*"</#if> 
					               </#if>>
					               
						<#--update-start--Author:gengjiajia  Date:20160802 for：TASK #1175 批量添加数据的时popup多值的传递-->
						<#elseif po.show_type=='popup'>
							<input id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}"  type="text"
							        class="form-control searchbox-inputtext" 
							      <#-- onClick="inputClick(this,'${po.dict_text?if_exists?html}','${po.dict_table?if_exists?html}');"-->
							       onClick="popupClick(this,'${po.dict_text?if_exists?html}','${po.dict_field?if_exists?html}','${po.dict_table?if_exists?html}');" 
							       value="${data['${tableName}']['${po.field_name}']?if_exists?html}"
							        <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
					               <#if po.operationCodesReadOnly?if_exists> readonly = "readonly"</#if>
						       <#if po.field_valid_type?if_exists?html != ''>
					               datatype="${po.field_valid_type?if_exists?html}"
					               <#else>
					               <#if po.is_null != 'Y'>datatype="*"</#if>
					               </#if>>
						<#--update-end--Author:gengjiajia  Date:20160802 for：TASK #1175 批量添加数据的时popup多值的传递-->
						
						<#elseif po.show_type=='file'>
								<table>
									<#list imageList as imageB>
										<#if imageB['field'] == po.field_name>
										<tr style="height:34px;">
										<td>${imageB['title']}</td>
										<td><a href="${basePath}/commonController.do?viewFile&fileid=${imageB['fileKey']}&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity" title="下载">下载</a></td>
										<td><a href="javascript:void(0);" onclick="openwindow('预览','${basePath}/commonController.do?openViewFile&fileid=${imageB['fileKey']}&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)">预览</a></td>
										<td><a href="javascript:void(0)" class="jeecgDetail" onclick="del('${basePath}/cgUploadController.do?delFile&id=${imageB['fileKey']}',this)">删除</a></td>
										</tr>
										</#if>
									</#list>
								</table>
								<#if !(po.operationCodesReadOnly ??)>
							    <div class="form jeecgDetail">
									<script type="text/javascript">
									var serverMsg="";
									var m = new Map();
									$(function(){$('#${po.field_name}').uploadify(
										{buttonText:'添加文件',
										auto:true,
										progressData:'speed',
										multi:true,
										height:25,
										overrideEvents:['onDialogClose'],
										fileTypeDesc:'文件格式:',
										queueID:'filediv_${po.field_name}',
										<#-- fileTypeExts:'*.rar;*.zip;*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;*.jpg;*.gif;*.png',   页面弹出很慢解决 20170317 scott -->
										fileSizeLimit:'15MB',swf:'${basePath}/plug-in/uploadify/uploadify.swf',	
										uploader:'${basePath}/cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
										onUploadStart : function(file) { 
											var cgFormId=$("input[name='id']").val();
											$('#${po.field_name}').uploadify("settings", "formData", {'cgFormId':cgFormId,'cgFormName':'${tableName?if_exists?html}','cgFormField':'${po.field_name}'});} ,
										onQueueComplete : function(queueData) {
											<#-- 
											 var win = frameElement.api.opener;
											 win.reloadTable();
											 win.tip(serverMsg);
											 frameElement.api.close();
											 -->
											},
										onUploadSuccess : function(file, data, response) {var d=$.parseJSON(data);if(d.success){var win = frameElement.api.opener;serverMsg = d.msg;}},onFallback : function(){tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")},onSelectError : function(file, errorCode, errorMsg){switch(errorCode) {case -100:tip("上传的文件数量已经超出系统限制的"+$('#${po.field_name}').uploadify('settings','queueSizeLimit')+"个文件！");break;case -110:tip("文件 ["+file.name+"] 大小超出系统限制的"+$('#${po.field_name}').uploadify('settings','fileSizeLimit')+"大小！");break;case -120:tip("文件 ["+file.name+"] 大小异常！");break;case -130:tip("文件 ["+file.name+"] 类型不正确！");break;}},
										onUploadProgress : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) { }});});
									
										</script><span id="file_uploadspan"><input type="file" name="${po.field_name}" id="${po.field_name}" /></span>
								</div>
								<div class="form" id="filediv_${po.field_name}"> </div>
							</#if>
						<#--update-start--Author: jg_huangxg  Date:20160113 for：TASK #824 【online开发】控件类型扩展增加一个图片类型 image -->
						<#elseif po.show_type=='image'>
								<table>
									<#list filesList as fileB>
										<#if fileB['field'] == po.field_name>
										<tr style="height:34px;">
										<td>${fileB['title']}</td>
										<td><a href="${basePath}/commonController.do?viewFile&fileid=${fileB['fileKey']}&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity" title="下载">下载</a></td>
										<td><a href="javascript:void(0);" onclick="openwindow('预览','${basePath}/commonController.do?openViewFile&fileid=${fileB['fileKey']}&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)">预览</a></td>
										<td><a href="javascript:void(0)" class="jeecgDetail" onclick="del('${basePath}/cgUploadController.do?delFile&id=${fileB['fileKey']}',this)">删除</a></td>
										</tr>
										</#if>
									</#list>
								</table>
								<#if !(po.operationCodesReadOnly ??)>
							    <div class="form jeecgDetail">
									<script type="text/javascript">
									var serverMsg="";
									var m = new Map();
									$(function(){$('#${po.field_name}').uploadify(
										{buttonText:'添加图片',
										auto:true,
										progressData:'speed',
										multi:true,
										height:25,
										overrideEvents:['onDialogClose'],
										fileTypeDesc:'图片格式:',
										queueID:'imagediv_${po.field_name}',
										fileTypeExts:'*.jpg;*.jpeg;*.gif;*.png;*.bmp',
										fileSizeLimit:'15MB',swf:'${basePath}/plug-in/uploadify/uploadify.swf',	
										uploader:'${basePath}/cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
										onUploadStart : function(file) { 
											var cgFormId=$("input[name='pkName']").val();
											$('#${po.field_name}').uploadify("settings", "formData", {'cgFormId':cgFormId,'cgFormName':'${tableName?if_exists?html}','cgFormField':'${po.field_name}'});} ,
										onQueueComplete : function(queueData) {
											 <#-- 
											 var win = frameElement.api.opener;
											 win.reloadTable();
											 win.tip(serverMsg);
											 frameElement.api.close(); 
											 -->
											 },
										onUploadSuccess : function(file, data, response) {alert(1);var d=$.parseJSON(data);if(d.success){var win = frameElement.api.opener;serverMsg = d.msg;}},
										onFallback : function(){tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")},
										onSelectError : function(file, errorCode, errorMsg){
											switch(errorCode) {
											case -100:
											tip("上传的文件数量已经超出系统限制的"+$('#${po.field_name}').uploadify('settings','queueSizeLimit')+"个文件！");
											break;
											case -110:
											tip("文件 ["+file.name+"] 大小超出系统限制的"+$('#${po.field_name}').uploadify('settings','fileSizeLimit')+"大小！");
											break;
											case -120:
											tip("文件 ["+file.name+"] 大小异常！");
											break;
											case -130:
											tip("文件 ["+file.name+"] 类型不正确！");
											break;
											}
											},
											 onUploadError: function(file,errorCode,erorMsg,errorString){
											 $('#${po.field_name}').uploadify('upload', '*');	
											 tip("errorCode:"+errorCode+" "+errorString);
                							},
                							onUploadComplete: function(file){
							                    //在每一个文件上传成功或失败之后触发，返回上传的文件对象或返回一个错误，如果你想知道上传是否成功，最后使用onUploadSuccess或onUploadError事件
							                },
										   onUploadProgress : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) { }
										});
										});
									
										</script><span id="image_uploadspan"><input type="file" name="${po.field_name}" id="${po.field_name}" /></span>
								</div>
								<div class="form" id="imagediv_${po.field_name}"> </div>
							</#if>
							<#--update-end--Author: jg_huangxg  Date:20160113 for：TASK #824 【online开发】控件类型扩展增加一个图片类型 image -->							
						<#else>
							<input id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}" type="text"
							        class="form-control" value="${data['${tableName}']['${po.field_name}']?if_exists?html}"
							         <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
					               <#if po.field_valid_type?if_exists?html != ''>
					               datatype="${po.field_valid_type?if_exists?html}"
					               <#else>
					               <#if po.type == 'int'>
					               datatype="n" 
					               <#elseif po.type=='double'>
					               datatype="/^(-?\d+)(\.\d+)?$/" 
					               <#else>
					               <#if po.is_null != 'Y'>datatype="*"</#if>
					               </#if>
					               </#if>>

						</#if>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none"><@mutiLang langKey="${po.content?if_exists?html}"/></label>
			          </div>
			        <#if (columns?size>10)>
						<#if (po_index%2==0)&&(!po_has_next)>
							<div class="col-xs-2 text-center"><b></b></div>
			         		<div class="col-xs-4"></div>
						</#if>
						<#if (po_index%2!=0)||(!po_has_next)>
							</div>
						</#if>
					<#else>
						</div>
					</#if>
			          
			        
			        </#list>
			        
			        
			        <#list columnsarea as po>
					  <#if (columns?size>10)>
					  	<div class="row show-grid">
							<div class="col-xs-3 text-center"><b><@mutiLang langKey="${po.content?if_exists?html}"/>：</b></div>
							<div class="col-xs-3">
								<textarea id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}"  style="width: 600px" rows="6"
								 <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
								<#if po.operationCodesReadOnly?if_exists> readonly = "readonly"</#if>
						               <#if po.field_valid_type?if_exists?html != ''>
						               datatype="${po.field_valid_type?if_exists?html}"
						               <#else>
						               <#if po.is_null != 'Y'>datatype="*"</#if> 
						               </#if>>${data['${tableName}']['${po.field_name}']?if_exists?html}</textarea>
								<span class="Validform_checktip"></span>
								<label class="Validform_label" style="display: none;"><@mutiLang langKey="${po.content?if_exists?html}"/></label>
								<#if po.show_type=='umeditor'>
								<script type="text/javascript">
							    //实例化编辑器
							    var ${po.field_name}_ue = UE.getEditor('${po.field_name}',{initialFrameWidth:${po.field_length}}).setHeight(260);
							    </script>
							    </#if>
							</div>
						</div>
						<#else>
						<div class="row show-grid">
							<div class="col-xs-3 text-center"><b><@mutiLang langKey="${po.content?if_exists?html}"/>：</b></div>
							<div class="col-xs-3">
								<textarea id="${po.field_name}" ${po.extend_json?if_exists} name="${po.field_name}" rows="7" style="width: 600px"
								 <#-- update--begin--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
									<#if po.field_must_input??><#if po.field_must_input == 'Y' || po.is_null != 'Y'>ignore="checked"<#else>ignore="ignore"</#if></#if>
									<#-- update--end--author:zhangjiaqiang Date:20170417 for:增加校验必填项 -->
								<#if po.operationCodesReadOnly?if_exists> readonly = "readonly"</#if>
						               <#if po.field_valid_type?if_exists?html != ''>
						               datatype="${po.field_valid_type?if_exists?html}"
						               <#else>
						               <#if po.is_null != 'Y'>datatype="*"</#if> 
						               </#if>>${data['${tableName}']['${po.field_name}']?if_exists?html}</textarea>
								<span class="Validform_checktip"></span>
								<label class="Validform_label" style="display: none;"><@mutiLang langKey="${po.content?if_exists?html}"/></label>
								<#if po.show_type=='umeditor'>
								<script type="text/javascript">
							    //实例化编辑器
							    var ${po.field_name}_ue = UE.getEditor('${po.field_name}',{initialFrameWidth:${po.field_length}}).setHeight(260);
							    </script>
							    </#if>
							</div>
						</div>
						</#if>
					  </#list>
			       
			          <div class="row" id = "sub_tr" style="display: none;">
				        <div class="col-xs-12 layout-header">
				           <center>
				           <button type="button" onclick="neibuClick();" class="btn btn-default"> 提  &nbsp;交 </button>
				           </center>
				        </div>
				      </div>
			     </div>
			   </div>
			   
			   <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
			 </div>
	</form>
<#--update--begin--author:scott Date:20170304 for:替换layer风格提示框-->
<script type="text/javascript">
$(function(){
$("#formobj").Validform({
tiptype:function(msg,o,cssctl){
if(o.type == 3){
layer.open({
title:'提示信息',
content:msg,icon:5,shift:6,
btn:false,shade:false,
time:5000,
cancel:function(index){o.obj.focus();layer.close(index);
},
yes:function(index){
o.obj.focus();layer.close(index);
},
})}},
btnSubmit:"#btn_sub",btnReset:"#btn_reset",ajaxPost:true,
usePlugin:{
passwordstrength:{minLen:6,maxLen:18,trigger:function(obj,error){if(error){obj.parent().next().find(".Validform_checktip").show();obj.find(".passwordStrength").hide();}else{$(".passwordStrength").show();obj.parent().next().find(".Validform_checktip").hide();}}}},
callback:function(data){
if(data.success==true){
uploadFile(data);
}else{
if(data.responseText==''||data.responseText==undefined){
$.messager.alert('错误', data.msg);$.Hidemsg();
}else{
try{var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'),data.responseText.indexOf('错误信息')); $.messager.alert('错误',emsg);$.Hidemsg();}catch(ex){$.messager.alert('错误',data.responseText+'');}} 
return false;
}
if(!neibuClickFlag){var win = frameElement.api.opener; win.reloadTable();
}}});
});
</script>
<#--update--end--author:scott Date:20170304 for:替换layer风格提示框-->	
	<#--update-end--Author:luobaoli  Date:20150614 for：表单单表属性中增加了扩展参数 ${po.extend_json?if_exists}-->
<script type="text/javascript">
   $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("goDetail.do")!=-1){
		$(".jeecgDetail").hide();
	}
	
	if(location.href.indexOf("goDetail.do")!=-1){
		//查看模式控件禁用
		$("#formobj").find(":input").attr("disabled","disabled");
	}
	if(location.href.indexOf("goAddButton.do")!=-1||location.href.indexOf("goUpdateButton.do")!=-1){
		//其他模式显示提交按钮
		$("#sub_tr").show();
	}
   });
  function upload() {
  	<#list columns as po>
  		<#if po.show_type=='file'>
  		$('#${po.field_name}').uploadify('upload', '*');		
  		</#if>
  		<#if po.show_type=='image'>
  		$('#${po.field_name}').uploadify('upload', '*');		
  		</#if>
  	</#list>
  }
  var neibuClickFlag = false;
  function neibuClick() {
	  neibuClickFlag = true; 
	  $('#btn_sub').trigger('click');
  }
  function cancel() {
  	<#list columns as po>
  		<#if po.show_type=='file'>
 	 $('#${po.field_name}').uploadify('cancel', '*');
 	 	</#if>
 	 	<#if po.show_type=='image'>
 	 $('#${po.field_name}').uploadify('cancel', '*');
 	 	</#if>
  	</#list>
  }
  function uploadFile(data){
  		if(!$("input[name='id']").val()){
  			<#--update-start--Author:luobaoli  Date:20150614 for：需要判断data.obj存在，才能取id值-->
  			if(data.obj!=null && data.obj!='undefined'){
  				$("input[name='id']").val(data.obj.id);
  			}
  			<#--update-end--Author:luobaoli  Date:20150614 for：需要判断data.obj存在，才能取id值-->
  		}
  		if($(".uploadify-queue-item").length>0){
  			upload();
  		}else{
  			if (neibuClickFlag){
  				alert(data.msg);
  				neibuClickFlag = false;
  			}else {
	  			var win = frameElement.api.opener;
				win.reloadTable();
				win.tip(data.msg);
				frameElement.api.close();
  			}
  		}
  	}
	$.dialog.setting.zIndex =1990;
	function del(url,obj){
		$.dialog.confirm("确认删除该条记录?", function(){
		  	$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				url : url,// 请求的action路径
				error : function() {// 请求失败处理函数
				},
				success : function(data) {
					var d = $.parseJSON(data);
					if (d.success) {
						var msg = d.msg;
						tip(msg);
						$(obj).closest("tr").hide("slow");
					}
				}
			});  
		}, function(){
	});
}

<#--add-start--Author:钟世云  Date:20150614 for：online支持树配置-->
/**树形列表数据转换**/
function convertTreeData(rows, textField) {
    for(var i = 0; i < rows.length; i++) {
        var row = rows[i];
        row.text = row[textField];
        if(row.children) {
        	row.state = "open";
            convertTreeData(row.children, textField);
        }
    }
}
/**树形列表加入子元素**/
function joinTreeChildren(arr1, arr2) {
    for(var i = 0; i < arr1.length; i++) {
        var row1 = arr1[i];
        for(var j = 0; j < arr2.length; j++) {
            if(row1.id == arr2[j].id) {
                var children = arr2[j].children;
                if(children) {
                    row1.children = children;
                }
                
            }
        }
    }
}
<#--add-end--Author:钟世云  Date:20150614 for：online支持树配置-->
</script>
	<script type="text/javascript">${js_plug_in?if_exists}</script>		
 </body>
</html>