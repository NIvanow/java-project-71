package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "version 1.0",
        description = "Compares two configuration files and shows a difference")
class GenDiff implements Callable<Integer> {

    @Override
    public Integer call()  { // your business logic goes here...
        return 0;
    }

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
