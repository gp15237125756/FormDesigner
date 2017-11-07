package com.ld.codeGenerate.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class PathUtil {
	
	
	//accept a string, like aCamelString
	//return a list containing strings, in this case, [a, Camel, String]
	public static List<String> splitCamelCaseString(String s){
	  /*  LinkedList<String> result = new LinkedList<String>();	
	    for (String w : s.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
	    	result.add(w);
	    }  */  
		if(StringUtils.isBlank(s)){
			return new ArrayList<String>();
		}
		
	    String[] separateWords=StringUtils.splitByCharacterTypeCamelCase(s);
	    return Stream.of(separateWords).filter(Objects::nonNull).map(StringUtils::uncapitalize).collect(Collectors.toList());
	}

	public static String costructXmlFileName(String moduleName,String entityName){
		StringBuilder sb=new StringBuilder();
		sb.append("struts-");
		sb.append(moduleName);
		sb.append("-");
		splitCamelCaseString(entityName).stream().forEach((x)->sb.append(x).append("-"));
		sb.append("manage.xml");
		return sb.toString();
	}
	
	/***
	 * form entire dto java file path
	 * @param entityName
	 * @return {String}
	 */
	public static String getDtoPath(final String entityName,String file_seperator,String dtoPackageURL,String dtoName,String suffix){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(dtoPackageURL);
		sb.append(dtoName);
		sb.append(suffix);
		return sb.toString();
	}
	
	/***
	 * form entire Search dto java file path
	 * @param entityName
	 * @return {String}
	 */
	public static  String getSearchDtoPath(final String entityName,String file_seperator,String dtoPackageURL,String search_dtoName,String suffix){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(dtoPackageURL);
		sb.append("search").append(file_seperator);
		sb.append(search_dtoName);
		sb.append(suffix);
		return sb.toString();
	}
	
	/***
	 * form entire Search dto java file path
	 * @param entityName
	 * @return {String}
	 */
	public static  String getDaoPath(final String entityName,String file_seperator,String daoPackageURL,String daoName,String suffix){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(daoPackageURL);
		sb.append(daoName);
		sb.append(suffix);
		return sb.toString();
	}
	
	/***
	 * form entire Search dto java file path
	 * @param entityName
	 * @return {String}
	 */
	public static  String getXmlPath(final String entityName,String file_seperator,String routeXmlPackageURL,String routeXmlName){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(routeXmlPackageURL);
		sb.append(routeXmlName);
		return sb.toString();
	}
	
	
	public static String getJspManagePath(final String entityName,String file_seperator,String jspPackageURL){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(jspPackageURL);
		sb.append(StringUtils.capitalize(entityName)).append("Manage");
		sb.append(file_seperator);
		sb.append(StringUtils.capitalize(entityName)).append("Manage");
		sb.append(".jsp");
		return sb.toString();
	}
	
	public static String getJspRegisterPath(final String entityName,String file_seperator,String jspPackageURL){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(jspPackageURL);
		sb.append(StringUtils.capitalize(entityName)).append("Manage");
		sb.append(file_seperator);
		sb.append(StringUtils.capitalize(entityName)).append("Register");
		sb.append(".jsp");
		return sb.toString();
	}
	
	public static String getJspResultPath(final String entityName,String file_seperator,String jspPackageURL){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(jspPackageURL);
		sb.append(StringUtils.capitalize(entityName)).append("Manage");
		sb.append(file_seperator);
		sb.append(StringUtils.capitalize(entityName)).append("Result");
		sb.append(".jsp");
		return sb.toString();
	}
	
	public static String getJsPath(final String entityName,String file_seperator,String jsPackageURL,String type){
		StringBuilder sb=new StringBuilder();
		sb.append(CodeResourceUtil.project_path);
		sb.append(file_seperator);
		sb.append(jsPackageURL);
		sb.append(StringUtils.capitalize(entityName));
		sb.append(file_seperator);
		if(StringUtils.equals(type,"manage")){
			sb.append("manage");
		}else{
			sb.append("register");
		}
		sb.append(".js");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		List<?> list=splitCamelCaseString("MemberArticle");
		list.stream().forEach(System.out::println);
	}
}
