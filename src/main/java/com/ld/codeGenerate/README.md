需求说明
========

代码生成器它只是一个模板引擎而已，最重要的不是代码生成器本身，而是对一类功能或一类页面的代码规范，对自己代码的提炼，提炼出一个通用的模板。
比如我们常见的查询页面，录入页面等，我们只要提炼一个标准的查询页面的代码，包括前台html，前台js,后台控制器，后台数据服务。然后把它写成模板，再利用模板引擎就可以生成我们需要的代码了。

代码生成器
========

v1.0 生成主表CRUD代码。
一对多、一对一自行扩展。

# 限制条件

- 由于项目中数据库字段命名类似（V000001），无法根据表的元数据取得字段的实际名称（语义化名字），所以pojo实体自行生成，生成其他类依赖主表的实体类全限定名。
- 实际业务中，画面可能需要传 List,Map等业务相关数据，请自行扩展。
- 字段中文含义从ddl语句 SHOW CREATE TABLE `XX`;取comment，不存在则取propertyName。

## 场景

需要快速生成主表crud共通代码（包含XML）

## 依赖

Freemarker。


# 使用方法

* 1.修改*code_config.properties*，修改configure below下面的配置即可 <br>
  actionFlag=false  	是否根据Model生成Action <br>
  serviceIFlag=false	（本项目无Service接口，可忽略） <br>
  entityFlag=false  	是否根据Model生成Action <br>
  dtoFlag=false			是否根据Model生成Dto <br>
  daoFlag=false			是否根据Model生成Dao <br>
  searchDtoFlag=false	是否根据Model生成SearchDto <br>
  serviceImplFlag=false	是否根据Model生成Service <br>
  jspFlag=true			是否根据Model生成Jsp <br>
  jsFlag=true			是否根据Model生成Js <br>
  routeXmlFlag=false 	是否根据Model生成路由Xml <br>
  project_path			项目本地绝对路径 <br>
  table_name			数据库表名 <br>
  entityFullName		Model全名，如com.ld.audience.entity.MemberArticle <br>
  module_name			所属模块 ，如audience <br>
  module_name_ch		Model对应模块中文名称 <br>
* 2.运行*CodeApplication*

# 后续开发
- JSP画面Model属性Validate规则，如String 长度，是否必须，数字类型规则。。
- 一对多、一对一子模型规则定义





		



				
