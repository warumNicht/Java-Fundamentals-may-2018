import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _2_Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        ArrayDeque<ArrayDeque<Integer>> waves=new ArrayDeque<>();

        for (int i = 0; i <n ; i++) {
            List<Integer> curr= Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            ArrayDeque<Integer> curDek=new ArrayDeque<>(curr);

            waves.offer(curDek);
        }

        ArrayList<Integer> result=new ArrayList<>();

        while (waves.isEmpty()==false){

            ArrayDeque<Integer> curWave=waves.poll();

            if(curWave.size()==1){
                result.add(curWave.poll());
            }else {
                int curBegin=curWave.poll();

                while (curWave.isEmpty()==false&&curBegin>=curWave.peek()){

                    curWave.poll();
                }
                result.add(curBegin);
                if(curWave.isEmpty()==false){
                    waves.offer(curWave);
                }
            }
        }
        StringBuilder toPrint=new StringBuilder();

        for (Integer num : result) {

            toPrint.append(num).append(" ");
        }
        System.out.println(result.size());
        System.out.println(toPrint);
    }
}