package com.cucumber.test;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		if (method.isTestMethod() && ITestResult.FAILURE == result.getStatus()) {
			Throwable throwable = result.getThrowable();
			String originalMessage = throwable.getMessage();
			String newMessage = originalMessage + "\nReproduction Seed: ...\nCountry: ...";
			try {
				FieldUtils.writeField(throwable, "detailMessage", newMessage, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}