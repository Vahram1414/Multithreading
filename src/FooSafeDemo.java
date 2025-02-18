public class FooSafeDemo {

    public static void main(String[] args) {
        FooDemo fooDemo = new FooDemo();
        Thread t1 = new Thread(fooDemo::first);
        Thread t2 = new Thread(fooDemo::second);
        Thread t3 = new Thread(fooDemo::third);

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

    }

}
