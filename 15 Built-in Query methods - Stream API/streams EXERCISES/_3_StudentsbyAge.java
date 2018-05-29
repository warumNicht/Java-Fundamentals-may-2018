import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3_StudentsbyAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String[]> names=new ArrayList<String[]>();

        String input=scanner.nextLine();

        while ("END".equals(input)==false){
            String[] curr=input.split("\\s+");
            names.add(curr);

            input=scanner.nextLine();
        }

        names.stream()
                .filter(x->Integer.parseInt(x[2])>=18&&Integer.parseInt(x[2])<=24)
                .forEach(n-> System.out.println(String.join(" ",n)));
    }
}
