package lesson11.labs.prob5;

import java.util.Arrays;
import java.util.List;

public class SecondSmallClass {

    public static <T extends Comparable<? super T>> T secondSmall(List<T> list) {
        T min, secondSmall;
        if(list.size() == 0 || list.size() == 1)
            return null;
        if(list.get(0).compareTo(list.get(1)) <= 0) {
            min = list.get(0);
            secondSmall = list.get(1);
        } else {
            min = list.get(1);
            secondSmall = list.get(0);
        }

        for(int j = 2; j<list.size(); j++) {
            T i = list.get(j);
            if(i.compareTo(min) < 0)
                min = i;
            else if (i.compareTo(secondSmall) < 0)
                secondSmall = i;
        }
        return secondSmall;
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(67, 6, 7, 8);
        System.out.println(SecondSmallClass.secondSmall(ints));

        List<Double> doubles = Arrays.asList(2.78, 3.14, 7.24, 8.91);
        System.out.println(SecondSmallClass.secondSmall(doubles));

    }

}
