package Core;


import org.springframework.stereotype.Component;

/**
 * Methods of this class must be synchronized (i.e. 1thread at most in each)
 */
@Component
public class Repo {
    public void methodA() {
        System.out.println("In method A : " + Thread.currentThread());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting A : " + Thread.currentThread());
    }
}
