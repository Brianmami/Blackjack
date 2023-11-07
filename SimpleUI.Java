package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("Your cards:\n" + game.getYourCards());
        System.out.println("House cards:\n" + game.getHouseCards());    
    }

  @Override
    public boolean hitMe() {
        String result;
        while(true){
        System.out.println("Hitting or Standing? (y/n)");
        result = user.nextLine();
            if ("y".equals(result.toLowerCase())){
                return true;
            }  else if("n".equals(result.toLowerCase())){
                return false;
            }
        }
    }

  @Override
    public void gameOver() {
        System.out.println("House holds:" + game.getHouseCards());
        System.out.println("House Score: " + game.score(game.getHouseCards()));
        System.out.println("Your Score: " + game.score(game.getYourCards()));
        
        int houseScore = game.score(game.getHouseCards());
        int yourScore = game.score(game.getYourCards());

        if (houseScore <= 21 && yourScore <= 21) {
            if (houseScore > yourScore) {
                System.out.println("House wins");
             } else if (yourScore > houseScore) {
                System.out.println("You win");
             } else if (houseScore == yourScore) {
                System.out.println("House Wins");
             }
         } else if (houseScore <= 21 && yourScore > 21) {
            System.out.println("House wins");
         } else if (houseScore > 21 && yourScore <= 21) {
            System.out.println("You win");
         } else if (houseScore > 21 && yourScore > 21) {
            System.out.println("House wins");
         } else {
             System.out.println("Your cards:\n" + game.getYourCards());
             System.out.println("House cards:\n" + game.getHouseCards());
         }
    }
}
