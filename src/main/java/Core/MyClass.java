package Core;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by pm on 1/7/16.
 */

@Data
@Component
public class MyClass {
    int x;
    int y;

    public int getAplusB() {
        int res = x + y;
        System.out.println("----running---");
        return res;
    }

    public void longComputation() {
        System.out.println("cmp start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cmp end");
    }
}
