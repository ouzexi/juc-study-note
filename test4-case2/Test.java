package test4case2;

public class Test {
    /*
        微信中的抢红包也用到了多线程。
        假设：100块，分成了3个包，现在有5个人去抢。
        其中，红包是共享数据。
        5个人是5条线程。
        打印结果如下：
        	XXX抢到了XXX元
        	XXX抢到了XXX元
        	XXX抢到了XXX元
        	XXX没抢到
        	XXX没抢到
    */
//    使用BigDecimal使保留 2位小数
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        t1.setName("小A");
        t2.setName("小B");
        t3.setName("小C");
        t4.setName("小D");
        t5.setName("小E");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
