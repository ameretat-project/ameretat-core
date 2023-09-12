package tech.amereta.generator.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import tech.amereta.generator.domain.description.ApplicationDescription;

import java.io.IOException;
import java.io.OutputStream;

@Service
public final class ApplicationGeneratorService {

    @Autowired
    private ApplicationContext context;

    public void generate(final ApplicationDescription application, final OutputStream outputStream) throws IOException {
        final ApplicationGenerator generator = (ApplicationGenerator) context.getBean(application.getApplication().getGenerator());
        generator.generate(application, outputStream);
    }
}
