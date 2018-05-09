import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: Paul Keller
 * date: 09.05.2018
 * version: 1.0
 */
public class Greycode {
    public static void main(String[] args) {
        System.out.println(getGreyCode(Integer.parseInt(args[0])));

    }

    public static String getGreyCode(int number){
        List<String> l1 = new ArrayList<>();

        l1.add("0");
        l1.add("1");
        for(int i=1;i<number;i++) {
            List<String> l2 = (List<String>) ((ArrayList<String>) l1).clone();
            Collections.reverse(l2);
            l1=l1.stream().map(x->"0"+x).collect(Collectors.toList());
            l2=l2.stream().map(x->"1"+x).collect(Collectors.toList());
            l1.addAll(l2);
        }
        return l1.stream().collect(Collectors.joining("\n"));
    }
}
