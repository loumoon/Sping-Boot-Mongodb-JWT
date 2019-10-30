package cn.edu.sjtu.industry_backend.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author loumoon
 * @date 2019-10-22 14:49
 */
@Configuration
public class DozerBeanMapperConfig {
    @Bean
    public DozerBeanMapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }
}
