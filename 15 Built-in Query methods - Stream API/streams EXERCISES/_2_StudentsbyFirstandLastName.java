import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2_StudentsbyFirstandLastName {
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
                .filter(x-> x[0].compareTo(x[1])<0)
                .forEach(name->{
                    System.out.println(name[0]+" "+name[1]);
                });
    }
}
