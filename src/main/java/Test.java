import april.Utils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        String memUsage = "25G,29G";
        String[] mem = memUsage.replaceAll("G", "").split(",");
        Double free = Double.parseDouble(mem[0]);
        Double total = Double.parseDouble(mem[1]);
        Double used = total - free;
        System.out.println(used/total);


    }

    public static String ogurec(Optional<String> os){
        String add = true ? "asdada" : "";
        return os
                .map(Utils::addSlovo)
                .map(Utils::addTest)
                .orElseGet(() -> {
                    return "----";
                }) + add;
    }



    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }map.put(nums[i], i);
        }
        return null;
    }

    public static int[] findErrorNums(int[] nums) {
        int[] mask = new int[nums.length];
        int[] errors = new int[nums.length]; //System.arraycopy(numArray, 0, smallerArray, 0, somesize / 2);
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (mask[nums[i]-1] == nums[i]) {
                errors[idx++] = nums[i];
            } else {
                mask[nums[i]-1] = nums[i];
            }
        }
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 0) {
                errors[idx++]=i+1;
            } else {
                mask[nums[i]-1] = nums[i];
            }
        }

        int[] result = new int[idx];
        System.arraycopy(errors, 0, result, 0, idx);

        return result;
    }
    public static int romanToInt(String s) {
        int sum = 0;
        int l = s.length();
        for(int i=0; i < l; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i+1 < l && s.charAt(i+1) == 'V') {
                        sum+=4;
                        i++;
                    } else if (i+1 < l && s.charAt(i+1) == 'X') {
                        sum+=9;
                        i++;
                    } else {
                        sum+=1;
                    }
                    break;
                case 'V':
                    sum+=5;
                    break;
                case 'X':
                    if (i+1 < l && s.charAt(i+1) == 'C') {
                        sum+=90;
                        i++;
                    } else if (i+1 < l && s.charAt(i+1) == 'L') {
                        sum+=40;
                        i++;
                    } else {
                        sum+=10;
                    }
                    break;
                case 'L':
                    sum+=50;
                    break;
                case 'C':
                    if (i+1 < l && s.charAt(i+1) == 'M') {
                        sum+=900;
                        i++;
                    } else if (i+1 < l && s.charAt(i+1) == 'D') {
                        sum+=400;
                        i++;
                    } else {
                        sum+=100;
                    }
                    break;
                case 'D':
                    sum+=500;
                    break;
                case 'M':
                    sum+=1000;
                    break;
                default: break;
            }
        }
        return sum;
    }

    public String getSubj() {
        String subj = "null";
        Mail mail = new Mail();
        return Optional.ofNullable(subj).orElse("ns");
    }

    public static String getSubj2() {
        return null;
    }

    class Mail {
        String subject;

        public Mail() {
        }

        String getSubject() {
            return this.subject;
        }


    }
}
