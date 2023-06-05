
import java.util.Random;
import java.util.Scanner;

class Game{
    public int number;
    public int inputNumber;
    public int noOfGuesses = 0;

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    Game(){
        Random rand = new Random();
        this.number = rand.nextInt(1,100);
    }

    void takeUserInput(){
        System.out.println("Guess the number (Range= 1 to 100)");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }

    boolean isCorrectNumber(){
        noOfGuesses++;
        if(inputNumber == number) {
            System.out.printf("Yes you guessed it right, it was %d\n You guessed it in %d attmpt \n  Your score is %d", number, noOfGuesses, 100-noOfGuesses);
            return true;
        }
        else if(inputNumber < number){
            System.out.println("Too low.......Enter higher number");
        }
        else if(inputNumber > number) {
            System.out.println(" Too high......Enter lower number");
        }
        if (inputNumber <= 0 || inputNumber > 100){
            System.out.println("Out of range!!!");
        }
        return false;
    }
}

public class guess_the_number {
    public static  void main(String[] args) {
        Game g = new Game();
        boolean b = false;
        while(!b) {
            g.takeUserInput();
            b = g.isCorrectNumber();
        }
    }
}