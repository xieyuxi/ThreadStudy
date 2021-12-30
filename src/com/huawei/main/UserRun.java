package com.huawei.main;

/**
 * 
 * @ClassName:  UserRun   
 * @Description:  TODO(创建线程的第二种方法，实现Runnble接口，资源共享) 
 * 
 * 步骤：
 * 1.定义一个UserRun类，实现Runnble接口
 * 2.重写run()方法
 * 3.创建UserRun类的对象
 * 4.创建Thread类的对象，把UserRun类的对象作为Thread类构造方法的参数
 * 5.启动线程
 * @author: XIE.YUXI 
 * @date:   2021年12月30日 下午9:13:34   
 *
 */
public class UserRun implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i<5;i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行"+ i);     
        }
    }
}
