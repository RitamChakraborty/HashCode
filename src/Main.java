import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "a_example";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int n;
        int team2;
        int team3;
        int team4;
        List<List<String>> pizzas = new ArrayList<>();

        n = scanner.nextInt();
        team2 = scanner.nextInt();
        team3 = scanner.nextInt();
        team4 = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            int count = scanner.nextInt();
            List<String> ingredients = new ArrayList<>();

            for (int j = 0; j < count; ++j) {
                ingredients.add(scanner.next());
            }

            pizzas.add(ingredients);
        }
    }
}
