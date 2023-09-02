package tech.amereta.core.domain.description;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.amereta.core.domain.description.java.JavaTypeDescription;
import tech.amereta.core.domain.description.java.type.JavaDAOTypeDescription;
import tech.amereta.core.domain.description.java.type.JavaRepositoryTypeDescription;
import tech.amereta.core.service.web.SpringBootGeneratorService;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringBootApplicationDescription implements Application {

    @NotNull
    private String name;

    @Builder.Default
    private String description = "Generated by Amereta!";

    @Builder.Default
    private String javaVersion = "17";

    @Builder.Default
    private String springVersion = "3.1.3";

    @Builder.Default
    private String port = "8080";

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,//
            property = "type",//
            visible = true)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = JavaDAOTypeDescription.class, name = "DAO"),
            @JsonSubTypes.Type(value = JavaRepositoryTypeDescription.class, name = "REPOSITORY")
    }
    )
    private List<JavaTypeDescription> types;

    @Builder.Default
    @JsonIgnore
    private Class<?> generator = SpringBootGeneratorService.class;
}