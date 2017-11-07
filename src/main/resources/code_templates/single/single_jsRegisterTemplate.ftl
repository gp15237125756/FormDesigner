/*******************************${moduleChName}登记、编辑、查看 START********************************************/
//初始化validation
$(function(){
 //输入项check
  var errorContainer = $("#${entityName?uncap_first}Form .errorContainer");
  //作者信息验证规则
 $("#${entityName?uncap_first}Form").validate({
  errorContainer: errorContainer,
  errorLabelContainer: $("ol", errorContainer),
  onsubmit:true,
  ignore : "",
  wrapper: 'li',
  onfocusout: false,
  rules: {
  	  <#list searchColumns as col>
  	  	<#if col.typeName=='String'>
		"${dtoName?uncap_first}.${col.propertyName}":{required:true,maxlength:32},
		<#elseif col.typeName=='Integer'|| col.typeName=='Long'>
		"${dtoName?uncap_first}.${col.propertyName}":{required:true,digits:true,min:1},
		<#else>
		"${dtoName?uncap_first}.${col.propertyName}":{required:true},
		</#if>
  	  </#list>
  },
  messages: {
      <#list searchColumns as col>
  	  	<#if col.typeName=='String'>
  	  	"${dtoName?uncap_first}.${col.propertyName}":{required:'<s:text name="E.COMM.SUBMIT.MUST"><s:param><#if col.comment?exists>${col.comment}<#else>${col.propertyName}</#if></s:param></s:text>',maxlength:'<#if col.comment?exists>${col.comment}<#else>${col.propertyName}</#if>长度不能超过32位。'},
		<#elseif col.typeName=='Integer'|| col.typeName=='Long'>
		"${dtoName?uncap_first}.${col.propertyName}":{required:'<s:text name="E.COMM.SUBMIT.MUST"><s:param><#if col.comment?exists>${col.comment}<#else>${col.propertyName}</#if></s:param></s:text>',digits:'<#if col.comment?exists>${col.comment}<#else>${col.propertyName}</#if>必须输入整数。',min:'<#if col.comment?exists>${col.comment}<#else>${col.propertyName}</#if>输入值不能小于1。'},
		<#else>
		"${dtoName?uncap_first}.${col.propertyName}":{required:'<s:text name="E.COMM.SUBMIT.MUST"><s:param><#if col.comment?exists>${col.comment}<#else>${col.propertyName}</#if></s:param></s:text>'}
		</#if>
  	  </#list>
  }
  });
});


/*
* 保存、编辑${moduleChName}
*/
function save${entityName}(updateDateTime){
 if(!$("#${entityName?uncap_first}Form").valid()){
          return;
  }
//details
var formData=null,msg=null;
if($("#${entityName?uncap_first}Form input[name='${dtoName?uncap_first}.${pkName}']").val()){
    msg="确定要修改${moduleChName}信息？";
  }else{
    msg="确定要保存${moduleChName}信息？";
      }
   formData = $("#${entityName?uncap_first}Form").serialize()+"&${dtoName?uncap_first}.updateDateTime="+updateDateTime; 
   showConfirm(msg,function(){
      $.comAjax({
        type : "Post",
        async: false,
        cache : false,
        data:formData,
        url : "<%=ctx%>/${moduleName}/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>manage/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>save?",
    success : function(res) {
      var data=res.data;
      $("#${entityName?uncap_first}Form").refreshParent();
      $("#${entityName?uncap_first}Form").closeDialog();
    }
  });
});
  

}

/**close*/
function closeDialogForm(){
$("#${entityName?uncap_first}Form").closeDialog();
}

//# sourceURL=${entityName?uncap_first}Register.jsp
/*******************************${moduleChName}登记、编辑、查看 END********************************************/