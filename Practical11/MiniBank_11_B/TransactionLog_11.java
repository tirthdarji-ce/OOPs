import java.nio.file.*;
public class TransactionLog_11 {
    public static void append(Path file,String line)throws Exception{Files.createDirectories(file.getParent());Files.writeString(file,line+System.lineSeparator(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);}
}
