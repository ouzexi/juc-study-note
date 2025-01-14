package test5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    /*
        有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为 {10,5,20,50,100,200,500,800,2,80,300,700};
        创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”
        随机从抽奖池中获取奖项元素并打印在控制台上,格式如下:
                         每次抽出一个奖项就打印一个(随机)
        	抽奖箱1 又产生了一个 10 元大奖
        	抽奖箱1 又产生了一个 100 元大奖
        	抽奖箱1 又产生了一个 200 元大奖
        	抽奖箱1 又产生了一个 800 元大奖
        	抽奖箱2 又产生了一个 700 元大奖
        	.....
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
