import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        RecipeSearch recipeSearch = new RecipeSearch(scanner);
        UserInterace userInterface = new UserInterace(scanner, recipeSearch);
        userInterface.start();

    }
}