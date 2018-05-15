package test.springtest;
import test.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test(){
        //读取配置文件
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Zoo zoo=(Zoo) ctx.getBean("zoo");
        System.out.println(zoo.toString());
    }

}
