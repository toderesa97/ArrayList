import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UseContainers {

    public static void main(String[] args) {
        Lista<String> expected = new ArrayLista<>();
        expected.add("Hey");
        expected.add("makey");
        expected.add("How");
        expected.add("are");
        expected.add("you?");

        Lista<String> ls = expected.filter(string->string.contains("y"));

        for (int i = 0; i < ls.size(); i++) {
            System.out.print(ls.get(i)+",");
        }

    }

}
