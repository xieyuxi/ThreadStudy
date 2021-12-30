package com.huawei.main;

import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    
    public static void main(String[] args) {
        
        //1.第一种方法，继承Thread类创建线程，重写run()方法，调用start()，但资源不共享
//        Thread t1 = new UserThread();
//        Thread t2 = new UserThread();
//        t1.start();
//        t2.start();
        
        /* 2.第二种方法，创建UserRun类实现Runnble接口，重写run()方法，创建Thread类的对象和
          UserRun类的对象,并将UserRun类的对象作为Thread类构造方法的参数调用start()，资源共享 */
//        UserRun userRun = new UserRun();
//        new Thread(userRun).start();
//        new Thread(userRun).start();
        
        /* 3.第三种方法，创建UserCallable类实现Callable接口，重写call方法，创建UserCallable类的对象
         * 和RunnableFuture接口的子类FutureTask的对象（构造函数的参数是UserCallable的对象），
         * 再创建Thread类的对象（构造函数的参数是FutureTask的对象），最后start()启动线程
         */
//        UserCallable userCallable = new UserCallable();
//        FutureTask futureTask = new FutureTask(userCallable);
//        new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        
        /*
         * 4.第四种方法，创建UserTimerTask类继承TimerTask抽象类，重写run()方法，
         * 创建Timer类的对象，调用schedule（）方法（参数为UserTimerTask类的对象）设置任务的执行策略
         */
//        Timer timer = new Timer();
//        // 等待1000毫秒执行，每5000毫秒执行一次
//        timer.schedule(new UserTimerTask(), 1000,5000);
        
        /*
         * 5.第五种方法，通过线程池启动多线程
         */
        // 5.1 创建线程池方法一：FixThreadPool(int n)固定大小的线程池
        // 1)创建固定大小为3的线程池
//        ExecutorService ex = Executors.newFixedThreadPool(3);
//        // 2)使用线程池执行任务
//        for(int i = 0; i< 5;i++) {
//            ex.submit(new Runnable() {
//                
//                @Override
//                public void run() {
//                    for(int j = 0; j<10;j++) {
//                        System.out.println(Thread.currentThread().getName()+" "+ j);
//                    }
//                    
//                }
//            });
//        }
//        // 3)关闭线程池
//        ex.shutdown();
        
        // 5.2 创建线程池方法二：SingleThreadPoolExecutor(int n)单线程池
        // 1)1）创建单线程池
//        ExecutorService ex = Executors.newSingleThreadExecutor();
//      // 2)使用线程池执行任务
//        for(int i = 0; i< 5;i++) {
//            ex.submit(new Runnable() {
//              
//                @Override
//                public void run() {
//                    for(int j = 0; j<5;j++) {
//                        System.out.println(Thread.currentThread().getName()+" "+ j);
//                    }
//                }
//            });
//        }
//        // 3)关闭线程池
//        ex.shutdown();

        // 5.3 创建线程池方法三：CachedThreadPool( )缓存线程池
        // 1)创建尽可能多的线程池
//        ExecutorService ex = Executors.newCachedThreadPool();
//        // 2)使用线程池执行任务
//        for(int i = 0; i< 10;i++) {
//            ex.submit(new Runnable() {
//                
//                @Override
//                public void run() {
//                    for(int j = 0; j<5;j++) {
//                        System.out.println(Thread.currentThread().getName()+" "+ j);
//                    }
//                }
//          });
//      }
//      // 3)关闭线程池
//      ex.shutdown();
        
        // 5.4 创建线程池方法四：ScheduledThreadPool( )缓存线程池
        // 1)创建固定核心线程数（最小维护的线程数，线程创建后不会被回收）的线程池
//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//            
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "执行" + new Date());
//            }
//        },5,3,TimeUnit.SECONDS);   
        

        // 5.5 创建线程池方法五：WorkStealingPool( )新的线程池类ForkJoinPool的扩展
        // 1)每一个线程都有一个自己的任务队列，可能造成CPU负载不均衡，多核CPU通过任务窃取，均衡各CPU任务的执行情况
        System.out.println("-------------start------------");
        ExecutorService ex = Executors.newWorkStealingPool();
        // 2)使用线程池执行任务
        for(int i = 0; i< 10;i++) {
            ex.submit(new Thread(new Runnable() {
                
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }));
        }
        // 3)让主线程等待子线程执行完毕，也可以使用计数器的方式
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------------end--------------");
    }

}
