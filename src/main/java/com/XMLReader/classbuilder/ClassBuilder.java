package com.XMLReader.classbuilder;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.lang.model.element.Modifier;

import com.XMLReader.entities.struts.FormBean;
import com.XMLReader.entities.struts.FormProperty;
import com.XMLReader.entities.struts.StrutsConfig;
import com.squareup.javapoet.TypeSpec.Builder;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class ClassBuilder {
	
	private final String CLASS_SUPFIX = "Form";
	private final String METHOD_REFIX_GET = "get";
	private final String METHOD_REFIX_SET = "set";
	
	public void buildFormBean(StrutsConfig strutsConfig) {
		strutsConfig.getFormBeans().getLstFormBean().forEach(formBean -> {
			Builder classBuilder = TypeSpec.classBuilder(formBean.getName() + CLASS_SUPFIX).addModifiers(Modifier.PUBLIC);
			addAttribute(formBean, classBuilder);
			
			TypeSpec formClass = classBuilder.build();
			JavaFile javaFile = JavaFile.builder("com.example.helloworld", formClass).build();
			
			try {
				javaFile.writeTo(System.out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	private void addAttribute(FormBean formBean, Builder classBuilder) {
		formBean.getLstProperties().forEach(property -> {
			try {
				String dataType = property.getType();
				Class<?> clazz = void.class;
				
				if (dataType != null) {
					if (dataType.contains("[]")) {
						dataType = dataType.substring(0, dataType.length() - 2);
						Class tempClass = Class.forName(dataType);
						clazz = Array.newInstance(tempClass, 0).getClass();
					} else {
						clazz = Class.forName(dataType);
					}
				}
				
				classBuilder.addField(clazz, property.getName(), Modifier.PRIVATE)
					.addMethod(createSetMethod(property, clazz))
					.addMethod(createGetMethod(property, clazz));
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		});
	}
	
	private MethodSpec createSetMethod(FormProperty formProperty, Class<?> clazz) {
		StringBuilder methodName = new StringBuilder();
		methodName.append(METHOD_REFIX_SET);
		methodName.append(formProperty.getName().substring(0, 1).toUpperCase());
		methodName.append(formProperty.getName().substring(1));
		
		StringBuilder statement = new StringBuilder();
		statement.append("this.");
		statement.append(formProperty.getName());
		statement.append(" = ");
		statement.append(formProperty.getName());
		
		MethodSpec setter = MethodSpec.methodBuilder(methodName.toString())
				.addModifiers(Modifier.PUBLIC)
				.returns(void.class)
				.addParameter(clazz, formProperty.getName())
				.addStatement(statement.toString())
				.build();
		
		return setter;
	}
	
	private MethodSpec createGetMethod(FormProperty formProperty, Class<?> clazz) {
		StringBuilder methodName = new StringBuilder();
		methodName.append(METHOD_REFIX_GET);
		methodName.append(formProperty.getName().substring(0, 1).toUpperCase());
		methodName.append(formProperty.getName().substring(1));
		
		MethodSpec getter = MethodSpec.methodBuilder(methodName.toString())
				.addModifiers(Modifier.PUBLIC)
				.returns(clazz)
				.addStatement("return this.$N", formProperty.getName())
				.build();
		
		return getter;
	}
	
	
	public static void main(String[] args) {
		MethodSpec main = MethodSpec.methodBuilder("main")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(void.class)
				.addParameter(String[].class, "args")
				.addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
				.build();
		
		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addField(String.class, "greeting", Modifier.PRIVATE, Modifier.FINAL)
				.addMethod(main)
				.build();
		
		JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld).build();
		
		try {
			javaFile.writeTo(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
