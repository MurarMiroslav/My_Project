package mm.behavioral.command;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final JavaFile javaFile = new JavaFile("Commands.java", "Commands",
                List.of("Command {", " ", "private String content;", "}"));
        final Command changeFileNameCommand = new ChangeFileNameCommand(javaFile, "UpdatedCommands.java");
        final Command removeEmptyLinesCommand = new RemoveEmptyLinesCommand(javaFile);

        System.out.println(javaFile);

        changeFileNameCommand.apply();
        System.out.println("==========================================================================");
        System.out.println(javaFile);

        System.out.println("==========================================================================");
        removeEmptyLinesCommand.apply();
        System.out.println(javaFile);

        System.out.println("==========================================================================");
        changeFileNameCommand.cancel();
        System.out.println(javaFile);
    }

}

