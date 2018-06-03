import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums=Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<31; i++){

            int onesCount=0;
            for (int k = 0; k <nums.length ; k++) {

                int first=nums[k];
                int firstBit=first>>i&1;
                if(firstBit==1){
                    onesCount++;
                }
            }
            for (int d = 0; d <nums.length-onesCount ; d++) {
                int sec=nums[d];
                int secBit=sec>>i&1;
                if(secBit==1){
                    nums[d]=nums[d]^(1<<i);
                }
            }
            for (int f = nums.length-onesCount; f <nums.length ; f++) {

                int th=nums[f];
                int thBit=th>>i&1;
                if(thBit==0){
                    nums[f]=nums[f]|(1<<i);
                }
            }
        }
        List<String> result=new ArrayList<>();
        for (int num : nums) {
            result.add(""+num);
        }
        System.out.println(String.join(", ",result));
    }
}