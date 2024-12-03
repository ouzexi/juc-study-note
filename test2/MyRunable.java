package test2;

public class MyRunable implements Runnable {
    int count = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (MyRunable.class) {
                if(count < 10) {
                    System.out.println("礼物还剩下" + count + "个，不再赠送");
                    break;
                } else {
                    count--;
                    System.out.println(Thread.currentThread().getName() + "在赠送礼物，还剩下" + count + "个礼物");
                }
            }
        }
    }
}
