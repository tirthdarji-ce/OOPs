
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Keyword: ");
        String key = sc.nextLine().toLowerCase();

        Path folder = Path.of("logs");
        Files.createDirectories(folder);

        // Create two text files
        Files.writeString(folder.resolve("one.txt"),
                "hello world\njava bank\nhello java\n");

        Files.writeString(folder.resolve("two.txt"),
                "bank test\nhello again\n");

        int total = 0;
        int matches = 0;

        // Read all text files in the folder
        try (DirectoryStream<Path> ds =
                     Files.newDirectoryStream(folder, "*.txt")) {

            for (Path p : ds) {
                int lines = 0;

                try (BufferedReader r = Files.newBufferedReader(p)) {
                    String line;

                    while ((line = r.readLine()) != null) {
                        lines++;
                        total++;

                        if (line.toLowerCase().contains(key)) {
                            matches++;
                        }
                    }
                }

                System.out.println(
                        p.getFileName()
                        + " size= " + Files.size(p)
                        + " lines= " + lines

                );
            }
        }

        System.out.println("Total lines: " + total);
        System.out.println("Matches: " + matches);

        sc.close();
    }
}
