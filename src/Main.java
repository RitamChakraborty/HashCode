import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

        int remaining = n;
        Set<Integer> delivered = new HashSet<>();

        for (int i = 0; i < t2; ++i) {
            if (remaining >= 2) { // Check if enough pizzas are there to deliver to a 2 members team
                int max = 0;
                Map<int[], Set<String>> order = new HashMap<>();

                for (int j = 0; j < n - 1; ++j) {
                    Set<String> ingredients = new HashSet<>(pizzas[j]);

                    for (int k = j + 1; k < n; ++k) {
                        ingredients.addAll(pizzas[k]);
                        order.put(new int[]{j, k}, ingredients);
                    }
                }

                order.forEach((ints, strings) -> System.out.println(Arrays.toString(ints) + " : " + strings));
            } else { // Otherwise cancel
                break;
            }
        }
    }
}
