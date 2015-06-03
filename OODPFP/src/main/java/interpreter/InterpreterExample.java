package interpreter;

import java.util.HashMap;
import java.util.Map;

public class InterpreterExample {
    public static void main(String[] args) {
        Map<String, Expression> variables = new HashMap<>();
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));

        Evaluator sentence = new Evaluator("w x z - +");
        int result = sentence.interpret(variables);

        System.out.println(result);
    }
}
