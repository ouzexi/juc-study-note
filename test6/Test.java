package test6;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    /*
        有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为 {10,5,20,50,100,200,500,800,2,80,300,700};
        创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”
        随机从抽奖池中获取奖项元素并打印在控制台上,格式如下:
        每次抽的过程中，不打印，抽完时一次性打印(随机)    在此次抽奖过程中，抽奖箱1总共产生了6个奖项。
    */
    public static void main(String[] args) {
        // 创建奖池
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10,5,20,50,100,200,500,800,2,80,300,700);

        Thread t1 = new MyThread(list);
        Thread t2 = new MyThread(list);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        t1.start();
        t2.start();
    }
}
