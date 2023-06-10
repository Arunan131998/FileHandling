import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FilesRunner {
  public static void main(String[] args) throws IOException {
	//Files.list(Paths.get(".")).forEach(System.out::println);
	//Files.walk(Paths.get("."),4).forEach(System.out::println);
	  
	  // filtering the paths displayed.
//	  Predicate<? super Path> predicate = (path)-> String.valueOf(path).contains(".java");
//	  Files.walk(Paths.get("."),4).filter(predicate).forEach(System.out::println);
	  BiPredicate<Path, BasicFileAttributes> JavaFileMatcher= (path,attributes)->String.valueOf(path).contains(".java");

	  BiPredicate<Path, BasicFileAttributes> directoryMatcher= (path,attributes)-> attributes.isDirectory();
	Files.find(Paths.get("."), 4, directoryMatcher).forEach(System.out::println);
	System.out.println("list with path containing java files");
	Files.find(Paths.get("."), 4, JavaFileMatcher).forEach(System.out::println);
	
//	Reading from a File
	Path pathToReadFrom = Paths.get("./resources/ReadFile.txt");
	List<String> list = Files.readAllLines(pathToReadFrom);
	System.out.println(list);
	Files.lines(pathToReadFrom).forEach(str-> System.out.println(str));
	
	// writing to file
	Path pathToWrite = Paths.get("./resources/WriteToFile.txt");
	List<String> alist = List.of("This","is","Java","Programming");
	Files.write(pathToWrite,alist);
}
}