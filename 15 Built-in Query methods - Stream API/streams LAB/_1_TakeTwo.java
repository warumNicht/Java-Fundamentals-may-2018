import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _1_TakeTwo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String>tockens=Arrays.asList(scanner.nextLine().split("\\s+"));

        List<Integer> numbers=new ArrayList<Integer>();
        for (String tocken : tockens) {
            numbers.add(Integer.valueOf(tocken));
        }

        numbers.stream()
                .filter(x->x>=10&&x<=20)
                .distinct()
                .limit(2)
                .forEach(x-> System.out.print(x+" "));
    }
}
