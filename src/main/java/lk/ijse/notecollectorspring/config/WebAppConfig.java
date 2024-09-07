package lk.ijse.notecollectorspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@ComponentScan(basePackages = "lk.ijse.notecollectorspring")
@EnableWebMvc
public class WebAppConfig {

}
