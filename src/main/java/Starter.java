
import Core.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pm on 1/7/16.
 */
public class Starter {
    public static void main(String[] args) {
        Logger mylog = LoggerFactory.getLogger(Starter.class);
        mylog.warn("xxxx xxx xx");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
        A a = ctx.getBean(A.class);
        a.setX(12);
        System.out.println(a.getY());
        System.out.println("A+B=" + a.getAplusB());
        a.longComputation();
        ctx.close();
    }
}
