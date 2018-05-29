import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _4_SortStudents {
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
                .sorted((x,y)->{
                    int sort=x[1].compareTo(y[1]);
                    if(sort==0){
                        return y[0].compareTo(x[0]);
                    }
                    return sort;
                })
                .forEach(x-> System.out.println(x[0]+" "+x[1]));
    }
}
