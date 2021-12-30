package com.huawei.main;

import java.util.Date;
import java.util.TimerTask;

/**
 * 
 * @ClassName:  UserTimerTask   
 * @Description:  TODO(创建线程的第四种方式，继承TimerTask类，做定时任务多一些) 
 * 
 * 步骤：
 * 1.定义类UserTimerTask，继承抽象类TimerTask
 * 2.创建UserTask类的对象
 * 3.创建Timer类的对象，设置任务的执行策略
 * 
 * @author: XIE.YUXI 
 * @date:   2021年12月30日 下午10:04:36   
 *
 */
public class UserTimerTask extends TimerTask{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + new Date());
        
    }

}
