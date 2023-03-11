package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    public void prototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeConfig.class);
        PrototypeConfig prototypeConfig1 = ac.getBean(PrototypeConfig.class);
        PrototypeConfig prototypeConfig2 = ac.getBean(PrototypeConfig.class);

        System.out.println("prototypeConfig1 = " + prototypeConfig1);
        System.out.println("prototypeConfig2 = " + prototypeConfig2);

        assertThat(prototypeConfig1).isNotSameAs(prototypeConfig2);

        ac.close();
    }

    @Scope("prototype")
    static class PrototypeConfig{

        @PostConstruct
        public void init() {
            System.out.println("PrototypeConfig.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeConfig.destroy");
        }

    }

}
