package main.java.lesson13;

public class MyTest {
    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("Before Suite");
    }

    @Test(priority = 3)
    public void testMethod1() {
        System.out.println("Test 1");
    }

    @Test(priority = 1)
    public void testMethod2() {
        System.out.println("Test 2");
    }

    @Test(priority = 2)
    public void testMethod3() {
        System.out.println("Test 3");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("After Suite");
    }

    public static void main(String[] args) {
        TestRunner.start(MyTest.class);
    }
}


