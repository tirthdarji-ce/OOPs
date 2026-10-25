
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.io.*;
import java.util.Scanner;

public class FolderReport {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter folder path: ");
        Path folder = Path.of(sc.nextLine());

        if (!Files.isDirectory(folder)) {
            System.out.println("Folder not found.");
            sc.close();
            return;
        }

        Path report = Path.of("FolderReport.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(report);
             var files = Files.walk(folder)) {

            for (Path file : (Iterable<Path>) files
                    .filter(Files::isRegularFile)::iterator) {

                long size = Files.size(file);
                FileTime modified = Files.getLastModifiedTime(file);

                String details = file.getFileName()
                        + " | " + size + " bytes"
                        + " | Modified: " + modified;

                System.out.println(details);
                writer.write(details);
                writer.newLine();
            }

            System.out.println("Report saved to: " + report.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
