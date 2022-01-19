package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 김부건빈 출력하기")
    public void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        int a=0;
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println(a + "name = " + beanDefinitionName + " object = " + bean);
            a=a+1;
        }
    }

    @Test
    @DisplayName("화성시 동탄의 모든 김밥집 전문가 김부건 에플리케이션 빈 출력하기")
    public void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        int a=0;
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

           if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
               Object bean = ac.getBean(beanDefinitionName);
               System.out.println(a + "name = " + beanDefinitionName + " object = " + bean);
               a=a+1;
           }
        }
    }
}
