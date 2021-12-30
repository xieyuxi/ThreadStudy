package com.huawei.main;

/**
 * 
 * @ClassName:  UserThread   
 * @Description:  TODO(创建线程的第一种方式，继承Thread类，资源不共享) 
 * 
 * 步骤：
 * 1.定义UserThread类，继承Thread类
 * 2.重写run()方法
 * 3.创建UserThread对象
 * 4.调用start()方法
 * 
 * @author: XIE.YUXI 
 * @date:   2021年12月30日 下午9:03:02   
 *
 */
public class UserThread extends Thread{

    public void run() {
        for(int i = 0; i<5;i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行"+ i);     
        }
    }

}
