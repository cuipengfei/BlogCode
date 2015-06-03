package interpreter;

import java.util.Map;

interface Expression {
    int interpret(Map<String, Expression> variables);
}

