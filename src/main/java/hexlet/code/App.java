package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
import java.io.File;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "version 1.0",
        description = "Compares two configuration files and shows a difference")
class GenDiff implements Callable<Integer> {

    @Override
    public Integer call()  { // your business logic goes here...
        return 0;
    }
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    String format ;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private File file1;

    @Parameters(index = "0", paramLabel = "filepath2", description = "path to second file")
    private File file2;

    /*@Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;*/

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
   // public static void main(String... args) {

    //}
}


public class App {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new GenDiff()).execute(args);
        System.exit(exitCode);
    }
}
