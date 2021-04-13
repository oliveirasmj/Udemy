package aulas.ti.Iti.springdemo.service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
	@Bean
	public ServletRegistrationBean messageDispatchServlet (ApplicationContext context) {
		
		MessageDispatcherServlet mds = new MessageDispatcherServlet();
		mds.setApplicationContext(context);
		mds.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(mds, "/ws/*");
	}
	
	@Bean
	public XsdSchema taskSchema() {
		return new SimpleXsdSchema(new ClassPathResource("tasks.xsd"));
	}
	
	@Bean
	public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema tasksSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("TaskPort");
		definition.setTargetNamespace("http://aulas.ti.Iti.springdemo/");
		definition.setLocationUri("/ws");
		definition.setSchema(tasksSchema);
		return definition;
	}
}
