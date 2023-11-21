import java.io.*;
import java.util.*;


public class Task1 {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        File dir = new File("./files/");

        try (FileReader file = new FileReader(new File(dir, in.nextLine()));
             BufferedReader buffer = new BufferedReader(file)) {
            Set<String> words = new HashSet<>();
            String string = buffer.readLine();
            while (string != null) {
                string = string.replaceAll("\\p{Punct}", "");
                string = string.toLowerCase();
                String[] string_words = string.split(" ");
                words.addAll(Arrays.asList(string_words));
                string = buffer.readLine();
            }

            String[] words_array = words.toArray(new String[0]);
            for (Object word : Arrays.stream(words_array).sorted().toArray()) {
                System.out.println(word);
            }
        }
    }
}
