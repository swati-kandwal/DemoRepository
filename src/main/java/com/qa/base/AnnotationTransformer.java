package com.qa.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{
	
	@Override
	public void transform(ITestAnnotation annotaion, Class testClass , Constructor constructor , Method method) {
		annotaion.setRetryAnalyzer(RetryAnalayzer.class);		
		
	}

	

}
