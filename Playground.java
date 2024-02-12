import java.util.LinkedList;
import java.util.stream.Collectors;

public class Playground {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 58912897219L;

    /*
     * A function to interactively try your nesting checker. Feel free to modify for your own purposes.
     * "jshell" is an easy way to use this. From a command line in the directory with your java files, run:
     *    jshell Nestable.java NestingReport.java NestableCharacter.java NestingChecker.java Playground.java
     * On the jshell command line, run:
     *    Playground.interact();
     */
    public static void interact() {
        var in = new java.util.Scanner(System.in);
        System.out.println("Nesting reports will be printed for each line of text you enter." +
                "\nEnter a line with only \"exit\" to stop (Ctrl-D will not work inside jshell)");
        System.out.println("Warning, this tool is here to assist working with the behavior of your code " +
                "interactively and is an example of just one of many ways to create queues of nestable objects. " +
                "It is not intended to be used for writing unit tests.");

        String line;
        while (true) {
            System.out.print("check> ");
            System.out.flush();

            if (!in.hasNextLine())
                break;
            line = in.nextLine();

            if (line.equals(""))
                continue;
            else if (line.equals("exit"))
                break;

            var characters = line.chars()
                    .mapToObj(NestableCharacter::new)
                    .collect(Collectors.toCollection(LinkedList<NestableCharacter>::new));;
            NestingReport result = NestingChecker.checkNesting(characters);
            System.out.println(result + "\n");
        }

        System.out.println("Thank you for using the interactive nesting checker. Have a nice day.");
        in.close();
    }

    /*
     * This just runs interact() by default. Here you can also press Ctrl-D to exit.
     */
    public static void main(String[] args) {
        interact();
    }
}
