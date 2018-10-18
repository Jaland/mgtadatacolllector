package landister.magic.datacollector.config;

import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeaturesConfig {

  @Value("${cxf.path}")
  private String basePath;

  @Bean("swagger2Feature")
  public Swagger2Feature swagger2Feature() {
    Swagger2Feature result = new Swagger2Feature();
    result.setTitle("Magic Data Collection Application");
    result.setDescription("Endpoint for collecting MtgA data");
    result.setBasePath(this.basePath);
    result.setVersion("v1");
    result.setSchemes(new String[] { "http", "https" });
//    result.setPrettyPrint(true);
    result.setScanAllResources(true);
    return result;
  }
}
