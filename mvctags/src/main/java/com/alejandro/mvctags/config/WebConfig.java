package com.alejandro.mvctags.config;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;


@Configuration
@EnableWebMvc
@ComponentScan("com.alejandro.mvctags")
public class WebConfig implements WebMvcConfigurer,WebApplicationInitializer{
	
	@Bean
	public ViewResolver getInternalViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/vistas/", ".jsp");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/")
		.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
	}
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//Creacion del webApplicationContext
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//Registro de la clase de configuracion (this)
		context.register(this.getClass());
		//Instancia del dispatcherServlet cargando el contexto de la aplicacion
		DispatcherServlet servlet = new DispatcherServlet(context);
		//Carga del servlet dispatcher en el contexto/contenedor de servlets
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}
	//Mensajes de errores personalizados
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.addBasenames("messages");
		//rbms.setDefaultEncoding("UTF-8");
		return rbms;
	}
	
	
}
