import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int solve(String a, String b) {
        BigInteger first=new BigInteger(a);
        BigInteger second=new BigInteger(b);
        
        
        BigInteger mod=new BigInteger("10").pow(9).add(new BigInteger("7"));  
        BigInteger po=first.modPow(second,mod);
        return po.intValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ab = scanner.nextLine().split(" ");

            String a = ab[0];

            String b = ab[1];

            int result = solve(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
