import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        String file1 = "a_example";
        String file2 = "b_little_bit_of_everything.in";
        String file3 = "c_many_ingredients.in";
        String file4 = "d_many_pizzas.in";
        String file5 = "e_many_teams.in";

        Scanner scanner = new Scanner(new BufferedReader(new FileReader(file1)));
        int n;
        int t2;
        int t3;
        int t4;

        n = scanner.nextInt();
        t2 = scanner.nextInt();
        t3 = scanner.nextInt();
        t4 = scanner.nextInt();

        var pizzas = new HashSet[n];

        for (int i = 0; i < n; ++i) {
            int count = scanner.nextInt();
            pizzas[i] = new HashSet<String>();

            for (int j = 0; j < count; ++j) {
                pizzas[i].add(scanner.next());
            }
        }

        int remaining = n;
        List<Order> orders = new ArrayList<>();
        Set<Integer> delivered = new HashSet<>();

        // Team with 2 members
        for (int i = 0; i < t2; ++i) {
            if (remaining >= 2) { // Check if enough pizzas are there to deliver to a 2 members team
                int max = 0;
                Map<int[], Set<String>> singleOrder = new HashMap<>();

                for (int j = 0; j < n - 1; ++j) {
                    if (!delivered.contains(j)) { // Not delivered yet
                        Set<String> ingredients = new HashSet<>();

                        for (int k = j + 1; k < n; ++k) {
                            if (!delivered.contains(k)) { // Not delivered yet
                                // Clear the previous ingredients present there
                                ingredients.clear();
                                // Combine two types of pizzas
                                ingredients.addAll(pizzas[j]);
                                ingredients.addAll(pizzas[k]);

                                if (ingredients.size() > max) { // Check if this type of singleOrder contains most number of ingredients
                                    // Set the max size if so
                                    max = ingredients.size();
                                    // Clear the singleOrder object to ensure single entry
                                    singleOrder.clear();
                                    // Add new entry with a new HashSet to avoid object reference
                                    singleOrder.put(new int[]{j, k}, new HashSet<>(ingredients));
                                }
                            }
                        }
                    }
                }

                // Add singleOrder data
                singleOrder.forEach((ints, strings) -> {
                    // Add pizzas indices to delivered set
                    for (int anInt : ints) {
                        delivered.add(anInt);
                    }

                    // Add delivered pizzas indices
                    orders.add(new Order(2, ints));
                });

                // Reduce remaining
                remaining -= 2;
            } else { // Otherwise cancel
                break;
            }
        }

        // Team with 3 members
        for (int i = 0; i < t3; ++i) {
            if (remaining >= 3) { // Check if enough pizzas are there to deliver to a 2 members team
                int max = 0;
                Map<int[], Set<String>> order = new HashMap<>();

                for (int j = 0; j < n - 2; ++j) {
                    if (!delivered.contains(j)) { // Not delivered yet
                        Set<String> ingredients = new HashSet<>();

                        for (int k = j + 1; k < n - 1; ++k) {
                            if (!delivered.contains(k)) { // Not delivered yet
                                for (int l = k + 1; k < n; ++k) {
                                    if (!delivered.contains(l)) { // Not delivered yet
                                        // Clear the previous ingredients present there
                                        ingredients.clear();
                                        // Combine three types of pizzas
                                        ingredients.addAll(pizzas[j]);
                                        ingredients.addAll(pizzas[k]);
                                        ingredients.addAll(pizzas[l]);

                                        if (ingredients.size() > max) { // Check if this type of order contains most number of ingredients
                                            // Set the max size if so
                                            max = ingredients.size();
                                            // Clear the order object to ensure single entry
                                            order.clear();
                                            // Add new entry with a new HashSet to avoid object reference
                                            order.put(new int[]{j, k, l}, new HashSet<>(ingredients));
                                        }
                                    }
                                }
                            }
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
                    orders.add(new Order(3, ints));
                });

                // Reduce remaining
                remaining -= 3;
            } else { // Otherwise cancel
                break;
            }
        }

        // Team with 4 members
        for (int i = 0; i < t4; ++i) {
            if (remaining >= 4) { // Check if enough pizzas are there to deliver to a 2 members team
                int max = 0;
                Map<int[], Set<String>> order = new HashMap<>();

                for (int j = 0; j < n - 3; ++j) {
                    if (!delivered.contains(j)) { // Not delivered yet
                        Set<String> ingredients = new HashSet<>();

                        for (int k = j + 1; k < n - 2; ++k) {
                            if (!delivered.contains(k)) { // Not delivered yet
                                for (int l = k + 1; k < n - 1; ++k) {
                                    if (!delivered.contains(l)) { // Not delivered yet
                                        for (int m = l + 1; m < n; ++m) {
                                            if (!delivered.contains(m)) { // Not delivered yet
                                                // Clear the previous ingredients present there
                                                ingredients.clear();
                                                // Combine four types of pizzas
                                                ingredients.addAll(pizzas[j]);
                                                ingredients.addAll(pizzas[k]);
                                                ingredients.addAll(pizzas[l]);
                                                ingredients.addAll(pizzas[m]);

                                                if (ingredients.size() > max) { // Check if this type of order contains most number of ingredients
                                                    // Set the max size if so
                                                    max = ingredients.size();
                                                    // Clear the order object to ensure single entry
                                                    order.clear();
                                                    // Add new entry with a new HashSet to avoid object reference
                                                    order.put(new int[]{j, k, l, m}, new HashSet<>(ingredients));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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
                    orders.add(new Order(4, ints));
                });

                // Reduce remaining
                remaining -= 4;
            } else { // Otherwise cancel
                break;
            }
        }

        System.out.println(orders.size());
        orders.forEach(System.out::println);
    }

    private static class Order {
        int teamMembers;
        int[] pizzaIndices;

        public Order(int teamMembers, int[] pizzaIndices) {
            this.teamMembers = teamMembers;
            this.pizzaIndices = pizzaIndices;
        }

        @Override
        public String toString() {
            StringJoiner stringJoiner = new StringJoiner(" ");

            for (int pizzaIndex : pizzaIndices) {
                stringJoiner.add(String.valueOf(pizzaIndex));
            }

            return teamMembers + " " + stringJoiner.toString();
        }
    }
}
