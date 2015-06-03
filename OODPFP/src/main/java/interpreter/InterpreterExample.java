package interpreter;

import java.util.HashMap;
import java.util.Map;

public class InterpreterExample {
    public static void main(String[] args) {
        Map<String, Expression> context = new HashMap<>();
        context.put("w", new Number(5));
        context.put("x", new Number(10));
        context.put("z", new Number(42));

        Plus expr = new Plus(new Variable("w"),
                new Minus(new Variable("x"),
                        new Variable("z")));

        System.out.println(expr.interpret(context));
    }
}
