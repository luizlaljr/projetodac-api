package br.uff.id.ProjetoDAC_Api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/*"))
                .build()
                .apiInfo(apiInfo());
                
    }
    
    private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Recursos Educacionais API")
            .description("Esta é a documentação da api dos Recursos Educacionais construída para o trabalho da disciplina de Desenvolvimento de Aplicações Corporativas do Prof. José Viterbo.")
            .version("1.0.0")
            .contact(new Contact("Luiz Alberto", "https://github.com/luizlaljr", "luiz_alberto@id.uff.br"))
            .build();
}

}
