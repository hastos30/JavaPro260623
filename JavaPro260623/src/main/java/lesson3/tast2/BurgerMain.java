package lesson3.tast2;

public class BurgerMain {
    public static void main(String[] args) {
        System.out.println("Звичайний бургер:");
        Burger burger1 = new Burger();

        System.out.println("Дієтичний  бургер:");
        Burger burger2 = new Burger(true, true, true, true);

        System.out.println("Double-meat бургер:");
        Burger burger3 = new Burger(true, true, true, true, true,true);
    }
}
