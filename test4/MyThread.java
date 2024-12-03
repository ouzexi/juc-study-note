package test4;

import java.util.Random;

public class MyThread extends Thread {
    // 总金额100元
    static double money = 100;
    // 分成3个红包
    static int count = 3;
    // 最小的中奖金额
    static final double MIN = 0.01;

    @Override
    public void run() {
        synchronized (MyThread.class) {
            if(count == 0) {
                System.out.println(getName() + "没有抢到红包");
            } else {
                // 定义一个变量，表示中奖的金额
                double price = 0;
                if(count == 1) {
                    // 表示最后一个红包，无需随机，直接剩余的钱都是金额
                    price = money;
                } else {
                    // 表示第一次，第二次随机
                    Random r = new Random();
                    // 第一个红包最大金额只能为 100 - (3-1)*0.01 = 99.98
                    double bounds = money - (count - 1) * MIN;
                    // 从最大金额范围内取一个数
                    price = r.nextDouble(bounds);
                    if(price < MIN) {
                        price = MIN;
                    }
                }
                // 更新剩余金额数
                money = money - price;
                count--;
                System.out.println(getName() + "抢到了" + price + "元");
            }
        }
    }
}
