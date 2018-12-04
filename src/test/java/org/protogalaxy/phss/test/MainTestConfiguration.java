package org.protogalaxy.phss.test;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.restdocs.templates.TemplateFormats;

@TestConfiguration
public class MainTestConfiguration implements RestDocsMockMvcConfigurationCustomizer {
    /**
     * Customize the given {@code configurer}.
     *
     * @param configurer the configurer
     */
    @Override
    public void customize(MockMvcRestDocumentationConfigurer configurer) {
        configurer.snippets().withTemplateFormat(TemplateFormats.asciidoctor());
    }
}
