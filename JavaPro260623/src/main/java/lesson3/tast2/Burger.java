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
        this.bun = Ingredient.BUN;
        this.meat = Ingredient.MEAT;
        this.cheese = Ingredient.CHEESE;
        this.greenery = Ingredient.GREENERY;
        this.mayonnaise = Ingredient.MAYONNAISE;
        printIngredients();
    }

    public Burger(boolean bun, boolean meat, boolean cheese, boolean greenery) {
        this.bun = bun ? Ingredient.BUN : null;
        this.meat = meat ? Ingredient.MEAT : null;
        this.cheese = cheese ? Ingredient.CHEESE : null;
        this.greenery = greenery ? Ingredient.GREENERY : null;
        this.mayonnaise = null;
        printIngredients();
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
        System.out.println("М'ясо   - " + (meat != Ingredient.DOUBLE_MEAT ? meat : "n/a"));

        /*
        Я не знаю какую структуру лучше выбрать, потому закоментирую один из способов.
        Я бы улучшил код и сделал проверку на все что угодно, но в задании такого не написано :)
        */

        /*if (meat == Ingredient.DOUBLE_MEAT) {
            System.out.println("М'ясо   - " + Ingredient.DOUBLE_MEAT);
        } else {
            System.out.println("М'ясо   - " + meat);
        }*/
        System.out.println("Сир     - " + cheese);
        System.out.println("Зелень  - " + greenery);

        System.out.println("Майонез - " + (mayonnaise != null ? Ingredient.MAYONNAISE : "n/a"));
        System.out.println();
    }
}
