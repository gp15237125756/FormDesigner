package com.ld.codeGenerate.facade;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import com.ld.codeGenerate.factory.OneTableCodeFactory;
import com.ld.codeGenerate.generate.ICodeGenerator;
import com.ld.codeGenerate.generate.OneTableGenerator;
import com.ld.codeGenerate.utils.CodeResourceUtil;
import com.ld.codeGenerate.constant.CodeGenType;

import freemarker.template.TemplateException;
/**
 * 
 * 
 * code manufacture facade,block concrete details
 * @author Cruz
 * @Date 2017/10/27
 * @Version 1.0	
 * {@link ICodeGenerator#execute()}
 * 
 * 
 */
public class CodeManufactureContext {

	private static Integer PRODUCT_TYPE=CodeResourceUtil.product_type;
	
	public static void product(){
		if(Objects.equals(PRODUCT_TYPE, CodeGenType.SINGLE.getType())){
			try {
				System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss",Locale.CHINA))+" 代码生成开始, 生成类型："+CodeGenType.SINGLE.getName());
				//单表代码生成
				ICodeGenerator codeGenerator=new OneTableGenerator(new OneTableCodeFactory());
				codeGenerator.execute();
				System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss",Locale.CHINA))+" 代码生成成功, 生成类型："+CodeGenType.SINGLE.getName());
			} catch (TemplateException | IOException e) {
				System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< "+"单表代码生成异常，Message: "+e.getMessage());
			}
		}
	}
}
