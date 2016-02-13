package util.config;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("application.properties")
public interface EnvironmentConfig {
    @Property("baseUrl")
    String getBaseUrl();

    @Property("target.browser")
    String getBrowser();
}
