import java.util.HashSet;
import java.util.Set;

public class normalTest {
    public static void main(String args[]) {
        Set<String> test = new HashSet<>();
        test.add("test1");
        test.add("test2");
        test.add("test3");
        System.out.println(String.join(",", test));
    }
}
