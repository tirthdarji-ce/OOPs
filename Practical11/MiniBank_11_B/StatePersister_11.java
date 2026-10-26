import java.io.*; import java.nio.file.*;
public class StatePersister_11 {
    public static void save(Account_11[] a,Path file)throws IOException{Files.createDirectories(file.getParent());try(ObjectOutputStream o=new ObjectOutputStream(Files.newOutputStream(file))){o.writeObject(a);}}
    public static Account_11[] load(Path file)throws Exception{try(ObjectInputStream i=new ObjectInputStream(Files.newInputStream(file))){return (Account_11[])i.readObject();}}
}
