import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _7_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        String[] names=scanner.nextLine().split("\\s+");

        Predicate<String> chechName=x->x.length()<=n;

        Arrays.stream(names).forEach(s->{
            if(chechName.test(s)){
                System.out.println(s);
            }
        });

    }
}
