import java.util.Scanner;

public class UserInterace {

    private RecipeSearch recipeSearch;
    private Scanner scanner;

    public UserInterace(Scanner scanner, RecipeSearch recipeSearch){
        this.recipeSearch = recipeSearch;
        this.scanner = scanner;
    }
        public void start(){
            readFile();
            readCommand();
        }
            public void readFile(){
                System.out.print("File to read: ");
                String file = scanner.nextLine();
                recipeSearch.fileReader(file);
                System.out.println("");
            }
            public void readCommand(){
                System.out.println("Commands: ");
                System.out.println("list - lists the recipes");
                System.out.println("stop - stops the program");
                System.out.println("find name - searches recipes by name");
                System.out.println("find cooking time - searches recipes by cooking time");
                System.out.println("find ingredient - searches recipes by ingredient");
                System.out.println("");
                while(true){
                    System.out.print("Enter command: ");
                    String command = scanner.nextLine();
                    recipeSearch.commandReader(command);
                }
            }
    
}
