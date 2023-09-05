package main.java.lesson13;

public class MyTest {
    @CastomAnnotation.BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @CastomAnnotation.Test(priority = 2)
    public void test1() {
        System.out.println("Test 1");
    }

    @CastomAnnotation.Test(priority = 1)
    public void test2() {
        System.out.println("Test 2");
    }

    @CastomAnnotation.Test(priority = 2)
    public void test3() {
        System.out.println("Test 3");
    }

    @CastomAnnotation.AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
    }

    public static void main(String[] args) {
        TestRunner.start(MyTest.class);
    }
}
