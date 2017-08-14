package ru.alternation.examples.Youtube.CSC.reflection2.junit;

import com.google.common.reflect.ClassPath;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

public class JUnitRunner {

    public static void main(String[] args) throws Exception {
        String packageName = "ru.alternation.examples.Youtube.CSC.reflection2.junit.tests"; //args[0];
        Set<ClassPath.ClassInfo> classesInPackage =
                ClassPath.from(ClassLoader.getSystemClassLoader())
                        .getTopLevelClasses(packageName);

        for (ClassPath.ClassInfo classInfo : classesInPackage) {
            if (classInfo.getSimpleName().contains("Test")) {
                executeTest(classInfo.load());
            }
        }
    }

    private static void executeTest(Class<?> testClass) throws Exception {
        Object testInstance = testClass.getConstructor().newInstance();
        for (Method method : testClass.getDeclaredMethods()) {
            if (isTestMethod(method)) {
                method.invoke(testInstance);
            }
        }
    }

    private static boolean isTestMethod(Method method) {
        return method.getReturnType().equals(void.class)
                //&& (method.getModifiers() & Modifier.STATIC) == 0
                && (method.getModifiers() & Modifier.PUBLIC) != 0
                && method.getParameterCount() == 0
                && method.isAnnotationPresent(Test.class);
    }
}
