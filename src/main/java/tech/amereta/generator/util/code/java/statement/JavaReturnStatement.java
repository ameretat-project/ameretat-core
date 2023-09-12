package tech.amereta.generator.util.code.java.statement;

import lombok.Builder;
import tech.amereta.generator.util.code.Expression;
import tech.amereta.generator.util.code.Statement;

import java.util.Set;

/**
 * A return statement.
 */
public record JavaReturnStatement(Expression expression) implements Statement {

    @Builder
    public JavaReturnStatement {
    }

    @Override
    public String render() {
        return "return " + expression.render() + ";";
    }

    @Override
    public Set<String> imports() {
        return this.expression.imports();
    }

}
