package lesson3.part2;

public class Burger {

    private final boolean BUN = true;
    private int meat = 1;
    private final boolean CHEESE = true;
    private final boolean GREENERY = true;
    private boolean mayonnaise = true;

    public Burger() {
        System.out.println(
                "\tЗвичайний бургер:\n" +
                "Булочка - " + BUN + "\n" +
                "М'ясо   - " + meat + "\n" +
                "Cир     - " + CHEESE + "\n" +
                "Зелень  - " + GREENERY + "\n" +
                "Майонез - " + mayonnaise + "\n"
        );
    }

    public Burger(boolean mayonnaise) {
        this.mayonnaise = mayonnaise;
        System.out.println(
                "\tДієтичний бургер:\n" +
                        "Булочка - " + BUN + "\n" +
                        "М'ясо   - " + meat + "\n" +
                        "Cир     - " + CHEESE + "\n" +
                        "Зелень  - " + GREENERY + "\n" +
                        "Майонез - " + this.mayonnaise + "\n"
        );
    }

    public Burger(int meat) {
        this.meat = meat;
        System.out.println(
                "\tПодвійний бургер:\n" +
                        "Булочка - " + BUN + "\n" +
                        "М'ясо   - " + this.meat + "\n" +
                        "Cир     - " + CHEESE + "\n" +
                        "Зелень  - " + GREENERY + "\n" +
                        "Майонез - " + mayonnaise + "\n"
        );

    }
}
