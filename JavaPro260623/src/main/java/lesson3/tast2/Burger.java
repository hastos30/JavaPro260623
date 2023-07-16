package lesson3.tast2;

public class Burger {
    public enum Ingredient {
        BUN, MEAT, CHEESE, GREENERY, MAYONNAISE, DOUBLE_MEAT
    }

    private Ingredient bun;
    private Ingredient meat;
    private Ingredient cheese;
    private Ingredient greenery;
    private Ingredient mayonnaise;

    public Burger() {
        this(true, true, true, true, true, false);
    }

    public Burger(boolean bun, boolean meat, boolean cheese, boolean greenery) {
        this(bun, meat, cheese, greenery, false, false);
    }

    public Burger(boolean bun, boolean meat, boolean cheese, boolean greenery, boolean mayonnaise, boolean doubleMeat) {
        this.bun = bun ? Ingredient.BUN : null;
        this.meat = doubleMeat ? Ingredient.DOUBLE_MEAT : (meat ? Ingredient.MEAT : null);
        this.cheese = cheese ? Ingredient.CHEESE : null;
        this.greenery = greenery ? Ingredient.GREENERY : null;
        this.mayonnaise = mayonnaise ? Ingredient.MAYONNAISE : null;

        printIngredients();
    }

    private void printIngredients() {
        System.out.println("\tСклад бургера:");
        System.out.println("Булочка - " + bun);
        System.out.println("М'ясо   - " + (meat != null ? meat : "n/a"));
        System.out.println("Сир     - " + cheese);
        System.out.println("Зелень  - " + greenery);
        System.out.println("Майонез - " + (mayonnaise != null ? Ingredient.MAYONNAISE : "n/a"));
        System.out.println();
    }
}
