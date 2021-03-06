package com.project.migros.base.config;

import com.project.migros.base.mapper.DozerMapperUtility;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CommonConfig {

  @Bean
  public DozerMapperUtility dozerMapperUtility(Mapper mapper) throws Exception {
    DozerMapperUtility dozerMapperUtility = new DozerMapperUtility();
    dozerMapperUtility.setMapper(mapper);
    return dozerMapperUtility;
  }

  @Bean
  public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(List<ClassPathResource> classPathResources) {
    DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
    Resource[] resources = new Resource[classPathResources.size()];
    classPathResources.toArray(resources);
    dozerBeanMapperFactoryBean.setMappingFiles(resources);
    return dozerBeanMapperFactoryBean;
  }

  @Bean
  public List<ClassPathResource> dozerMapFiles() {
    List<ClassPathResource> classPathResources = new ArrayList<>();
    classPathResources.add(new ClassPathResource("/dozer/dozer-dtos.xml"));
    return classPathResources;
  }
}
