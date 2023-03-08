package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    같은 이름으로 빈을 생성하지만 수동 등록 빈이 우선권을 가진다.
//    @Bean(name = "memoryMemberRepository")
//    MemoryMemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
