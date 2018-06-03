import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _2_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> number=Arrays
                .stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> stones=new ArrayDeque<>(number);
        ArrayDeque<Integer> gold=new ArrayDeque<>();

        while (true){
            String input=reader.readLine();
            if("Revision".equals(input)){
                break;
            }

            String[] tokens=input.split("\\s+");

            if("acid".equals(tokens[1])){

                if(stones.isEmpty()==false){
                    int doses=Integer.parseInt(tokens[2]);
                    while (stones.isEmpty()==false&&doses>0){

                        int curStone=stones.poll();
                        if(curStone==1){
                            gold.push(curStone);
                        }else {
                            stones.offer(curStone-1);
                        }
                        doses--;
                    }
                }
            }else{
                if(gold.isEmpty()==false){
                    gold.pop();
                    int returned=Integer.parseInt(tokens[2]);
                    stones.offer(returned);
                }
            }
        }
        while (stones.isEmpty()==false){
            System.out.print(stones.poll()+" ");
        }
        System.out.println();
        System.out.println(gold.size());
    }
}