package br.com.rodrigopeleias;

import br.com.rodrigopeleias.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class LagoonBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagoonBackendApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter((Filter) new JwtFilter());
        registrationBean.addUrlPatterns("/rest/*");

        return registrationBean;
    }
}
