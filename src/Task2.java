import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        if (args.length != 4 || !args[0].equals("tail") || !args[1].equals("-n")) {
            System.err.println("Usage: java Tail tail -n <number-of-lines> <filename>");
            System.exit(1);
        }

        int numLines = Integer.parseInt(args[2]);

        try (RandomAccessFile reader = new RandomAccessFile(args[3], "r")) {
            List<String> buffer = new LinkedList<String>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (buffer.size() == numLines)
                    buffer.remove(0);
                buffer.add(line);
            }

            for (Object outputLine : buffer.toArray())
                System.out.println(outputLine);

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(2);
        }
    }
}