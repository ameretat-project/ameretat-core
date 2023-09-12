package tech.amereta.generator.domain.description.java.field;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tech.amereta.generator.domain.description.java.JavaFieldDescription;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
//@AllArgsConstructor
@NoArgsConstructor
public final class JavaRepositoryFieldDescription extends JavaFieldDescription {
}
