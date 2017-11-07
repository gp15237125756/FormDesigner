package com.ld.codeGenerate.generate;

import java.io.IOException;

import freemarker.template.TemplateException;

@FunctionalInterface
public interface ICodeGenerator{

	void execute()  throws TemplateException, IOException ;
}
