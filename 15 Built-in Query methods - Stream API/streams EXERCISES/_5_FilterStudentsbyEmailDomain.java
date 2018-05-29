import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5_FilterStudentsbyEmailDomain {
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
                .filter(x->x[2].endsWith("@gmail.com"))
                .forEach(s-> System.out.println(s[0]+" "+s[1]));

    }
}
