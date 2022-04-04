import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> array) {
        // Write your code here
        List<Integer> positive = array.stream().filter(a -> a > 0).collect(toList());
        List<Integer> negative = array.stream().filter(a -> a < 0).collect(toList());
        double i = positive.size() / (double) array.size();
        double i1 = negative.size() / (double) array.size();
        DecimalFormat formatter = new DecimalFormat("#0.000000");
        System.out.println(formatter.format(i));
        System.out.println(formatter.format(i1));
        System.out.println(formatter.format(1 - i - i1));
    }

}

public class Ratios {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result1.plusMinus(arr);
        bufferedReader.close();
    }
}
