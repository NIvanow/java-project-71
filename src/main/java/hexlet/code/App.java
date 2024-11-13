package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.io.File;
@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "version 1.0",
        description = "Compares two configuration files and shows a difference")
class GenDiff implements Callable<Integer> {

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    String format ;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private File file1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private File file2;

    /*@Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;*/

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
   // public static void main(String... args) {

    //}
    @Override
    public Integer call() throws Exception {
        String way = "/home/nivanov/java-project-71/app/src/main/java/hexlet/files/";
        ObjectMapper mapper = new ObjectMapper();

        String readPath1 = way + Paths.get(file1.getPath());
        String readPath2 = way + Paths.get(file2.getPath());
        Path path1 = Paths.get(readPath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(readPath2).toAbsolutePath().normalize();

        Map readFile1 = mapper.readValue(path1.toFile(),Map.class);
        System.out.println(readFile1);
        Map readFile2 = mapper.readValue(path2.toFile(),Map.class);
        System.out.println(readFile2);
        return 0;
    }
}

public class App {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new GenDiff()).execute(args);
        System.exit(exitCode);
    }
}

