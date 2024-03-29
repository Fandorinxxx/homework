package ru.alternation.examples.others.trash.suppressed_exceptions;


public class SuppressedExceptionDemoWithTryWithResource
{
    /**
     * Demonstrating suppressed exceptions using try-with-resources
     */
    public static void main(String[] arguments) throws Exception
    {
        try (DirtyResource resource = new DirtyResource())
        {
            resource.accessResource();
        }
    }
}
 /*
Output:

Exception in thread "main" java.lang.RuntimeException: From 'void accessResource()'
	at ru.alternation.examples.others.trash.suppressed_exceptions.DirtyResource.accessResource(DirtyResource.java:17)
	at ru.alternation.examples.others.trash.suppressed_exceptions.SuppressedExceptionDemoWithTryWithResource.main(SuppressedExceptionDemoWithTryWithResource.java:13)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
	Suppressed: java.lang.NullPointerException: From 'void close()'
		at DirtyResource.close(DirtyResource.java:27)
		at SuppressedExceptionDemoWithTryWithResource.main(SuppressedExceptionDemoWithTryWithResource.java:14)
		... 5 more


*/