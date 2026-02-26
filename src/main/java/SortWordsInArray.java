import java.util.Arrays;
import java.util.Scanner;

public class SortWordsInArray {
    public static void main(String[] args) {
        System.out.print("Please, enter words separated by space: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] userInputSeparate = userInput.split(" ");
        Arrays.sort(userInputSeparate, (s1,s2) ->{
            int result = s2.length() - s1.length();
            if(result==0){
                result = s1.compareToIgnoreCase(s2);
            }
            return result;
        });
        System.out.println(Arrays.toString(userInputSeparate));
    }
}
