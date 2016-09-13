package com.rd.hong.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by 51ky on 2016/9/9.
 */
public class JDKDynamicProxyClient {
    public static void main(String[] args) {
        InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
        ISubject proxy =
                (ISubject) Proxy.newProxyInstance(JDKDynamicProxyClient.class.getClassLoader(),
                        new Class[] {ISubject.class}, handler);
        proxy.action();
    }

}
