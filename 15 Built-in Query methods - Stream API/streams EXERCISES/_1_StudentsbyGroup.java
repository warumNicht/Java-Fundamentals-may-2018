import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1_StudentsbyGroup {

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
                .filter(x->"2".equals(x[x.length-1]))
                .sorted((x,y)->x[0].compareTo(y[0]))
                .forEach(x->{
                    System.out.println(x[0]+" "+x[1]);
                });
    }
}
