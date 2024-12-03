package test1;

public class MyThread extends Thread {
    static int ticket = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if(ticket < 1000) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                } else {
                    break;
                }
            }
        }
    }
}
