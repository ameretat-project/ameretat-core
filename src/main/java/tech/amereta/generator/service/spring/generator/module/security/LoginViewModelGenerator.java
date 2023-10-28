package tech.amereta.generator.service.spring.generator.module.security;

import tech.amereta.core.java.JavaCompilationUnit;
import tech.amereta.core.java.JavaTypeDeclaration;
import tech.amereta.core.java.declaration.JavaFieldDeclaration;
import tech.amereta.core.java.util.JavaAnnotation;
import tech.amereta.core.java.util.JavaModifier;
import tech.amereta.core.java.util.JavaType;
import tech.amereta.generator.service.spring.AbstractSpringSourceCodeGenerator;
import tech.amereta.lang.description.spring.SpringBootApplicationDescription;

import java.lang.reflect.Modifier;
import java.util.List;

public final class LoginViewModelGenerator extends AbstractSpringSourceCodeGenerator {

    private static final String CLASS_NAME = "LoginVM";

    public static JavaCompilationUnit generate(final SpringBootApplicationDescription applicationDescription) {
        return JavaCompilationUnit.builder()
                .packageName(basePackage(applicationDescription) + ".model.vm")
                .name(CLASS_NAME)
                .typeDeclarations(
                        List.of(
                                JavaTypeDeclaration.builder()
                                        .type(JavaType.CLASS)
                                        .name(CLASS_NAME)
                                        .modifiers(
                                                JavaModifier.builder()
                                                        .type(JavaModifier.TYPE_MODIFIERS)
                                                        .modifiers(Modifier.PUBLIC)
                                        )
                                        .annotations(
                                                List.of(
                                                        JavaAnnotation.builder()
                                                                .name("lombok.Data"),
                                                        JavaAnnotation.builder()
                                                                .name("lombok.NoArgsConstructor")
                                                )
                                        )
                                        .fieldDeclarations(
                                                List.of(
                                                        JavaFieldDeclaration.builder()
                                                                .name("username")
                                                                .dataType("String")
                                                                .modifiers(
                                                                        JavaModifier.builder()
                                                                                .type(JavaModifier.TYPE_MODIFIERS)
                                                                                .modifiers(Modifier.PRIVATE)
                                                                )
                                                                .annotations(
                                                                        List.of(
                                                                                JavaAnnotation.builder()
                                                                                        .name("jakarta.validation.constraints.NotNull"),
                                                                                JavaAnnotation.builder()
                                                                                        .name("jakarta.validation.constraints.Size")
                                                                                        .attributes(
                                                                                                List.of(
                                                                                                        JavaAnnotation.Attribute.builder()
                                                                                                                .name("min")
                                                                                                                .dataType(Integer.class)
                                                                                                                .values(List.of("1")),
                                                                                                        JavaAnnotation.Attribute.builder()
                                                                                                                .name("max")
                                                                                                                .dataType(Integer.class)
                                                                                                                .values(List.of("50"))
                                                                                                )
                                                                                        )

                                                                        )
                                                                ),
                                                        JavaFieldDeclaration.builder()
                                                                .name("password")
                                                                .dataType("String")
                                                                .modifiers(
                                                                        JavaModifier.builder()
                                                                                .type(JavaModifier.TYPE_MODIFIERS)
                                                                                .modifiers(Modifier.PRIVATE)
                                                                )
                                                                .annotations(
                                                                        List.of(
                                                                                JavaAnnotation.builder()
                                                                                        .name("jakarta.validation.constraints.NotNull"),
                                                                                JavaAnnotation.builder()
                                                                                        .name("jakarta.validation.constraints.Size")
                                                                                        .attributes(
                                                                                                List.of(
                                                                                                        JavaAnnotation.Attribute.builder()
                                                                                                                .name("min")
                                                                                                                .dataType(Integer.class)
                                                                                                                .values(List.of("4")),
                                                                                                        JavaAnnotation.Attribute.builder()
                                                                                                                .name("max")
                                                                                                                .dataType(Integer.class)
                                                                                                                .values(List.of("100"))
                                                                                                )
                                                                                        )

                                                                        )
                                                                ),
                                                        JavaFieldDeclaration.builder()
                                                                .name("rememberMe")
                                                                .dataType("boolean")
                                                                .modifiers(
                                                                        JavaModifier.builder()
                                                                                .type(JavaModifier.TYPE_MODIFIERS)
                                                                                .modifiers(Modifier.PRIVATE)
                                                                )
                                                                .annotations(
                                                                        List.of(
                                                                                JavaAnnotation.builder()
                                                                                        .name("com.fasterxml.jackson.annotation.JsonProperty")
                                                                                        .attributes(
                                                                                                List.of(
                                                                                                        JavaAnnotation.Attribute.builder()
                                                                                                                .dataType(String.class)
                                                                                                                .values(List.of("remember_me"))
                                                                                                )
                                                                                        )

                                                                        )
                                                                )
                                                )
                                        )
                        )
                );
    }
}
