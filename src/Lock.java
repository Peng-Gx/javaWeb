import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Lock {
    public static void main(String[] args) {
//        sychronizedTest();
        casTest();

    }

    public static void casTest(){
//        AtomicInteger count=new AtomicInteger(0);

        AtomicBoolean tag=new AtomicBoolean(false);

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
//                    int current=count.get();
//                    int next=current+1;
                    if(tag.compareAndSet(false,true)){
                        try {
                            fun1(Thread.currentThread().getName());
                            tag.set(false);
                            break;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
//                    int current=count.get();
//                    int next=current+1;
                    if(tag.compareAndSet(false,true)){
                        try {
                            fun1(Thread.currentThread().getName());
                            tag.set(false);
                            break;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        });

        t1.start();
        t2.start();
        System.out.println("casTest");
    }

    public static void fun1(String m) throws InterruptedException {
        for(int i=0;i<10;i++){
            Thread.sleep(100);
            System.out.println(m);
        }
    }

    public static void sychronizedTest(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fun(Thread.currentThread().getName().toString());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fun(Thread.currentThread().getName().toString());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        System.out.println("sychronizedTest");
    }


    public static synchronized void fun(String m) throws InterruptedException {
        for(int i=0;i<10;i++){
            Thread.sleep(100);
            System.out.println(m);
        }
    }


}
