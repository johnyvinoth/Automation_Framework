package org.listners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyInvokedMethodListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.beforeInvocation(method, testResult);
        System.out.println("Before Invocation of Listeners starts on the method :"+method.getTestMethod().toString());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        System.out.println("Before Invocation of Listener starts on the method :"+method.getTestMethod() + " and the test result is : "+ (testResult.isSuccess() ? "Pass" : "Fail"));
    }


}
