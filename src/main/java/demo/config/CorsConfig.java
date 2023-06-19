package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1.允許任何來源
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
        // 2.允許任何請求頭
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        // 3.允許任何方法
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        // 4.允許憑證
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}