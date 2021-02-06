import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "a_example";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int n;
        int t2;
        int t3;
        int t4;

        n = scanner.nextInt();
        t2 = scanner.nextInt();
        t3 = scanner.nextInt();
        t4 = scanner.nextInt();

        HashSet[] pizzas = new HashSet[n];


        for (int i = 0; i < n; ++i) {
            int count = scanner.nextInt();
            pizzas[i] = new HashSet<String>();

            for (int j = 0; j < count; ++j) {
                pizzas[i].add(scanner.next());
            }
        }
    }
}
