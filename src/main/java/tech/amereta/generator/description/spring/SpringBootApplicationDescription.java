package tech.amereta.generator.description.spring;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.amereta.generator.description.AbstractApplication;
import tech.amereta.generator.description.spring.db.SpringDBModuleDescription;
import tech.amereta.generator.description.spring.model.SpringModelModuleDescription;
import tech.amereta.generator.description.spring.security.SpringSecurityModuleDescription;
import tech.amereta.generator.service.spring.SpringBootApplicationGeneratorService;
import tech.amereta.generator.service.spring.SpringBootApplicationValidatorService;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringBootApplicationDescription implements AbstractApplication {

    @NotNull(message = "Application's name must not be null!")
    private String name;

    @NotNull(message = "Application's package must not be null!")
    @JsonProperty("package")
    private String packageName;

    private String description = "Generated by Amereta!";

    private String javaVersion = "17";

    private String springVersion = "3.1.3";

    private String ameretaVersion = "0.1.0";

    private String port = "8080";

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "module",
            visible = true
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = SpringModelModuleDescription.class, name = "MODEL"),
            @JsonSubTypes.Type(value = SpringDBModuleDescription.class, name = "DB"),
            @JsonSubTypes.Type(value = SpringSecurityModuleDescription.class, name = "SECURITY"),
    })
    @Valid
    private List<AbstractSpringModuleDescription> modules;

    @JsonIgnore
    private Class<?> generator = SpringBootApplicationGeneratorService.class;

    @JsonIgnore
    private Class<?> validator = SpringBootApplicationValidatorService.class;
}
