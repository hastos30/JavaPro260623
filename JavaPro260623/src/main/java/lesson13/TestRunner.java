package main.java.lesson13;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    int priority() default 5;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeSuite {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterSuite {
}

class TestRunner {
    public static void start(Class<?> testClass) {
        try {
            Object testInstance = testClass.getDeclaredConstructor().newInstance();
            Method[] methods = testClass.getDeclaredMethods();

            // Розділити методи на BeforeSuite, Test та AfterSuite
            List<Method> beforeSuiteMethods = Arrays.stream(methods)
                    .filter(method -> method.isAnnotationPresent(BeforeSuite.class))
                    .collect(Collectors.toList());

            List<Method> testMethods = Arrays.stream(methods)
                    .filter(method -> method.isAnnotationPresent(Test.class))
                    .sorted(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority()))
                    .collect(Collectors.toList());

            List<Method> afterSuiteMethods = Arrays.stream(methods)
                    .filter(method -> method.isAnnotationPresent(AfterSuite.class))
                    .collect(Collectors.toList());

            if (beforeSuiteMethods.size() > 1 || afterSuiteMethods.size() > 1) {
                throw new RuntimeException("Помилка: BeforeSuite або AfterSuite повинні бути присутніми лише в єдиному екземплярі.");
            }

            if (!beforeSuiteMethods.isEmpty()) {
                beforeSuiteMethods.get(0).invoke(testInstance);
            }

            for (Method testMethod : testMethods) {
                testMethod.invoke(testInstance);
            }

            if (!afterSuiteMethods.isEmpty()) {
                afterSuiteMethods.get(0).invoke(testInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

