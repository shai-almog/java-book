package com.debugagent.ch02.patterns.proxy;

import java.lang.reflect.Proxy;

public class GenericSecurityProxy {
    private boolean permission;

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public Object create(Object wrappedObject, Class<?> wrappedInterface) {
        return Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{wrappedInterface},
                (proxy, method, args) -> {
                    if(permission) {
                        return method.invoke(wrappedObject, args);
                    }
                    return null;
                });
    }

    public static void main(String[] argv) {
        Runnable r = () -> System.out.println("Print invoked");
        GenericSecurityProxy g = new GenericSecurityProxy();
        Runnable wrapper = (Runnable)g.create(r, Runnable.class);
        wrapper.run();
        g.setPermission(true);
        wrapper.run();
    }
}
