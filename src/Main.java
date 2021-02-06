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
        Set<int[]> orders = new HashSet<>();
        Set<Integer> delivered = new HashSet<>();

        for (int i = 0; i < t2; ++i) {
            if (remaining >= 2) { // Check if enough pizzas are there to deliver to a 2 members team
                int max = 0;
                Map<int[], Set<String>> order = new HashMap<>();

                for (int j = 0; j < n - 1; ++j) {
                    Set<String> ingredients = new HashSet<>();

                    for (int k = j + 1; k < n; ++k) {
                        // Clear the previous ingredients present there
                        ingredients.clear();
                        // Combine two types of pizzas
                        ingredients.addAll(pizzas[j]);
                        ingredients.addAll(pizzas[k]);

                        if (ingredients.size() > max) { // Check if this type of order contains most number of ingredients
                            // Set the max size if so
                            max = ingredients.size();
                            // Clear the order object to ensure single entry
                            order.clear();
                            // Add new entry with a new HashSet to avoid object reference
                            order.put(new int[]{j, k}, new HashSet<>(ingredients));
                        }
                    }
                }

                // Add order data
                order.forEach((ints, strings) -> {
                    // Add pizzas indices to delivered set
                    for (int anInt : ints) {
                        delivered.add(anInt);
                    }

                    // Add delivered pizzas indices
                    orders.add(ints);
                });

                // Reduce remaining
                remaining -= 2;
            } else { // Otherwise cancel
                break;
            }
        }

        orders.forEach(order -> System.out.println(Arrays.toString(order)));
    }
}
