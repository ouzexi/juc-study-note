package test5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MyThread extends Thread {
    ArrayList<Integer> list;

    MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (MyThread.class) {
                if(list.size() == 0) {
                    break;
                } else {
                    // 继续抽奖 洗牌
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    System.out.println(getName() + "产生了" + price + "元大奖");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
