package ru.alternation.Trash.Others.Trash.SuppressedExceptions;


public class SuppressedExceptionDemoSimple {
    public static void main(String[] arguments) throws Exception
    {

        DirtyResource resource = new DirtyResource();
        resource.accessResource();
        resource.close();

    }
}

/*
Exception in thread "main" java.lang.RuntimeException: From 'void accessResource()'
	at ru.alternation.Trash.Others.Trash.SuppressedExceptions.DirtyResource.accessResource(DirtyResource.java:17)
	at ru.alternation.Trash.Others.Trash.SuppressedExceptions.SuppressedExceptionDemoSimple.main(SuppressedExceptionDemoSimple.java:9)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
 */