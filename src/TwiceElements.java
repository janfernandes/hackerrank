import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result5 {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> mp = new HashMap<>();

        for (Integer element : a) {
            if (mp.containsKey(element)) {
                mp.put(element, mp.get(element) + 1);
            } else {
                mp.put(element, 1);
            }
        }
        return mp.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), 1))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet()).stream().findAny().get();
    }

}

public class TwiceElements {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println(Result5.lonelyinteger(a));
        bufferedReader.close();
    }
}
