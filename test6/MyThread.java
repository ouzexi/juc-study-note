package test6;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    ArrayList<Integer> list;

    ArrayList<Integer> boxList = new ArrayList<>();

    MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (MyThread.class) {
                if(list.isEmpty()) {
                    System.out.println(getName() + boxList);
                    break;
                } else {
                    // 继续抽奖 洗牌
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    boxList.add(price);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
