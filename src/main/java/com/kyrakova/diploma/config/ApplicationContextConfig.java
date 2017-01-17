package com.kyrakova.diploma.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyrakova.diploma.models.BaseModel;
import com.kyrakova.diploma.models.category.Category;
import com.kyrakova.diploma.models.category.CategoryDaoImpl;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroup;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroupDaoImpl;
import com.kyrakova.diploma.models.image.Image;
import com.kyrakova.diploma.models.image.ImageDaoImpl;
import com.kyrakova.diploma.models.model.Model;
import com.kyrakova.diploma.models.model.ModelDaoImpl;
import com.kyrakova.diploma.models.modelProperty.CategoryProperty;
import com.kyrakova.diploma.models.modelProperty.CategoryPropertyDaoImpl;
import com.kyrakova.diploma.models.modelPropertyValue.ModelPropertyValue;
import com.kyrakova.diploma.models.modelPropertyValue.ModelPropertyValueDaoImpl;
import com.kyrakova.diploma.models.property.Property;
import com.kyrakova.diploma.models.property.PropertyDaoImpl;
import com.kyrakova.diploma.models.role.Role;
import com.kyrakova.diploma.models.role.RoleDaoImpl;
import com.kyrakova.diploma.models.section.Section;
import com.kyrakova.diploma.models.section.SectionDaoImpl;
import com.kyrakova.diploma.models.user.User;
import com.kyrakova.diploma.models.user.UserDaoImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.kyrakova.diploma")
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        return viewResolver;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }
     
    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/InternetShop");
    	dataSource.setUsername("postgres");
    	dataSource.setPassword("root");
		dataSource.setValidationQuery("select 1");

    	return dataSource;
    }

    @Bean(name="multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(5242880);//5MB
        return resolver;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.id.new_generator_mappings", "false");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(BaseModel.class);
    	sessionBuilder.addAnnotatedClasses(User.class);
    	sessionBuilder.addAnnotatedClasses(Role.class);
    	sessionBuilder.addAnnotatedClasses(Property.class);
    	sessionBuilder.addAnnotatedClasses(Category.class);
    	sessionBuilder.addAnnotatedClasses(CategoryProperty.class);
    	sessionBuilder.addAnnotatedClasses(Model.class);
    	sessionBuilder.addAnnotatedClasses(ModelPropertyValue.class);
    	sessionBuilder.addAnnotatedClasses(Image.class);
    	sessionBuilder.addAnnotatedClasses(Section.class);
    	sessionBuilder.addAnnotatedClasses(CategoryGroup.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
        return converter;
    }
    
    @Autowired
    @Bean(name = "userDao")
    public UserDaoImpl getUserDao(SessionFactory sessionFactory) {
    	return new UserDaoImpl(sessionFactory);
    }

	@Autowired
	@Bean(name = "roleDao")
	public RoleDaoImpl getRoleDao(SessionFactory sessionFactory) {
		return new RoleDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "categoryDao")
	public CategoryDaoImpl getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

    @Autowired
    @Bean(name = "propertyDao")
    public PropertyDaoImpl getPropertyDao(SessionFactory sessionFactory) {
        return new PropertyDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "categoryPropertyDao")
    public CategoryPropertyDaoImpl getCategoryPropertyDao(SessionFactory sessionFactory) {
        return new CategoryPropertyDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "modelDao")
    public ModelDaoImpl getModelDao(SessionFactory sessionFactory) {
        return new ModelDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "imageDao")
    public ImageDaoImpl getImageDao(SessionFactory sessionFactory) {
        return new ImageDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "modelPropertyValueDao")
    public ModelPropertyValueDaoImpl getModelPropertyValueDao(SessionFactory sessionFactory) {
        return new ModelPropertyValueDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "sectionDao")
    public SectionDaoImpl getSectionDao(SessionFactory sessionFactory) {
        return new SectionDaoImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "categoryGroupDao")
    public CategoryGroupDaoImpl getCategoryGroupDao(SessionFactory sessionFactory) {
        return new CategoryGroupDaoImpl(sessionFactory);
    }
}
