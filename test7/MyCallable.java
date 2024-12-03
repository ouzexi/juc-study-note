package test7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    ArrayList<Integer> list;

    MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (MyCallable.class) {
                if(list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + boxList);
                    break;
                } else {
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    boxList.add(price);
                }
            }
            Thread.sleep(10);
        }
        if(boxList.isEmpty()) return null;

        return Collections.max(boxList);
    }
}
