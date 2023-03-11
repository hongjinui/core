package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonTest {

    @Test
    void singleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonConfig.class);
        SingletonConfig singletonConfig1 = ac.getBean(SingletonConfig.class);
        SingletonConfig singletonConfig2 = ac.getBean(SingletonConfig.class);

        System.out.println("singletonConfig1 = " + singletonConfig1);
        System.out.println("singletonConfig2 = " + singletonConfig2);

        assertThat(singletonConfig1).isSameAs(singletonConfig2);

        ac.close();


    }

    @Scope("singleton")
    static class SingletonConfig {

        @PostConstruct
        public void init() {
            System.out.println("SingletonConfig.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("SingletonConfig.destroy");
        }

    }
}
