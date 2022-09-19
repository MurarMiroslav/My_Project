package mm.behavioral.interpreter;

public class Main {

    private static final String arg0 = "2 + 3 * 2";
    private static final String arg1 = "3 ADD 3 EXPONENTIATION 2";

    public static void main(String[] args) {
        final MathOperationApplier mathOperationApplier = new MathOperationApplier();
        Interpreter interpreter = new PythonStyleWithoutOrderMathOperationsInterpreter(mathOperationApplier);

        String result = interpreter.interpret(arg0);
        System.out.println(result);

        interpreter = new WordsWithoutOrderMathOperationsInterpreter(mathOperationApplier);
        result = interpreter.interpret(arg1);
        System.out.println(result);
    }
}
