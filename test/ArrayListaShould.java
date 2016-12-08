import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by tdrs on 6/12/16.
 */
public class ArrayListaShould {
    private Lista<String> sLTest;
    private Lista<String> sLExpected;

    @Before
    public void setUp(){
        sLTest = new ArrayLista<>();
        sLExpected = new ArrayLista<>();
    }

    @Test
    public void add_elements_to_the_collection (){
        sLTest.add("hey");

        assertEquals(1, sLTest.size());
        assertEquals("hey", sLTest.get(0));
    }

    @Test
    public void retrieve_true_when_the_list_is_empty (){
        assertTrue(sLTest.isEmpty());

        sLTest.add("kh");
        assertTrue(!sLTest.isEmpty());
    }

    @Test
    public void retrieve_the_elements_not_erased (){
        sLTest.add("A");
        sLTest.add("B");
        sLTest.add("C");
        sLTest.remove("B");

        sLExpected.add("A");
        sLExpected.add("C");

        assertEquals(sLTest, sLExpected);
    }

    @Test
    public void retrieve_the_elements_not_erased_when_array_contains_more_than_one (){
        sLTest.add("A");
        sLTest.add("B");
        sLTest.add("C");
        sLTest.add("C");
        sLTest.remove("C");

        sLExpected.add("A");
        sLExpected.add("B");
        assertEquals(sLExpected, sLTest);
    }

    @Test
    public void retrieve_the_erased_element (){
        sLTest.add("A");
        sLTest.add("B");
        sLTest.add("JAVA");
        sLTest.add("C");
        sLTest.add("C");
        sLTest.add("C");

        sLExpected.add("A");
        sLExpected.add("B");
        sLExpected.add("C");
        sLExpected.add("C");
        sLExpected.add("C");

        assertEquals(sLTest.remove(2), "JAVA");
        assertEquals(sLExpected, sLTest);
    }

    @Test
    public void retrieve_null_when_given_invalid_positions (){
        sLTest.add("A");
        sLTest.add("B");
        sLTest.add("JAVA");
        sLTest.add("C");
        sLTest.add("C");
        sLTest.add("C");

        assertEquals(sLTest.subList(4,8), null);
        assertEquals(sLTest.subList(4,2), null);
        assertEquals(sLTest.subList(7,12), null);
    }

    @Test
    public void retrieve_the_correct_sublist_when_given_valid_indexs (){
        sLTest.add("A");
        sLTest.add("B");
        sLTest.add("JAVA");
        sLTest.add("C");
        sLTest.add("C");
        sLTest.add("C");

        sLExpected.add("B");
        sLExpected.add("JAVA");
        sLExpected.add("C");
        sLExpected.add("C");

        assertEquals(sLExpected, sLTest.subList(1,5));
    }

    @Test
    public void retrieve_true_when_setting_an_element_and_change_the_list (){
        sLTest.add("JAVA");
        sLTest.add("C");
        sLTest.add("C");
        sLTest.add("C");

        sLExpected.add("JAVA");
        sLExpected.add("C");
        sLExpected.add("C");
        sLExpected.add("C++");

        assertTrue(sLTest.set(3, "C++"));
        assertEquals(sLExpected, sLTest);
        assertTrue(!sLTest.set(4,""));
        assertEquals(sLExpected, sLTest);
        assertTrue(!sLTest.set(-1,""));
        assertEquals(sLExpected, sLTest);
    }

    @Test
    public void retrieve_the_correct_index_of_an_element (){
        sLTest.add("JAVA");
        sLTest.add("C++");
        sLTest.add("C");
        sLTest.add("Python");

        assertEquals(1,sLTest.indexOf("C++"));
        assertEquals(3,sLTest.indexOf("Python"));
        assertEquals(-1,sLTest.indexOf("Ada"));
    }

    @Test
    public void clear_a_list (){
        sLTest.add("JAVA");
        sLTest.add("C++");
        sLTest.add("C");
        sLTest.clear();

        assertEquals(sLExpected, sLTest);
    }

    @Test
    public void sort_a_list_given_a_comparator (){
        sLTest.add("JAVA");
        sLTest.add("C++");
        sLTest.add("JS");
        sLTest.sort(String::compareTo);

        sLExpected.add("C++");
        sLExpected.add("JAVA");
        sLExpected.add("JS");


        assertEquals(sLExpected, sLTest);
    }

    @Test
    public void sort_by_a_criteria_when_adding_elements (){
        /**
         * Comparator sort:
         *  If one of the elements have a '+' character, the criteria is sorting it by length
         *  If not, like String::compareTo
         */
        Lista<String> ls = new ArrayLista<>();
        ls.add("C++");
        ls.add("e+54");
        ls.add("Cdsv++");
        ls.add("Cdsv");
        ls.add("Ahello");
        ls.sort((t1, t2)->t1.length()-t2.length());


        sLExpected.add("C++");
        sLExpected.add("e+54");
        sLExpected.add("Cdsv");
        sLExpected.add("Cdsv++");
        sLExpected.add("Ahello");

        assertEquals(sLExpected,ls);
    }

    @Test
    public void sort_2 (){
        Lista<String> ls = new ArrayLista<>();
        ls.add("THOMAS");
        ls.add("Aser");
        ls.add("Abel");
        ls.sort(String::compareTo);

        sLExpected.add("Abel");
        sLExpected.add("Aser");
        sLExpected.add("THOMAS");
        assertEquals(sLExpected, ls);
    }
}
