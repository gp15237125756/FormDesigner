package org.apache.jsp.webpage.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.jeecgframework.core.util.SysThemesUtil;
import org.jeecgframework.core.enums.SysThemesEnum;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/WEB-INF/tld/easyui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005fid_005fhasLabel_005ffield_005fextendJson_005fdefaultVal_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005fid_005fhasLabel_005ffield_005fextendJson_005fdefaultVal_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005fid_005fhasLabel_005ffield_005fextendJson_005fdefaultVal_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /context/mytags.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("webRoot");
      // /context/mytags.jsp(9,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(basePath);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write('\n');

  session.setAttribute("lang","zh-cn");
  SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
  String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("  <meta charset=\"utf-8\" />\n");
      out.write("  <title>");
      if (_jspx_meth_t_005fmutiLang_005f0(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("   <link rel=\"shortcut icon\" href=\"images/favicon.ico\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\n");
      out.write("  <!-- bootstrap & fontawesome -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plug-in/ace/css/bootstrap.css\" />\n");
      out.write("  <link rel=\"stylesheet\" href=\"plug-in/ace/css/font-awesome.css\" />\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/accordion/css/accordion.css\">\n");
      out.write("  <!-- text fonts -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plug-in/ace/css/ace-fonts.css\" />\n");
      out.write("\n");
      out.write("  <link rel=\"stylesheet\" href=\"plug-in/ace/css/jquery-ui.css\" />\n");
      out.write("  <!-- ace styles -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plug-in/ace/css/ace.css\" class=\"ace-main-stylesheet\" id=\"main-ace-style\" />\n");
      out.write("  <!--[if lte IE 9]>\n");
      out.write("  <link rel=\"stylesheet\" href=\"plug-in/ace/css/ace-part2.css\" class=\"ace-main-stylesheet\" />\n");
      out.write("  <![endif]-->\n");
      out.write("\n");
      out.write("  <!--[if lte IE 9]>\n");
      out.write("  <link rel=\"stylesheet\" href=\"plug-in/ace/css/ace-ie.css\" />\n");
      out.write("  <![endif]-->\n");
      out.write("  <!-- ace settings handler -->\n");
      out.write("  <script src=\"plug-in/ace/js/ace-extra.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("\n");
      out.write("  <!--[if lte IE 8]>\n");
      out.write("  <script src=\"plug-in/ace/js/html5shiv.js\"></script>\n");
      out.write("  <script src=\"plug-in/ace/js/respond.js\"></script>\n");
      out.write("  <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body class=\"login-layout light-login\">\n");
      out.write("<div class=\"main-container\">\n");
      out.write("  <div class=\"main-content\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-sm-10 col-sm-offset-1\">\n");
      out.write("        <div class=\"login-container\">\n");
      out.write("          <div class=\"center\">\n");
      out.write("            <h1 id=\"id-text2\" class=\"grey\">\n");
      out.write("              <i class=\"ace-icon fa fa-leaf green\"></i>\n");
      out.write("               JEECG 演示系统\n");
      out.write("            </h1>\n");
      out.write("            <h4 class=\"blue\" id=\"id-company-text\">www.jeecg.org</h4>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"space-6\"></div>\n");
      out.write("          <div class=\"position-relative\">\n");
      out.write("            <div id=\"login-box\" class=\"login-box visible widget-box no-border\">\n");
      out.write("              <div class=\"widget-body\">\n");
      out.write("                <form id=\"loinForm\" class=\"form-horizontal\"  check=\"loginController.do?checkuser\"  role=\"form\" action=\"loginController.do?login\"  method=\"post\">\n");
      out.write("                <div class=\"widget-main\">\n");
      out.write("                 <div class=\"alert alert-warning alert-dismissible\" role=\"alert\" id=\"errMsgContiner\">\n");
      out.write("\t\t\t\t  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("\t\t\t\t  <div id=\"showErrMsg\"></div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                  <h4 class=\"header blue lighter bigger\">\n");
      out.write("                    <i class=\"ace-icon fa fa-coffee green\"></i>\n");
      out.write("                \t    用户登录\n");
      out.write("                  </h4>\n");
      out.write("                  <div class=\"space-6\"></div>\n");
      out.write("                      <label class=\"block clearfix\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"userName\" class=\"form-control\" placeholder=\"请输入用户名\"  id=\"userName\" value=\"admin\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-user\"></i>\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("                      </label>\n");
      out.write("                      <label class=\"block clearfix\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"请输入密码\" id=\"password\" value=\"123456\"/>\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-lock\"></i>\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("                      </label>\n");
      out.write("                      <label class=\"block clearfix\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                          <input type=\"text\" style=\"width:150px\" name=\"randCode\" class=\"form-control\" placeholder=\"请输入验证码\"  id=\"randCode\"/>\n");
      out.write("                          <span class=\"input-group-addon\" style=\"padding: 0px;\"><img id=\"randCodeImage\" src=\"randCodeImage\"  /></span>\n");
      out.write("                        </div>\n");
      out.write("                      </label>\n");
      out.write("                      <div class=\"space\"></div>\n");
      out.write("                      <div class=\"clearfix\">\n");
      out.write("                        <label class=\"inline\">\n");
      out.write("                          <input type=\"checkbox\" class=\"ace\" id=\"on_off\"  name=\"remember\" value=\"yes\"/>\n");
      out.write("                          <span class=\"lbl\">记住用户名</span>\n");
      out.write("                        </label>\n");
      out.write("                        <button type=\"button\" id=\"but_login\"  onclick=\"checkUser()\" class=\"width-35 pull-right btn btn-sm btn-primary\">\n");
      out.write("                          <i class=\"ace-icon fa fa-key\"></i>\n");
      out.write("                          <span class=\"bigger-110\" >登录</span>\n");
      out.write("                        </button>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"space-4\"></div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"toolbar clearfix\">\n");
      out.write("                  <div style=\"float: right\">\n");
      out.write("                    <a href=\"#\"  class=\"forgot-password-link\">\n");
      out.write("                    \t  语言\n");
      out.write("                      <i class=\"ace-icon fa fa-arrow-right\"></i>\n");
      out.write("                      ");
      if (_jspx_meth_t_005fdictSelect_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </a>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                </form>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"center\"><h4 class=\"blue\" id=\"id-company-text\">&copy; JEECG版权所有 v_3.7</h4></div>\n");
      out.write("            <div class=\"navbar-fixed-top align-right\">\n");
      out.write("              <br />\n");
      out.write("              &nbsp;\n");
      out.write("              <a id=\"btn-login-dark\" class=\"blue\" href=\"#\" onclick=\"darkStyle()\">Dark</a>\n");
      out.write("              &nbsp;\n");
      out.write("              <span class=\"blue\">/</span>\n");
      out.write("              &nbsp;\n");
      out.write("              <a id=\"btn-login-blur\" class=\"blue\" href=\"#\" onclick=\"blurStyle()\">Blur</a>\n");
      out.write("              &nbsp;\n");
      out.write("              <span class=\"blue\">/</span>\n");
      out.write("              &nbsp;\n");
      out.write("              <a id=\"btn-login-light\" class=\"blue\" href=\"#\" onclick=\"lightStyle()\">Light</a>\n");
      out.write("              &nbsp; &nbsp; &nbsp;\n");
      out.write("            </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery-1.8.3.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery.cookie.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/mutiLang/en.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/mutiLang/zh-cn.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/login/js/jquery.tipsy.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/login/js/iphone.check.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"plug-in/login/js/login.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(function(){\n");
      out.write("\t\toptErrMsg();\n");
      out.write("\t});\n");
      out.write("\t$(\"#errMsgContiner\").hide();\n");
      out.write("\tfunction optErrMsg(){\n");
      out.write("\t\t$(\"#showErrMsg\").html('');\n");
      out.write("\t\t$(\"#errMsgContiner\").hide();\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("   //输入验证码，回车登录\n");
      out.write("  $(document).keydown(function(e){\n");
      out.write("  \tif(e.keyCode == 13) {\n");
      out.write("  \t\t$(\"#but_login\").click();\n");
      out.write("  \t}\n");
      out.write("  });\n");
      out.write("\n");
      out.write("  //验证用户信息\n");
      out.write("  function checkUser(){\n");
      out.write("    if(!validForm()){\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("    newLogin();\n");
      out.write("  }\n");
      out.write("  //表单验证\n");
      out.write("  function validForm(){\n");
      out.write("    if($.trim($(\"#userName\").val()).length==0){\n");
      out.write("      showErrorMsg(\"请输入用户名\");\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if($.trim($(\"#password\").val()).length==0){\n");
      out.write("      showErrorMsg(\"请输入密码\");\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    if($.trim($(\"#randCode\").val()).length==0){\n");
      out.write("      showErrorMsg(\"请输入验证码\");\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("    return true;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  //登录处理函数\n");
      out.write("  function newLogin(orgId) {\n");
      out.write("    setCookie();\n");
      out.write("    var actionurl=$('form').attr('action');//提交路径\n");
      out.write("    var checkurl=$('form').attr('check');//验证路径\n");
      out.write("    var formData = new Object();\n");
      out.write("    var data=$(\":input\").each(function() {\n");
      out.write("      formData[this.name] =$(\"#\"+this.name ).val();\n");
      out.write("    });\n");
      out.write("    formData['orgId'] = orgId ? orgId : \"\";\n");
      out.write("    //语言\n");
      out.write("    formData['langCode']=$(\"#langCode\").val();\n");
      out.write("    formData['langCode'] = $(\"#langCode option:selected\").val();\n");
      out.write("    $.ajax({\n");
      out.write("      async : false,\n");
      out.write("      cache : false,\n");
      out.write("      type : 'POST',\n");
      out.write("      url : checkurl,// 请求的action路径\n");
      out.write("      data : formData,\n");
      out.write("      error : function() {// 请求失败处理函数\n");
      out.write("      },\n");
      out.write("      success : function(data) {\n");
      out.write("        var d = $.parseJSON(data);\n");
      out.write("        if (d.success) {\n");
      out.write("          if (d.attributes.orgNum > 1) {\n");
      out.write("          \t  //用户拥有多个部门，需选择部门进行登录\n");
      out.write("        \t  var title, okButton;\n");
      out.write("              if($(\"#langCode\").val() == 'en') {\n");
      out.write("                title = \"Please select Org\";\n");
      out.write("                okButton = \"Ok\";\n");
      out.write("              } else {\n");
      out.write("                title = \"请选择组织机构\";\n");
      out.write("                okButton = \"确定\";\n");
      out.write("              }\n");
      out.write("            $.dialog({\n");
      out.write("              id: 'LHG1976D',\n");
      out.write("              title: title,\n");
      out.write("              max: false,\n");
      out.write("              min: false,\n");
      out.write("              drag: false,\n");
      out.write("              resize: false,\n");
      out.write("              content: 'url:userController.do?userOrgSelect&userId=' + d.attributes.user.id,\n");
      out.write("              lock:true,\n");
      out.write("              button : [ {\n");
      out.write("                name : okButton,\n");
      out.write("                focus : true,\n");
      out.write("                callback : function() {\n");
      out.write("                  iframe = this.iframe.contentWindow;\n");
      out.write("                  var orgId = $('#orgId', iframe.document).val();\n");
      out.write("\n");
      out.write("                  formData['orgId'] = orgId ? orgId : \"\";\n");
      out.write("                  $.ajax({\n");
      out.write("              \t\tasync : false,\n");
      out.write("              \t\tcache : false,\n");
      out.write("              \t\ttype : 'POST',\n");
      out.write("              \t\turl : 'loginController.do?changeDefaultOrg',// 请求的action路径\n");
      out.write("              \t\tdata : formData,\n");
      out.write("              \t\terror : function() {// 请求失败处理函数\n");
      out.write("              \t\t},\n");
      out.write("              \t\tsuccess : function(data) {\n");
      out.write("              \t\t\twindow.location.href = actionurl;\n");
      out.write("              \t\t}\n");
      out.write("                  });\n");
      out.write("\n");
      out.write("                  this.close();\n");
      out.write("                  return false;\n");
      out.write("                }\n");
      out.write("              }],\n");
      out.write("              close: function(){\n");
      out.write("                setTimeout(\"window.location.href='\"+actionurl+\"'\", 10);\n");
      out.write("              }\n");
      out.write("            });\n");
      out.write("          } else {\n");
      out.write("            window.location.href = actionurl;\n");
      out.write("          }\n");
      out.write("       } else {\n");
      out.write("\t\t\tshowErrorMsg(d.msg);\n");
      out.write("\n");
      out.write("\t\t  \tif(d.msg === \"用户名或密码错误\" || d.msg === \"验证码错误\")\n");
      out.write("\t\t  \t\treloadRandCodeImage();\n");
      out.write("\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    });\n");
      out.write("  }\n");
      out.write("  //登录提示消息显示\n");
      out.write("  function showErrorMsg(msg){\t\n");
      out.write("    $(\"#errMsgContiner\").show();\n");
      out.write("    $(\"#showErrMsg\").html(msg);    \n");
      out.write("    window.setTimeout(optErrMsg,3000); \n");
      out.write("  }\n");
      out.write("  /**\n");
      out.write("   * 刷新验证码\n");
      out.write("   */\n");
      out.write("$('#randCodeImage').click(function(){\n");
      out.write("    reloadRandCodeImage();\n");
      out.write("});\n");
      out.write("function reloadRandCodeImage() {\n");
      out.write("    var date = new Date();\n");
      out.write("    var img = document.getElementById(\"randCodeImage\");\n");
      out.write("    img.src='randCodeImage?a=' + date.getTime();\n");
      out.write("}\n");
      out.write("\n");
      out.write("  function darkStyle(){\n");
      out.write("    $('body').attr('class', 'login-layout');\n");
      out.write("    $('#id-text2').attr('class', 'red');\n");
      out.write("    $('#id-company-text').attr('class', 'blue');\n");
      out.write("    e.preventDefault();\n");
      out.write("  }\n");
      out.write("  function lightStyle(){\n");
      out.write("    $('body').attr('class', 'login-layout light-login');\n");
      out.write("    $('#id-text2').attr('class', 'grey');\n");
      out.write("    $('#id-company-text').attr('class', 'blue');\n");
      out.write("\n");
      out.write("    e.preventDefault();\n");
      out.write("  }\n");
      out.write("  function blurStyle(){\n");
      out.write("    $('body').attr('class', 'login-layout blur-login');\n");
      out.write("    $('#id-text2').attr('class', 'white');\n");
      out.write("    $('#id-company-text').attr('class', 'light-blue');\n");
      out.write("\n");
      out.write("    e.preventDefault();\n");
      out.write("  }\n");
      out.write("//设置cookie\n");
      out.write("  function setCookie()\n");
      out.write("  {\n");
      out.write("  \tif ($('#on_off').val() == '1') {\n");
      out.write("  \t\t$(\"input[iscookie='true']\").each(function() {\n");
      out.write("  \t\t\t$.cookie(this.name, $(\"#\"+this.name).val(), \"/\",24);\n");
      out.write("  \t\t\t$.cookie(\"COOKIE_NAME\",\"true\", \"/\",24);\n");
      out.write("  \t\t});\n");
      out.write("  \t} else {\n");
      out.write("  \t\t$(\"input[iscookie='true']\").each(function() {\n");
      out.write("  \t\t\t$.cookie(this.name,null);\n");
      out.write("  \t\t\t$.cookie(\"COOKIE_NAME\",null);\n");
      out.write("  \t\t});\n");
      out.write("  \t}\n");
      out.write("  }\n");
      out.write("  //读取cookie\n");
      out.write("  function getCookie()\n");
      out.write("  {\n");
      out.write("  \tvar COOKIE_NAME=$.cookie(\"COOKIE_NAME\");\n");
      out.write("  \tif (COOKIE_NAME !=null) {\n");
      out.write("  \t\t$(\"input[iscookie='true']\").each(function() {\n");
      out.write("  \t\t\t$($(\"#\"+this.name).val( $.cookie(this.name)));\n");
      out.write("              if(\"admin\" == $.cookie(this.name)) {\n");
      out.write("                  $(\"#randCode\").focus();\n");
      out.write("              } else {\n");
      out.write("                  $(\"#password\").val(\"\");\n");
      out.write("                  $(\"#password\").focus();\n");
      out.write("              }\n");
      out.write("          });\n");
      out.write("  \t\t$(\"#on_off\").attr(\"checked\", true);\n");
      out.write("  \t\t$(\"#on_off\").val(\"1\");\n");
      out.write("  \t} \n");
      out.write("  \telse\n");
      out.write("  \t{\n");
      out.write("  \t\t$(\"#on_off\").attr(\"checked\", false);\n");
      out.write("  \t\t$(\"#on_off\").val(\"0\");\n");
      out.write("        $(\"#randCode\").focus();\n");
      out.write("  \t}\n");
      out.write("  }\n");
      out.write("</script>\n");
      out.print(lhgdialogTheme );
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_t_005fmutiLang_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:mutiLang
    org.jeecgframework.tag.core.easyui.MutiLangTag _jspx_th_t_005fmutiLang_005f0 = (org.jeecgframework.tag.core.easyui.MutiLangTag) _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.get(org.jeecgframework.tag.core.easyui.MutiLangTag.class);
    _jspx_th_t_005fmutiLang_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fmutiLang_005f0.setParent(null);
    // /webpage/login/login.jsp(14,9) name = langKey type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fmutiLang_005f0.setLangKey("jeect.platform");
    int _jspx_eval_t_005fmutiLang_005f0 = _jspx_th_t_005fmutiLang_005f0.doStartTag();
    if (_jspx_th_t_005fmutiLang_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.reuse(_jspx_th_t_005fmutiLang_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fmutiLang_0026_005flangKey_005fnobody.reuse(_jspx_th_t_005fmutiLang_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fdictSelect_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:dictSelect
    org.jeecgframework.tag.core.easyui.DictSelectTag _jspx_th_t_005fdictSelect_005f0 = (org.jeecgframework.tag.core.easyui.DictSelectTag) _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005fid_005fhasLabel_005ffield_005fextendJson_005fdefaultVal_005fnobody.get(org.jeecgframework.tag.core.easyui.DictSelectTag.class);
    _jspx_th_t_005fdictSelect_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fdictSelect_005f0.setParent(null);
    // /webpage/login/login.jsp(110,22) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setId("langCode");
    // /webpage/login/login.jsp(110,22) name = field type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setField("langCode");
    // /webpage/login/login.jsp(110,22) name = typeGroupCode type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setTypeGroupCode("lang");
    // /webpage/login/login.jsp(110,22) name = hasLabel type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setHasLabel(false);
    // /webpage/login/login.jsp(110,22) name = extendJson type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setExtendJson("{style:'padding:2px; width:80px;'}");
    // /webpage/login/login.jsp(110,22) name = defaultVal type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fdictSelect_005f0.setDefaultVal("zh-cn");
    int _jspx_eval_t_005fdictSelect_005f0 = _jspx_th_t_005fdictSelect_005f0.doStartTag();
    if (_jspx_th_t_005fdictSelect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005fid_005fhasLabel_005ffield_005fextendJson_005fdefaultVal_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fdictSelect_0026_005ftypeGroupCode_005fid_005fhasLabel_005ffield_005fextendJson_005fdefaultVal_005fnobody.reuse(_jspx_th_t_005fdictSelect_005f0);
    return false;
  }
}
