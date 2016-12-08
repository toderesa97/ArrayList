import java.util.ArrayList;
import java.util.List;

public class UseContainers {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("C++");
        ls.add("e+54");
        ls.add("Cdsv++");
        ls.add("Cdsv");
        ls.add("Ahello");
        ls.sort((t1, t2)->t1.length()-t2.length());

        for(String i:ls) System.out.println(i+", ");
    }

}
