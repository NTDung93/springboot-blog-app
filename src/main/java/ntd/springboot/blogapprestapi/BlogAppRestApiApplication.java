package ntd.springboot.blogapprestapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Blog App API",
                version = "v1.0",
                description = "Spring Boot Blog App REST APIs",
                contact = @Contact(
                        name = "Nguyen Tien Dung",
                        email = "nguyentiendung2003@gmail.com",
                        url = "https://www.facebook.com/dunggg93/"
                ),
                license = @License(
						name = "Apache 2.0",
						url = "https://github.com/NTDung93"
				)
        ),
        externalDocs = @ExternalDocumentation(
				description = "Spring Boot Blog App Documentation",
				url = "https://github.com/NTDung93/springboot-blog-app"
        )
)
public class BlogAppRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAppRestApiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
