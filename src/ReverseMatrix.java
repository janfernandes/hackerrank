import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int sum = 0;
        int n = matrix.size(), m = matrix.get(0).size();
        int cur, right, down, diag, ans;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                cur = matrix.get(i).get(j);
                right = matrix.get(i).get(m - j - 1);
                down = matrix.get(n - i - 1).get(j);
                diag = matrix.get(n - i - 1).get(m - j - 1);
                ans = Math.max(Math.max(cur, right), Math.max(down, diag));
                sum += ans;
            }
        }
        return sum;
    }

}

public class ReverseMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                System.out.println(Result.flippingMatrix(matrix));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
