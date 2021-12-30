package com.huawei.main;

import java.util.concurrent.Callable;

/**
 * 
 * @ClassName:  UserCallable   
 * @Description:  TODO(创建线程的第三种方式，实现Callable接口创建带有返回值线程) 、
 * 
 * 步骤：
 * 1.定义类UserCallable，实现Callable接口
 * 2.重写call()方法
 * 3.创建UserCallable的对象
 * 4.创建RunnableFuture接口的子类FutureTask的对象，构造函数的参数是UserCallable的对象
 * 5.创建Thread类的对象，构造函数的参数是FutureTask的对象
 * 6.启动线程
 * @author: XIE.YUXI 
 * @date:   2021年12月30日 下午9:19:09   
 *
 */
public class UserCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "：学习"); 
        return "学习";
    }
    

}
