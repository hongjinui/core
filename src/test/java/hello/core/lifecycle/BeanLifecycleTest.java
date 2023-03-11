package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {

    @Test
    public void beanLifecycle(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(BeanLifecycleConfig.class);
        NetworkClient bean = ac.getBean(NetworkClient.class);
        bean.close();
    }

    @Configuration
    static class BeanLifecycleConfig{

        @Bean(initMethod = "init",destroyMethod = "close")
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }

    }

}
