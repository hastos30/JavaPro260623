package main.java.lesson13;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Class<?> testClass) {
        try {
            Object instance = testClass.getDeclaredConstructor().newInstance();

            Method beforeSuiteMethod = null;
            Method afterSuiteMethod = null;
            List<Method> testMethods = new ArrayList<>();

            for (Method method : testClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(CastomAnnotation.BeforeSuite.class)) {
                    if (beforeSuiteMethod == null) {
                        beforeSuiteMethod = method;
                    } else {
                        throw new RuntimeException("Multiple @BeforeSuite methods found.");
                    }
                } else if (method.isAnnotationPresent(CastomAnnotation.AfterSuite.class)) {
                    if (afterSuiteMethod == null) {
                        afterSuiteMethod = method;
                    } else {
                        throw new RuntimeException("Multiple @AfterSuite methods found.");
                    }
                } else if (method.isAnnotationPresent(CastomAnnotation.Test.class)) {
                    testMethods.add(method);
                }
            }

            testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(CastomAnnotation.Test.class).priority()));

            if (beforeSuiteMethod != null) {
                beforeSuiteMethod.invoke(instance);
            }

            for (Method testMethod : testMethods) {
                testMethod.invoke(instance);
            }

            if (afterSuiteMethod != null) {
                afterSuiteMethod.invoke(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

