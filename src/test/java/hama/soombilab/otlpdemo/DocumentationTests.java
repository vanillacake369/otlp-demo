package hama.soombilab.otlpdemo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class DocumentationTests {

    @Test
    void generateModuleDocs() {
        ApplicationModules modules = ApplicationModules.of(OtlpDemoApplication.class);

        new Documenter(modules)
            // generate overall component diagram (PlantUML/C4)
            .writeModulesAsPlantUml()
            // generate per-module diagrams & canvases
            .writeIndividualModulesAsPlantUml()
        // optionally: .writeAggregateAsciidoc(…)
        ;
    }
}