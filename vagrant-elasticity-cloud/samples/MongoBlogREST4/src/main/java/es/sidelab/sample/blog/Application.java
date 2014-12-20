package es.sidelab.sample.blog;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	
	@Value("${mongo.host}")
	private String mongoHost;
	
	@Value("${mongo.replset}")
	private ServerAddress[] replicaSet;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public @Bean MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");
        mongo.setReplicaSetSeeds(replicaSet);
        return mongo;
   }
	
	@Bean
    public static CustomEditorConfigurer customEditorConfigurer(){
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setPropertyEditorRegistrars(
                new PropertyEditorRegistrar[]{new ServerAddressPropertyEditorRegistrar()});
        return configurer;
    }

}
