import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1_SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> edelWeisse=new ArrayDeque<>();
        Stack<Integer> buckets=new Stack<>();

        String[] flowtok=reader.readLine().split("\\s+");
        for (String s : flowtok) {
            edelWeisse.offer(Integer.parseInt(s));
        }
        String[] kofitok=reader.readLine().split("\\s+");

        for (String s : kofitok) {
            buckets.push(Integer.parseInt(s));
        }

        List<Integer> immerBluehende=new ArrayList<>();

        while (edelWeisse.isEmpty()==false&&buckets.isEmpty()==false){

            int currBucket=buckets.pop();
            int curFlower=edelWeisse.poll();

            if(curFlower==currBucket){
                immerBluehende.add(curFlower);
            }else if(curFlower>currBucket){

                curFlower-=currBucket;
                edelWeisse.addFirst(curFlower);
            }else {
                int toremove=currBucket-curFlower;
                if(buckets.isEmpty()==false){
                    buckets.push(buckets.pop()+toremove);
                }else {
                    buckets.push(toremove);
                }
            }
        }

        if(edelWeisse.isEmpty()){
            while (buckets.isEmpty()==false){
                System.out.print(buckets.pop()+" ");
            }
            System.out.println();
        }else {
            while (edelWeisse.isEmpty()==false){
                System.out.print(edelWeisse.poll()+" ");
            }
            System.out.println();
        }

        if(immerBluehende.isEmpty()){
            System.out.println("None");
        }else {
            for (Integer n : immerBluehende) {
                System.out.print(n+" ");
            }
        }
    }
}