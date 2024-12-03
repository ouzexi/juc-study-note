package test3;

public class MyRunable implements Runnable {
    int number = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (MyRunable.class) {
                if(number > 100) {
                    break;
                } else {
                    if(number % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "打印数字：" + number);
                    }
                    number++;
                }
            }
        }
    }
}
