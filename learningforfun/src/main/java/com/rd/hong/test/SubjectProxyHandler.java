package com.rd.hong.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 51ky on 2016/9/9.
 */
public class SubjectProxyHandler implements InvocationHandler {

    private Object target;

    @SuppressWarnings("rawtypes")
    public SubjectProxyHandler(Class clazz) {
        try {
            this.target = clazz.newInstance();
        }
        catch (Exception ex) {
        }
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preAction();
        Object result = method.invoke(target, args);
        postAction();
        return result;
    }

    private void preAction() {
        System.out.print("SubjectProxyHandler.preAction()");
    }

    private void postAction() {
        System.out.print("SubjectProxyHandler.postAction()");
    }

}
