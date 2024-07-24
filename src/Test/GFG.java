package Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GFG {
        public static void main (String[] args) {
            String str = "This This is is done by robort robort robort";
            Map<String,Long> map = Arrays.stream(str.split(" "))
                    .collect(Collectors.groupingBy(x->x,Collectors.counting()));
            System.out.println(map);
        }
}
