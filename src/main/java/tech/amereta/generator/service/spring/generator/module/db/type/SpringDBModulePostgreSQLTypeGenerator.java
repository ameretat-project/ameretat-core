package tech.amereta.generator.service.spring.generator.module.db.type;

import tech.amereta.core.java.JavaCompilationUnit;
import tech.amereta.generator.service.spring.generator.module.AbstractSpringModuleTypeGenerator;
import tech.amereta.generator.service.spring.generator.module.db.DataBaseConfigurationGenerator;
import tech.amereta.lang.description.spring.SpringBootApplicationDescription;
import tech.amereta.lang.description.spring.SpringModuleTypeDescription;
import tech.amereta.lang.description.spring.db.type.SpringBootPostgreSQLDBModuleGenerator;

import java.util.List;

@SpringBootPostgreSQLDBModuleGenerator
public final class SpringDBModulePostgreSQLTypeGenerator extends AbstractSpringModuleTypeGenerator {

    @Override
    public List<JavaCompilationUnit> generate(final SpringBootApplicationDescription applicationDescription,
                                              final SpringModuleTypeDescription db) {
        return List.of(
                DataBaseConfigurationGenerator.generate(applicationDescription)
        );
    }
}
