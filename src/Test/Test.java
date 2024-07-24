package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {
    public static void main(String [] args){
        Employee employee = new Employee();
        employee.empId = 20;
        Employee obj = new Employee();
        System.out.println(obj.empId);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Function<Integer,String> s = (x) -> {
            for(int i=0;i<x;i++){
                System.out.println(i*10);
            }
            return "";
        };
        System.out.println(s.apply(4));
        Function<List<Integer>,Integer> maxx = Collections::max;
        System.out.println(maxx.apply(list));
        System.out.println(Collections.binarySearch(list,5));
    }
}
