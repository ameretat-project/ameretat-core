package tech.amereta.generator.service.web;

import tech.amereta.generator.domain.description.ApplicationDescription;

import java.io.IOException;
import java.io.OutputStream;

public interface ApplicationGenerator {

    void generate(ApplicationDescription application, OutputStream outputStream) throws IOException;
}
