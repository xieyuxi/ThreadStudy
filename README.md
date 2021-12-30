# ThreadStudy
创建线程的五种方式

一、继承Thread类

  1.通过继承Thread并且重写其run（），run方法中定义需要执行的任务。创建后的子类通过调用start（）方法即可执行线程方法。
  2.通过继承Thread实现的线程类，多个线程间无法共享线程类的实例变量。需要创建不同Thread对象，自然不共享资源。

  步骤：
  1.定义UserThread类，继承Thread类
  2.重写run()方法
  3.创建UserThread对象
  4.调用start()方法


二、实现Runnable接口∶
  1.需要先定义一个类实现Runnable接口并重写该接口的run（）方法，此run方法是线程执行体。接着创建 Runnable实现类的对象，作为创建Thread对象的参数target，此Thread对象才是真正的线程对象。
  2.利用实现Runnable接口的线程类创建对象，可以实现线程之间的资源共享。
  
  步骤：
  1.定义一个UserRun类，实现Runnble接口
  2.重写run()方法
  3.创建UserRun类的对象
  4.创建Thread类的对象，把UserRun类的对象作为Thread类构造方法的参数
  5.启动线程


三、实现Callable接口实现带有返回值的线程∶
  1.Callable接口如同Runable接口的升级版，其提供的call（）方法将作为线程的执行体，同时允许有返回值。
  2.Callable对象不能直接作为Thread对象的target，因为Callable接口是 Java5 新增的接口，不是Runnable接口的子接口。
  3.对于这个问题的解决方案，就引入 Future接口，此接口可以接受call（）的返回值，RunnableFuture接口是Future接口和Runnable接口的子接口，可以作为Thread对象的target。

  步骤：
  1.定义类UserCallable，实现Callable接口
  2.重写call()方法
  3.创建UserCallable的对象
  4.创建RunnableFuture接口的子类FutureTask的对象，构造函数的参数是UserCallable的对象
  5.创建Thread类的对象，构造函数的参数是FutureTask的对象
  6.启动线程


四、继承TimerTask∶
  1.Timer和TimerTask可以做为实现线程的另一种方式。
  2.Timer是一种线程设施，用于安排以后在后台线程中执行的任务。可安排任务执行一次，或者定期重复执行，可以看成一个定时器，可以调度TimerTask。
  3.TimerTask是一个抽象类，实现了Runnable接口，所以具备了多线程的能力。

  步骤：
  1.定义类UserTimerTask，继承抽象类TimerTask
  2.创建UserTask类的对象
  3.创建Timer类的对象，设置任务的执行策略


五、通过线程池启动多线程∶
  1.通过Executors 的工具类可以创建线程池。
  2.提高系统响应速度，当有任务到达时，通过复用已存在的线程，无需等待新线程的创建便能立即执行。
  3.降低系统资源消耗，通过重用已存在的线程，降低线程创建和销毁造成的消耗。
  4.方便线程并发数的管控。因为线程若是无限制的创建，可能会导致内存占用过多而产生OOM，并目会造成cpu过度切换。

  创建线程池方法一：FixThreadPool(int n)固定大小的线程池
  步骤：
  1）创建固定大小为3的线程池
  2）使用线程池执行任务
  3）关闭线程池 

  创建线程池方法二：SingleThreadExecutor( )单线程池
  步骤：
  1）创建单线程池
  2）使用线程池执行任务
  3）关闭线程池 

  创建线程池方法三：CachedThreadPool( )缓存线程池
  步骤：
  1）创建尽可能多的线程池
  2）使用线程池执行任务
  3）关闭线程池 

  创建线程池方法四：ScheduledThreadPool( )创建一个周期性的线程池，支持定时及周期性执行任务
  步骤：
  1）创建固定核心线程数（最小维护，创建后不会被回收）的线程池
  2）使用线程池执行任务

  创建线程池方法五：WorkStealingPool( )新的线程池类ForkJoinPool的扩展
  步骤：
  1）每一个线程都有一个自己的任务队列，可能造成CPU负载不均衡，多核CPU通过任务窃取，均衡各CPU任务的执行情况
  2）使用线程池执行任务
  3）让主线程等待子线程执行完毕，也可以使用计数器的方式
