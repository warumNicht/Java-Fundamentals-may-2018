import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input=scanner.nextLine().split("\\s+");

        Predicate<String> checkUpperCase =s-> Character.isUpperCase(s.charAt(0));

        ArrayList<String> result=new ArrayList<>();
        for (String s : input) {
            if(checkUpperCase.test(s)){
                result.add(s);
            }
        }
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

    }
}
