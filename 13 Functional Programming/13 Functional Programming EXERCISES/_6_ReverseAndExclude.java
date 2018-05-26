import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _6_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements=Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n=Integer.parseInt(scanner.nextLine());

        Consumer<List<Integer>> reverse=list->{
            for (int i = list.size()-1; i >=0 ; i--) {
                System.out.print(list.get(i)+" ");
            }
        };
        elements.removeIf(m->m%n==0);

        reverse.accept(elements);
    }
}
