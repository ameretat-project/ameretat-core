package tech.amereta.core.service.generator.spring.code.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tech.amereta.core.service.writer.java.declaration.JavaFieldDeclaration;
import tech.amereta.core.service.writer.java.declaration.JavaMethodDeclaration;
import tech.amereta.core.service.writer.java.source.JavaTypeDeclaration;
import tech.amereta.core.service.writer.java.util.JavaAnnotation;
import tech.amereta.core.service.writer.java.util.JavaModifier;
import tech.amereta.core.domain.description.java.JavaTypeDescription;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class SpringTypeGenerator {

    protected JavaTypeDescription type;

    abstract public List<JavaAnnotation> generateAnnotations();

    abstract public List<JavaFieldDeclaration> generateFields();

    abstract public List<JavaMethodDeclaration> generateMethods();

    abstract public JavaTypeDeclaration generateTypeDeclaration();

    protected JavaModifier generateModifiers(List<String> modifiers) {
        return JavaModifier.builder()
                .type(JavaModifier.TYPE_MODIFIERS)
                .modifiers(modifiers.stream()
                        .map(this::decodeModifier)
                        .reduce(0, (a, b) -> a | b))
                .build();
    }

    private int decodeModifier(String modifier) {
        return switch (modifier) {
            case "public" -> 0x00000001;
            case "private" -> 0x00000002;
            default -> 0;
        };
    }

}