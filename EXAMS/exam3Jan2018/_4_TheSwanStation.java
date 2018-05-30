import java.util.*;
import java.util.stream.Collectors;

public class _4_TheSwanStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> number=Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> sec=Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> numbers=new ArrayDeque<>(number);
        ArrayDeque<Integer> seq=new ArrayDeque<>(sec);

        List<String> result=new ArrayList<>();

        while (result.size()<6){

            int curNum=seq.poll();
            if(curNum%numbers.peek()==0){
                result.add(""+curNum);
                numbers.poll();
            }else {
                seq.offer(curNum+1);
            }
        }
        System.out.println(String.join(", ",result));
    }
}
