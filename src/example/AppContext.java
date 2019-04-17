package example;

import annotation.Configuration;
import annotation.Scan;

@Configuration
@Scan(base = "example.service")
public class AppContext {
}
