import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
    void displayMealDetails();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegetarian Meal: Includes fruits, vegetables, grains, and dairy.");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegan Meal: Includes plant-based foods only, no dairy or animal products.");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Keto Meal: Low-carb, high-fat diet with proteins and healthy fats.");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }

    @Override
    public void displayMealDetails() {
        System.out.println("High-Protein Meal: Rich in protein sources like meat, eggs, and legumes.");
    }
}

class Meal<T extends MealPlan> {
    private String userName;
    private T mealType;

    public Meal(String userName, T mealType) {
        this.userName = userName;
        this.mealType = mealType;
    }

    public String getUserName() {
        return userName;
    }

    public T getMealType() {
        return mealType;
    }

    public void displayMealPlan() {
        System.out.println("User: " + userName + " | Meal Plan: " + mealType.getMealType());
        mealType.displayMealDetails();
    }
}

class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();

    public void addMealPlan(Meal<? extends MealPlan> meal) {
        mealPlans.add(meal);
    }

    public void displayAllMealPlans() {
        for (Meal<? extends MealPlan> meal : mealPlans) {
            meal.displayMealPlan();
            System.out.println("--------------------");
        }
    }

    public static <T extends MealPlan> void validateAndGenerateMealPlan(String userName, T mealType) {
        System.out.println("Generating meal plan for " + userName + "...");
        mealType.displayMealDetails();
        System.out.println("Meal Plan successfully created!\n");
    }
}

public class MealPlanSystem {
    public static void main(String[] args) {
        Meal<VegetarianMeal> user1 = new Meal<>("Alice", new VegetarianMeal());
        Meal<VeganMeal> user2 = new Meal<>("Bob", new VeganMeal());
        Meal<KetoMeal> user3 = new Meal<>("Charlie", new KetoMeal());
        Meal<HighProteinMeal> user4 = new Meal<>("David", new HighProteinMeal());

        MealPlanGenerator generator = new MealPlanGenerator();
        generator.addMealPlan(user1);
        generator.addMealPlan(user2);
        generator.addMealPlan(user3);
        generator.addMealPlan(user4);

        System.out.println("Meal Plans for Users:");
        generator.displayAllMealPlans();

        System.out.println("\nValidating and Generating New Meal Plans:");
        MealPlanGenerator.validateAndGenerateMealPlan("Eve", new VegetarianMeal());
        MealPlanGenerator.validateAndGenerateMealPlan("Frank", new HighProteinMeal());
    }
}
