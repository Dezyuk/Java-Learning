package String_training;

import java.util.Arrays;
import java.util.Scanner;

public class String_trim {
    public static void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter any text: ");
        String userInput = sc.nextLine();
        System.out.print("You entered these words: ");
        System.out.println(Arrays.toString(userInput.split("[\\s\\p{P}]+")));
    }
}
