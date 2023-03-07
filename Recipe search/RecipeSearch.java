import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RecipeSearch{

    private Scanner scanner;
    private ArrayList<String> recipeName, cookingTime, ingredients;

    public RecipeSearch(Scanner scanner){
        this.scanner = scanner;
        this.recipeName = new ArrayList<>();
        this.cookingTime = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }    

    public void fileReader(String file){
        try(Scanner scanner = new Scanner(Paths.get(file))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    for(int i=0; i<1; i++)
                        this.recipeName.add(scanner.nextLine());
                    for(int i=0; i<1; i++)
                        this.cookingTime.add(scanner.nextLine());
                }
                this.ingredients.add(line);
            }
            // System.out.println("RECICPE: "+recipeName);
            // System.out.println("TIME: "+cookingTime);
            // System.out.println("INGREDIENT: "+ingredients);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void commandReader(String command){       
            if(command.equals("stop")){
                System.exit(0);

            }
            if(command.equals("list")){
                System.out.println("Recipes: ");
                for(int i=0; i<recipeName.size(); i++){
                    System.out.println(recipeName.get(i)+", cooking time: "+cookingTime.get(i));
                }
                System.out.println("");
            }
            if(command.equals("find name")){
                System.out.print("Searched word: ");
                String word = scanner.nextLine();
                System.out.println("Recipes: ");
                for(int i=0; i<recipeName.size(); i++){
                    if(recipeName.get(i).equals(word)){
                        System.out.println(recipeName.get(i)+", cooking time: "+cookingTime.get(i));
                    }
                }
                System.out.println("");
            }
            if(command.equals("find cooking time")){
                System.out.print("Max cooking time: ");
                String time = scanner.nextLine();
                int max = Integer.valueOf(time);
                System.out.println("Recipes: ");
                for(int i=0; i<cookingTime.size(); i++){
                    int number = Integer.valueOf(cookingTime.get(i)); 
                    if(number<=max){
                        System.out.println(recipeName.get(i)+", cooking time: "+cookingTime.get(i));
                    }
                    else{
                        System.out.println("none recipe match cooking time: "+max);
                        break;
                    }
                }
            }
            if(command.equals("find ingredient")){
                int recipe = -1;
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();
                System.out.println("Recipes: ");
                for(int i=0; i<ingredients.size(); i++){
                    if(ingredients.get(i).equals("")){
                    recipe++;
                    }
                    if(ingredients.get(i).equals(ingredient)){
                        System.out.println(recipeName.get(recipe)+", cooking time: "+cookingTime.get(recipe));
                    }
                }
            }
        }

}