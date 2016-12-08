import java.util.ArrayList;
import java.util.List;

public class UseContainers {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(-4);
        list.add(1);
        list.add(0);
        list.sort((i1,i2)->i1-i2);

        for(Integer i:list) System.out.println(i+" , ");
    }

}
