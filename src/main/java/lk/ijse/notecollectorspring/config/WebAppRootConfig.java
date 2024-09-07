package lk.ijse.notecollectorspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = "lk.ijse.notecollectorspring")
public class WebAppRootConfig {
}
