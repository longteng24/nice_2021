import com.teng.service.MulService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: nice-2021
 * @description: 测试传播特性
 * @author: Mr.Teng
 * @create: 2021-03-14 08:27
 **/
public class MyTest_Propagation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();
    }

}
