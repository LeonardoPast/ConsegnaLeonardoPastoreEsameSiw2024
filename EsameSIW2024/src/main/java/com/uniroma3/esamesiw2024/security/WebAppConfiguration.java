package com.uniroma3.esamesiw2024.security;

import com.uniroma3.esamesiw2024.utilies.thymeleaf.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebAppConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		String webPageSuffix = env.getProperty("spring.thymeleaf.suffix");
		
		List<String> listaPagineIndex = ApplicationUtil.getRootApplicationPages(webPageSuffix);
		for(String pageName: listaPagineIndex) {
			registry.addViewController("/"+pageName).setViewName(pageName);
		}
	}

}
