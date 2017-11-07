package com.ld.codeGenerate.generate;

import java.io.IOException;

import com.ld.codeGenerate.factory.BaseCodeFactory;

import freemarker.template.TemplateException;

/**
 * single table generator implement
 * @author Cruz
 * @version 1.0
 */
public class OneTableGenerator implements ICodeGenerator {

	private BaseCodeFactory codeFactory;
	
	public OneTableGenerator(BaseCodeFactory codeFactory){
		this.codeFactory=codeFactory;
	}
	
	@Override
	public void execute() throws TemplateException, IOException {
		codeFactory.produce();
	}

}
