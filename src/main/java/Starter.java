import Core.MyClass;
import Core.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pm on 1/7/16.
 */

class TT implements Runnable {
    Repo r;

    public TT(Repo r) {
        this.r = r;
    }

    public void run() {
        r.methodA();
    }
}


public class Starter {
    public static void main(String[] args) throws Exception {
//        Logger mylog = LoggerFactory.getLogger(Starter.class);
//        mylog.warn("xxxx xxx xx");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");

//        MyClass a = ctx.getBean(MyClass.class);
//        a.setX(12);
//        System.out.println(a.getY());
//        System.out.println("A+B=" + a.getAplusB());
//        a.longComputation();

        Repo r = ctx.getBean(Repo.class);

        Thread t1 = new Thread(new TT(r));
        Thread t2 = new Thread(new TT(r));
        Thread t3 = new Thread(new TT(r));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        ctx.close();
    }
}
