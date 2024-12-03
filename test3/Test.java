package test3;

public class Test {
    /*
       同时开启两个线程，共同获取1-100之间的所有数字。
       要求：将输出所有的奇数。
    */
    public static void main(String[] args) {
        MyRunable mr = new MyRunable();

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();
    }
}
