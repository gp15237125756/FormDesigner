/*******************************${moduleChName} START********************************************/
/**
   * ${moduleChName}信息查询
   */
  function search${entityName}(pageNumber) {
	  document.getElementById("loading").style.display = "block";
      var _pageNumber=pageNumber||1;
      setTimeout(function(){
	      $.comSearchAjax({
	      type : "Post",
	      async: false,
	      cache : false,
	      data: $("#searchInfoForm").serialize()+"&pb.pageNumber="+_pageNumber,
	      url : "<%=ctx%>/${moduleName}/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>manage/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>search",
	      success : function(responseHtml) {
	    	  document.getElementById("loading").style.display = "none";
	         $("#${entityName?uncap_first}ListDiv").html(responseHtml);
	      }
	    });
      },30);
  }

  /**
   * ${moduleChName}登记画面
   */
  function ${entityName?uncap_first}Register() {
    
    var title = "${moduleChName}登记";
    showDialog({
      title: title,
      position:({my:"center top",at:"center top+100"}),
      width: 600,
      ajaxOptions: {
        type:"GET",
        cache: false,
        async: false,
        url: "<%=ctx%>/${moduleName}/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>manage/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>register_init",
        success: function(responseHtml) {
        }
      },
       onRefreshParent:function() {
         search${entityName}();
       }
    });
  }
 /**
  * 清空条件
  */
  function clearSearch(){
    $("#searchInfoForm").clear();
    $("#${entityName?uncap_first}ListDiv").empty();
  }
  


  /**删除${moduleChName}*/
  function delete${entityName}(${pkName},updateDateTime){
    if(articleId){
      showConfirm("确定要删除该${moduleChName}信息？",function(){
        $.comAjax({
          type: "Post",
          async: false,
          cache: false,
          data :{"${dtoName?uncap_first}.${pkName}":${pkName},"${dtoName?uncap_first}.updateDateTime":updateDateTime},
          url: "<%=ctx%>/${moduleName}/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>manage/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>delete",
          success: function(ret) {
              var currPage=$("#${entityName?uncap_first}ListDiv ul.pagin-pagey li.active a").text();
             search${entityName}(currPage);
          }
      });
      });
    }
  }


  /** show detail*/
  function edit${entityName}(${pkName}){
    var title = "${moduleChName}编辑";
     if(${pkName}){
      showDialog({
          title: title,
          position: ({
              my: "center top",
              at: "center top+100"
          }),
          width: 800,
          ajaxOptions: {
              type: "GET",
              cache: false,
              async: false,
              data:{"${dtoName?uncap_first}.${pkName}":${pkName}},
              url: "<%=ctx%>/${moduleName}/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>manage/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>edit",
              success: function(responseHtml) {
            
            }
          },
          onRefreshParent:function() {
            var currPage=$("#${entityName?uncap_first}ListDiv ul.pagin-pagey li.active a").text();
              search${entityName}(currPage);
          }
      });
    }
  }

  /** show detail*/
  function show${entityName}(${pkName}){
    var title = "${moduleChName}查看";
     if(${pkName}){
      showDialog({
          title: title,
          position: ({
              my: "center top",
              at: "center top+100"
          }),
          width: 800,
          ajaxOptions: {
              type: "GET",
              cache: false,
              async: false,
              data:{"${dtoName?uncap_first}.${pkName}":${pkName}},
              url: "<%=ctx%>/${moduleName}/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>manage/<#list separateEntityWrods as wrod>${wrod+'_'}</#list>show",
              success: function(responseHtml) {
              	  //禁用input，select
                  $("#${entityName?uncap_first}Form input[type='text'],#${entityName?uncap_first}Form select").attr("disabled",true);
                  $("#${entityName?uncap_first}Form input[type='button'][value='保 存']").closest("tr").remove();
              }
          }
      });
    }
  }
/*******************************${moduleName} END********************************************/