# Java

## 一、基础

### 1. 概述



### 2. 基础语法



### 3. 面向对象 



### 4. IO流



### 5. 集合



### 6. 多线程



### 7. 网络编程



### 8. 反射机制



### 9. JVM

（一）描述JVM加载Class文件的原理和机制

1. 加载：通过类加载器加载Class文件
2. 链接
   1. 验证：校验class文件数据的正确性
   2. 准备：为静态变量分配内存空间
   3. 解析：将符号引用转换成直接引用
3. 初始化：初始化静态变量，静态代码块



### 10. 常用API



### 11. 常用工具类库



### 12. 单元测试



### 13. 面试概念

#### 1. Java语言特点

1. 面向对象（封装、继承、多态）
2. 跨平台（Java虚拟机实现平台无关性）
3. 健壮性（Java语言的强类型机制、异常处理、垃圾自动回收）
4. 支持多线程

#### 2. 编译器、解释器

​	Java源码 (通过javac编译器) --> 字节码.class（虚拟机解释） --> 机器码 --> 特定机器上运行

#### 3. 用最有效率的方法计算 3 乘以 8

​	3 << 3（左移 3 位相当于乘以 2 的 3 次方，右移 3 位相当于除以 2 的 3 次方）。

#### 4. final, finally, finalize 的区别

1. final是用来修饰类、方法、变量的

   修饰类表示类不能被继承

   修饰方法表示方法不能别重写

   修饰变量表示变量不能被重新赋值

2. finally一般作用于try..catch...代码块中，处理异常时，用finally表示不管是否出现异常，都会执行finally里的代码

3. finalize是一个方法，属于Object类的一个方法，该方法一般由垃圾回收器来调用

#### 5. static

1. 定于在类中的方法或者属性时，可以不用创建对象，直接调用方法或者使用属性
2. 用来行成静态代码块。

#### 6. 面向对象三大特性

1. 封装：指把一个对象的属性私有化，同时提供一些可以被外界访问的属性的方法。

2. 继承：指在对已有的类上的方法或者属性进行复用，也可以进行拓展。

3. 多态：基于对象所属类的 不同，外部对同一个方法的调用，实际执行的逻辑不同

   ```java
   // 需要有继承，方法重写，父类引用指向子类对象
   父类类型 变量名 = new 子类对象;
   变量名.方法名();
   ```

   

#### 7. 面向对象五大基本原则是什么

1. 单一职责SRP(Single Responsibility Principle) 

   类的功能要单一

2. 开放封闭OCP(Open－Close Principle) 

   一个模块对于拓展是开放的，对于修改是封闭的

3. 里式替换LSP(the Liskov Substitution Principle) 

   子类可以替换父类出现的任何地方 

4. 依赖倒置DIP(the Dependency Inversion Principle) 

   高层次的模块不应该依赖于低层次的模块，他们都应该依赖于抽象。抽象不应该依赖于具体实现，具体实现应该依赖于抽象 

5. 接口分离ISP(the Interface Segregation Principle) 

   设计时采用多个与特定客户类有关的接口比采用一个通用的接口要好 

#### 8. 抽象类和接口有什么区别

区别：

1. 抽象类使用的是abstract关键字声明

   接口使用interface关键字声明

2. 抽象类的子类使用extends关键字来继承

   接口的子类使用implements关键字来实现

3. 抽象类可以有构造器

   接口不能有构造器

4. 一个类最多只能继承一个抽象类

   但可以实现多个接口

5. 抽象类中的方法可以是任意访问修饰符

   接口方法默认修饰符是public

6. 抽象类的字段声明可以是任意的

   接口的字段默认是 static 和 final的

备注：

1. Java8中接口中引入默认方法和静态方法，以此来减少抽象类和接口之间的差异。

现在，我们可以为接口提供默认实现的方法了，并且不用强制子类来实现它。

```java
static void a() {
    System.out.println("静态方法");
}
default void b() {
    System.out.println("默认方法");
}
```

2. 接口和抽象类各有优缺点，在接口和抽象类的选择上，必须遵守这样一个原则：

   a. 行为模型应该总是通过接口而不是抽象类定义，所以通常是优先选用接口，尽量少用抽象类。

   b. 选择抽象类的时候通常是如下情况：需要定义子类的行为，又要为子类提供通用的功能。

#### 9. 静态变量和实例变量区别

1. 静态变量： 静态变量由于不属于任何实例对象，它是属于类的，在类的加载过程中，JVM只为静态变量分配一次内存空间。
2. 实例变量： 每次创建对象，都会为每个对象分配成员变量内存空间，实例变量是属于实例对象的，在内存中，创建几次对象，就有几份成员变量。

#### 10. 重载和重写的区别 

1. 重载：发生在同一个类中，方法名相同，参数列表不同（参数类型不同、个数不同、顺序不同），并且与返回的类型以及修饰符无关。
2. 重写：发生在子类中，方法名、参数列表必须相同，返回值小于等于父类、抛出的异常小于等于父类，访问修饰符大于等于父类

#### 11. HashCode 与 equals

（1）hash：散列，是一个函数。把任意长度的输入，通过散列算法，变成固定长度的输出，该输出就是散列值。

（2）HashCode ：通过hash函数得来的。HashCode 就是在hash表中对应的位置。每个对象都有HashCode 。

1. 如果两个对象equals相等，则HashCode 一定也是相同的

2. 两个对象相等，对两个对象分别调用equals方法都返回true

3. 两个对象有相同的HashCode 值，它们也不一定是相等的，只能说明这两个对象在散列储存结构中，存放在同一个位置。

#### 12. 栈、堆、常量池、方法区

1. 栈：

   存放基本类型的变量数据：int a = 1

   对象的引用：String s

   局部变量。

2. 堆

   存放所有new出来的对象

   成员变量

3. 常量池：两种形态，静态常量池、运行时常量池

   静态常量池：即.class文件中的常量池，class文件中的常量池不仅仅包含字符串(数字)字面量，还包含类、方法的信息，占用class文件绝大部分空间。

   运行时常量池：JVM在完成类装在操作后，将class文件中的常量池载入到内存中，并保存在方法区中，我们常说的常量池就是指方法区中的运行时常量池。

#### 14. 谈谈你对IO的理解

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418185002235.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3ODc1NTg1,size_16,color_FFFFFF,t_70)

##### Java中有几种类型的流

1. 有两种类型的流：字节流、字符流
2. 字节流继承inputStream和OutputStream，字符流继承inputStreamReader和outputStreamWriter

##### BIO，NIO，AIO 有什么区别?

1. BIO: Block IO同步阻塞式IO，就是我们平常使用的传统IO，它的特点是模式简单使用方便，并发处理能力低。
2. NIO: non-blocking  IO同步非阻塞IO，是传统IO的升级，客户端和服务器端通过Channel（通道）通讯，实现了多路复用。
3. AIO: Asynchronous IO是NIO的升级，也叫NIO2，实现了异步非堵塞IO，异步IO的操作基于事件和回调机制。

#### 15. 说说反射的用途及实现 

##### 什么是反射机制？

1. Java反射机制是在运行状态中，对于任意一个类，都能知道这个类的所有属性和方法，并且能够任意调用它的任意一个方法和属性。这种动态获取的信息以及动态调用对象的方法的功能称为Java语言的反射机制

2. 静态编译：在编译时确定类型，绑定对象
3. 动态编辑：在运行时确定类型，绑定对象

##### 反射机制优缺点

1. 优点：可以实现动态创建对象和编译，体现出很大的灵活性 
2. 缺点：性能瓶颈，反射相当于一系列解释操作，通知JVM要做的事情，性能比直接的Java代码要慢很多

##### 反射机制的应用场景

1. 模块化的开发，通过反射去调用对应的字节码

2. 动态代理设计模式也采用了反射机制

3. Spring、Hibernate等框架也大量使用了反射机制

4. 举例：

   1. 在使用JDBC连接数据库时，使用Class.forName()反射加载数据库的驱动程序

   2. Spring框架中，最经典的就是XML的配置模式。

      Spring通过XML配置模式装载Bean的过程：

      a. 将程序内所有的XML或者Properties配置文件加载到内存中

      b. Java类里面解析XML或者Properties里面的内容，得到对应实体类的字节码字符串以及相关的属性信息

      c. 使用反射机制，根据这个字符串获得某个类的Class实例

      d. 动态配置实例的属性

##### Java获取反射的三种方法

1. 通过建立对象（new 对象）
2. 通过路径（Class.forName("路径")）
3. 通过类名（对象.class）

#### 16. 网络编程

[网络编程]: https://blog.csdn.net/ThinkWon/article/details/104903925

#### 17. String str="i" 与String str=new String("i")一样吗

1. 不一样，因为内存分配的方式不一样。String str="i"，JVM会将其分配到常量池中。new String("i")则会被分配到堆内存中。并且会去常量池中查找是否有i这个对象，没有的话，则会创建一个。

2. 所以new new String("i")，如果常量池中没有i对象，则会创建两个对象，如果有了，就只会在堆中创建对象。

3. String s = "hel" + "lo"，在class文件中自动被优化成String s = "hello"

4. s.intern()：将s对象添加到常量池

#### 18. Java中的操作字符串以及它们的区别

1. Java中的操作字符串有：String、StringBuffer、StringBuilder

2. 区别
   1. 运行速度比较：StringBuilder> StringBuffer> String
      1. String是final类不能被继承且字符串为常量，String对象一旦被创建便不能被修改，当你对已经创建的String操作时，实际上JVM会在创建一个新的String对象，然后将指针指向原来的String，而原来的对象则被JVM的垃圾回收机制回收掉。
      2. StringBuilder和StringBuffer则为字符串变量，当你通过append操作同一个对象时，则只在原先对象进行更改。
   2. 线程安全性
      1. StringBuilder效率高，属于非线程安全，适用于单线程下。
      2. StringBuffer效率低，属于线程安全，适用于多线程下。

#### 19. JSP九大内置对象

1. request：代表了客户端的请求信息，主要用于接收通过HTTP协议发送到服务器的数据

2. response：代表了客户端的响应，主要是将JSP容器处理过的对象传回到客户端

3. session：在第一个JSP页面被装载时自动创建，完成会话期管理

4. application：对象可将信息保存在服务器中，直到服务器关闭，否则application对象中保存的信息会在整个应用中都有效 

5. out：用于在Web浏览器内输出信息，并且管理应用服务器上的输出缓冲区。

6. page：可将信息保存在服务器中，直到服务器关闭，否则application对象中保存的信息会在整个应用中都有效 

7. pageContext： 作用是取得任何范围的参数，通过它可以获取 JSP页面的out、request、reponse、session、application 等对象。 

8. config：主要作用是取得服务器的配置信息 

9. exception：作用是显示异常信息 



## 二、工具

### 1. IDEA



### 2. Git



### 3. Docker



### 4. GitLab



### 5. Linux



## 三、数据库

### (一)关系型数据库(RDS)

#### MySQL

##### 1. 数据库的三大范式

1. 原子性：即列不能继续在分割成其他列
2. 非主键字段必须依赖于主键字段
3. 消除传递性

##### 2. 事务的特性（ACID）

1. 原子性（Atomicity）

   事务是最小的执行单位，不允许分割。事务的原子性确保动作要么全部完成，要么完全不起作用 

2. 一致性（Consistency）

   执行事务前后，数据保持一致，多个事务对同一个数据读取的结果是相同的； 

3. 隔离性（Isolation）

   并发访问数据库时，一个用户的事务不被其他事务所干扰，各并发事务之间数据库是独立的 

4. 持久性（Durability）

   一个事务被提交之后。它对数据库中数据的改变是持久的，即使数据库发生故障也不应该对其有任何影响 

##### 3. 加了索引需要注意的

1. 避免在where中使用or连接条件，而是用union all代替
2. 避免在索引列上使用MySQL内置函数
3. 避免在where中对字段进行表达式操作
4. 避免使用!=、<>操作符
5. 尽量在Where和order by 涉及的列上建立索引
6. 使用联合索引是，要遵循最左匹配原则

##### 4. 数据库优化

###### explain

[EXPLAIN用法和结果分析]: https://blog.csdn.net/why15732625998/article/details/80388236

1. type：查询使用类型

   system > const > eq_ref > ref > range > index > all

   1. ref：匹配某个单独值
   2. range：一般使用where、in、大于、小于等查询
   3. index: index类型遍历索引树
   4. all：遍历全表

###### 何加快数据库查询速度？

使用索引

1. 什么是索引

   MySQL索引采用的是B+树结构，使用索引的目的是为了，减少I/O次数 ，提高查询效率

2. 原理：

   通过不断的缩小想要获得数据的范围，来筛选出最终想要的结果，同时把随机的事件变成顺序的事件，所以可以理解成索引是排好序的数据结构。



##### 5. 常用SQL



##### 6. MySQL隔离级别

###### 脏读

允许读取到未提交的脏数据。

###### 不可重复读

如果你在时间点T1读取了一些记录，在T2时再想重新读取一次同样的这些记录时，这些记录可能已经被改变、或者消失不见。

###### 幻读

解决了不重复读，保证了同一个事务里，查询的结果都是事务开始时的状态（一致性）。但是，如果另一个事务同时提交了新数据，本事务再更新时，就会“惊奇的”发现了这些新数据，貌似之前读到的数据是“鬼影”一样的幻觉。

###### 由ANSI/ISO定义的SQL-92标准定义的四种隔离级别

| 隔离解别            | 脏读 | 不可重复读 | 幻读 |
| ------------------- | ---- | ---------- | ---- |
| Read Uncommitted    | Y    | Y          | Y    |
| Read Committed      | N    | Y          | Y    |
| Repeatable(default) | N    | N          | Y    |
| Serializable        | N    | N          | N    |



#### Oracle



### (二)非关系型数据库(NoSQL)

#### Redis

##### 1. 概述

1. Redis使用C语言编写的，是一种非关系型的键值对数据库
2. 数据储存在内存中，读写速度快。
3. 可以储存键和五种不同类型的值之间的映射。

##### 2. 优缺点

优点

1. 数据存储在内存中，读写速度快，读的速度达到11万次/s，写的速度也有8.1万次/s
2. 支持数据库持久化，有AOF(Append Only File)和RDB(Redis DataBase)两种持久化方式
3. 跟MySQL一样，支持事务
4. 数据结构丰富，可以存储键和五种不同类型的值之间的映射 ，字符串(String)、哈希(hash)、列表(list)、集合(set)、有序集合(zset)
5. 支持主从复制，主机会自动将数据同步到从机，可以进行读写分离

缺点

1. 数据存储在内存，就会收到物理内存的限制。
2. 不具备自动容错和恢复功能。主机从机的宕机都会导致前端部分读写请求失败。
3. 比较难支持在线扩容。

##### 3. 使用场景

1. 计数器

 	可以对 String 进行自增自减运算，从而实现计数器功能。 

2. 缓存

​	将热点数据放到内存中，设置内存的最大使用量以及淘汰策略来保证缓存的命中率。 

3. 会话缓存

4. 全页缓存

5. 分布式锁实现

6. 消息队列(发布/订阅功能)

   List 是一个双向链表，可以通过 lpush 和 rpop 写入和读取消息

   不过最好使用 Kafka、RabbitMQ 等消息中间件。

##### 4. 持久化

1. Redis 是内存型数据库，为了之后重用数据（比如重启机器、机器故障之后回复数据），或者是为了防止系统故障而将数据备份到一个远程位置，需要将内存中的数据持久化到硬盘上。 
2. Redis 提供了RDB和AOF两种持久化方式。默认是只开启RDB，当Redis重启时，它会优先使用AOF文件来还原数据集。 

###### RDB 持久化(Redis DataBase)

1. RDB 持久化(快照持久化)：将某个时间点的所有数据都存放到硬盘上。 
2. 如果系统真的发生崩溃，用户将丢失最近一次生成快照之后更改的所有数据。因此，快照持久化只适用于即使丢失一部分数据也不会造成一些大问题的应用程序。不能接受这个缺点的话，可以考虑AOF持久化。 
3. 创建快照的办法有如下几种： 
   1.  BGSAVE命令
   2.  SAVE命令 

###### AOF 持久化(Append Only File)

1. AOF 持久化：将写命令添加到AOF文件（Append Only File）的末尾。  
2. 与快照持久化相比，AOF持久化 的实时性更好，因此已成为主流的持久化方案 
3. 配置文件中存在三种同步方式 
   1.  appendfsync always 
   2.  appendfsync everysec （推荐使用）
   3.  appendfsync no 

##### 5. 如何选择合适的持久化方式

1. 如果你非常关心你的数据， 但仍然可以承受数分钟以内的数据丢失，那么你可以只使用RDB持久化。
2. 一般来说， 如果想达到足以媲美PostgreSQL的数据安全性，你应该同时使用两种持久化功能。在这种情况下，当 Redis 重启的时候会优先载入AOF文件来恢复原始的数据，因为在通常情况下AOF文件保存的数据集要比RDB文件保存的数据集要完整。
3. 有很多用户都只使用AOF持久化，但并不推荐这种方式，因为定时生成RDB快照（snapshot）非常便于进行数据库备份， 并且 RDB 恢复数据集的速度也要比AOF恢复的速度要快，除此之外，使用RDB还可以避免AOF程序的bug。



#### MongoDB



## 四、框架

### (一)Spring

#### 1. 什么是Spring

1. Spring是一个轻量级Java开发框架，最根本的使命是解决企业级应用开发的复杂性
2. 有两大核心特性：控制反转（IOC）和面向切面编程（AOP）
3. 为了降低复杂性：采取4中关键策略
   1. 基于POJO（ Plain Ordinary Java Object 简单的Java对象 ）的轻量级和最小侵入性编程
   2. 通过依赖注入和面向接口实现松耦合
   3. 基于切面和惯例进行声明式编程
   4. 通过切面和模板减少样板式代码

#### 2. Spring的优缺点

优点：

1. 方便解耦、简化开发。可以将所有对象的创建和依赖关系的维护，交给Spring容器管理
2. AOP编程的支持。可以方便的实现对程序进行权限拦截、运行监控等功能
3. 集成了各种优秀框架，Hibernate、MyBatis等

缺点：

1. Spring依赖反射，反射会影响性能

#### 3. IOC

概念 ：

1. IOC(Inverse of Control)控制反转，它是一种设计思想。利用了Java的反射机制。本来被调用的对象实例是由调用者来创建的，现在统一交给Spring来处理。这样控制权的转移叫做控制反转。

优点：

1. 实现组件之间的解耦，提高程序的灵活性和可维护性

缺点：

1. 因为使用了反射机制，所以会有降低性能

##### 依赖注入（DI）：

1. 相对于IOC而言，依赖注入更加准确地描述了IOC的设计理念。所谓依赖注入（Dependency Injection），即组件之间的依赖关系由容器在应用系统运行期来决定，也就是由容器动态地将某种依赖关系的目标对象实例注入到应用系统中的各个关联的组件之中。组件不做定位查询，只提供普通的Java方法让容器去决定依赖关系。

#### 4. AOP

1. AOP(Aspect Oriented Programming)面向切面编程是对**OOP**(Object Orented Programming)面向对象编程的补充和完善。 在面向对象中，关注的单元是对象，而AOP关注的单元是切面。AOP减少系统中的重复代码，降低了模块间的耦合度，同时提高系统的可维护性。可用于权限、日志、事务处理等。 
2. 实现AOP技术主要分类两大类
   1. 采用动态代理技术，利用截取消息的方式，对该消息进行修饰，以取代原有对象行为的执行
   2. 采用的是静态织入的方式，引入特定的语法创建“方面”，从而使得编译器可以在编译期间织入有关”方面“的代码，属于静态代理。

#### 5. Spring模块组成

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019102923475419.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RoaW5rV29u,size_16,color_FFFFFF,t_70)

1. 数据访问与集成（Data Access/Integration）：JDBC、ORM、OXM、JMS、Transactions
2. Web: WebSocket、Servlet、Web、Portlet
3. 核心容器（core container）：Beans、Core、Context、SpEL
4. AOP、Aspects、设备支持（Instrmentation）、Messaging
5. Test

#### 6. Spring 框架中都用到的设计模式

1. 工厂模式：BeanFactory就是简单工厂模式的体现，用来创建对象的实例
2. 单例模式：Bean默认为单例模式
3. 代理模式：Spring的AOP功能就用到了JDK的动态代理
4. 模板模式：用来解决代码重复的问题。（对抽象类的多种继承）
5. 观察者模式： 定义对象键一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都会得到通知被制动更新 

#### 7. Spring框架中bean的生命周期

![深究Spring中Bean的生命周期](https://www.javazhiyin.com/wp-content/uploads/2019/05/java0-1558500658.jpg)

1. 对Bean进行实例化

2. 将Bean的属性注入

3. 调用BeanNameAware的setBeanName()方法

4. 调用BeanFactoryAware的setBeanFactory()方法

5. 调用ApplicationContextAware的setApplicationContext()方法

6. 调用BeanPostProcessor的预初始化方法

7. 调用InitialIzingBean的afterPropertiesSet()方法

8. 调用自定义初始化方法

9. 调用BeanPostProcessor的初始化后的方法

   --- Bean就可以被使用了

   ----当容器关闭后

10. 调用了DisposableBean的destroy()方法

11. 调用自定义销毁方法

12. 结束

#### 8. Spring AOP里面的几个名词

1.  切面（Aspect） ：切面是通知和切点的结合。
2.  连接点（Join point）：指方法
3.  通知（Advice）：切面的工作称为通知
4.  切点（Pointcut）:使用类或者方法的名称来指定切点
5.  引入（Introduction）：引入允许我们向现有的类添加新方法或者属性
6.  目标对象（Target object）：被一个或者多个切面通知的对象
7.  织入（Weaving）：织入是把切面应用到目标对象并创建新的代理对象的过程

#### 9. Spring通知有哪些类型

Spring切面可以应用5种类型的通知：

1. 前置通知（Before）：在目标方法被调用之前调用通知功能

2. 后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么

3. 返回通知（After-returning ）：在目标方法成功执行之后调用通知；

4. 异常通知（After-throwing）：在目标方法抛出异常后调用通知；

5. 环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为。

   

### (二) SpringMVC

#### 1. 什么是SpringMVC

1. 基于Java实现了MVC模式的轻量级web框架，通过把model-view-controller分离，将web进行职责解耦，把复杂的web应用分成逻辑清晰的几个部分，简化开发，方便组内开发人员之间的配合

#### 2. SpringMVC工作原理

1. 用户发送请求至前端控制器DispatcherServlet
2. DispatcherServlet收到请求后，调用HandlerMapping处理器映射器，请求获取Handle
3. 处理器映射器根据请求URL找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet
4. DispatcherServlet 调用 HandlerAdapter处理器适配器
5. HandlerAdapter 经过适配调用 具体处理器(Handler，也叫后端控制器)
6. Handler执行完成返回ModelAndView
7. HandlerAdapter将Handler执行结果ModelAndView返回给DispatcherServlet
8. DispatcherServlet将ModelAndView传给ViewResolver视图解析器进行解析
9. ViewResolver解析后返回具体View
10. DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）
11. DispatcherServlet响应用户

![img](https://img-blog.csdnimg.cn/20200208211439106.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RoaW5rV29u,size_16,color_FFFFFF,t_70)

#### 3. SpringMVC优点

1. 与Spring框架集成 （如IOC容器、AOP等） 
2. 清晰的角色分配：前端控制器（DispatcherServlet），请求到处理器映射器（HandlerMapping），处理器适配器（HandlerAdapter），视图解析器（ViewResolver）
3. 可以支持各种视图技术，而不仅局限于JSP

#### 4. SpringMVC的主要组件

1. 前端控制器DispatcherServlet

   作用：接收请求、响应结果，相当于转发器。

2. 处理器映射器HandlerMapping

   作用：根据请求的URL来查找Handler

3. 处理器适配器HandlerAdapter

4. 处理器Handler

5. 视图解析器 ViewResolver

   作用： 进行视图的解析，根据视图逻辑名解析成真正的视图（view） 

6. 视图View

#### 5. Spring MVC重定向和转发

1. 重定向：redirect
2. 转发：forward

#### 6. SpringMVC的两个Context

1. Servlet WebApplicationContext
2. Root WebApplicationContext

#### 7. SpringMVC常用注解

1. @RequestMapping：用于处理请求URL映射的注解
2. @RequestBody：实现接收Http请求的JSON数据，将JSON转换为Java对象
3. @ResponseBody：实现将Controller方法返回的对象转换位JSON对象
4. @RestController ：相当于@Controller+@ResponseBody



### (三)MyBatis

#### 1. 什么是MyBatis

是一款优秀的持久层框架，一个半ORM框架，支持定制化SQL、储存过程一级高级映射

#### 2. 什么是ORM

ORM(Object Relational Mapping)，对象关系映射，是一种为了解决关系型数据库数据与POJO的映射关系的技术

#### 3. MyBatis优缺点

优点：

1. 基于SQL语句编程，灵活性高
2. SQL写在XML里，解除SQL与程序代码的耦合，便于管理。并且提供XML标签，支持动态编写SQL语句。
3. 很好的雨各种数据库兼容
4. 能够与Spring很好的集成

缺点：

1. SQL语句的编写工作量较大，尤其字段多的时候
2. SQL语句依赖于数据库，导致数据库移植性查，不能随意更换数据库

#### 4. MyBatis编程步骤

1. 创建SqlSessionFactory
2. 通过SqlSessionFactory创建SqlSession
3. 通过SqlSession执行数据库操作
4. 通过session.commit()提交事务
5. 通过session.close()关闭事务

#### 5. 映射器

##### 为什么需要预编译

1. 预编译后的SQL可以直接执行，不需要DBMS再次编译
2. 防止SQL注入
3. MyBatis默认对所有的SQL进行预编译

##### #{}和${}的区别

1. #{}是占位符，有预编译处理；${}是拼接符，字符串替换，没有预编译处理
2. #{}可以有效的防止SQL注入，提高系统安全性；${}不能防止SQL注入
3. 变量替换后，#{}对应的变量自动加上单引号；而${}对应的变量不会加上单引号
4. #{}传入参数是以字符串传入，会将#{}替换成？，调用PreparedStatement的set方法来赋值
5. #{} 的变量替换是在DBMS 中；${} 的变量替换是在 DBMS 外 

##### 模糊查询like语句

​	concat('%', #{keyword}, '%')

##### 在mapper中如何传递多个参数

   	1. @Param注解传参法
              	2.  Map传参法 

 	2. Java Bean传参法

#### 6. 如何获取生成的主键

```xml
useGeneratedKeys="true" keyProperty="id"
```



### (四)Hibernate



### (五)SSM



### (六)SSH



### (七)Shiro



### (八)Spring Security



### (九)Netty



## 五、微服务

#### 什么是微服务

1. 它是一种架构风格，一个大型复杂的系统可以由一个或者多个微服务组成。
2. 系统中的各个服务都可以被单独部署，它们之间是松耦合的。

### (一)SpringBoot

#### 1. 什么是SpringBoot

SpringBoot是Spring组织下的子项目，主要是简化了Spring的难度，减省了繁重的配置，提供了各种启动器，方便快速上手

#### 2. SpringBoot的优缺点

优点：

1. 开箱即用，少了繁琐的配置过程
2. 避免大量的Maven导入和各种版本冲突
3. SpringBoot内嵌了Tomcat，简化了部署

#### 3. Spring Boot 的核心注解

1. 启动类上的注解是@SpringBootApplication，包含：

   1. @SpringBootConfiguration：实现配置文件功能
   2. @EnableAutoConfiguration：打开自动配置功能，也可以关闭某个自动配置的选项
   3. @ComponentScan: Spring组件扫描

#### 4. 什么是 WebSockets

WebSocket 是一种计算机通信协议，通过单个 TCP 连接提供全双工通信信道。

1. WebSocket 是双向的 -使用 WebSocket 客户端或服务器可以发起消息发送。

2. WebSocket 是全双工的 -客户端和服务器通信是相互独立的。

3. 单个 TCP 连接 -初始连接使用 HTTP，然后将此连接升级到基于套接字的连接。然后这个单一连接用于所有未来的通信

4. Light -与 Http相比，WebSocket 消息数据交换要轻得多。

   

### (二)SpringCloud



## 六、中间件

### (一)消息中间件

[消息队列]: https://blog.csdn.net/lzghxjt/article/details/83011239

##### 1. 概述

1. 消息队列中间件是分布式系统中重要的组件，主要用于：**异步**处理，应用**解耦**，消息通讯，流量削锋等问题，实现高性能，高可用，可伸缩和最终一致性架构。目前使用较多的消息队列有ActiveMQ，RabbitMQ ，RocketMQ，ZeroMQ，Kafka，MetaMQ。 

##### 2. 消息模型

JMS（JAVA Message Service，Java消息服务）API是一个消息服务的标准/规范，允许应用程序组件基于JavaEE平台创建、发送、接收和读取消息。它使分布式通信耦合度更低，消息服务更加可靠以及异步性。在EJB架构中，有消息bean可以无缝的与JM消息服务集成。在J2EE架构模式中，有消息服务者模式，用于实现消息与应用直接的解耦。在JMS标准中，有两种消息模型：点对点（Point to Point简称P2P），发布/订阅(Publish/Subscribe简称Pub/Sub)。 

###### 1. P2P模式

1. P2P模式包含三个角色：发送者(Sender)，消息队列（Queue），接收者(Receiver)。每个消息都被发送到一个特定的队列，接收者从队列中获取消息。队列保留着消息，直到他们被消费或超时。如果希望发送的每个消息都会被成功处理的话，那么需要P2P模式。

2. P2P的特点：
   1 > 每个消息只有一个消费者（Consumer）（即一旦被消费，消息就不再在消息队列中）；
   2 > 发送者和接收者之间在时间上没有依赖性，也就是说当发送者发送了消息之后，不管接收者有没有正在运行，它不会影响到消息被发送到队列；
   3 > 接收者在成功接收消息之后需向队列应答成功； 

######  2. Pub/Sub模式 

1. Pub/Sub模式包含三个角色：发布者（Publisher），主题（Topic），订阅者（Subscriber），多个发布者将消息发送到Topic，系统将这些消息传递给多个订阅者。如果希望发送的消息既可以不被处理、也可只被一个消费者处理、还可以被多个消费者处理的话，那么可以采用Pub/Sub模型。 

2. Pub/Sub的特点：
      1 > 每个消息可以有多个消费者；
      2 > 发布者和订阅者之间有时间上的依赖性。针对某个主题（Topic）的订阅者，它必须创建一个订阅者之后，才能消费发布者的消息；为了缓和这样严格的时间相关性，JMS允许订阅者创建一个可持久化的订阅。这样即使订阅者没有被激活（运行），它也能接收到发布者的消息。
      3 > 为了消费消息，订阅者必须保持运行的状态 

   

#### 1.  RabbitMQ



#### 2.  RocketMQ



#### 3. ActiveMQ



#### 4. Kafka



### (二)Web应用服务器

#### 1. Tomcat



#### 2. Nginx



### (三)分布式

#### 1.  Zookeeper



## 七、并发编程



## 八、异常机制



## 九、设计模式

### 1. 单例模式

1. 饿汉式

   ```java
   public class SingletonDemo{
       private SingletonDemo(){}
       private static SingletonDemo instance = new SingletonDemo();
       public static SingletonDemo getInstance(){
           return instance;
       }
   }
   ```

2. 懒汉式

   普通版：线程不安全

   ```java
   public class SingletonDemo{
       private SingletonDemo(){}
       private static SingletonDemo instance = null;
       public static SingletonDemo getInstance(){
           if(instance == null){
               instance = new SingletonDemo();
           }
           return instance;
       }
   }
   ```

   加锁

   ```java
   public class SingletonDemo{
       private SingletonDemo(){}
       private static SingletonDemo instance = null;
       public static synchronized SingletonDemo getInstance(){
           if(instance == null){
               instance = new SingletonDemo();
           }
           return instance;
       }
   }
   ```

   双重锁

   ```java
   pubcli class SingletonDemo{
       private SingletonDemo(){}
       private static SingletonDemo instatnce = null;
       public static SingletonDemo getInstance(){
           if(instance == null){
               synchronized(SingletonDemo.class){
                   if(instance == null){
                   instance = new SingletonDemo();
               }
             }
           }
           return instance
       }
   }
   ```

   内部静态类（推荐）

   ```java
   public class SingletonDemo{
       private SingletonDemo(){}
       private static class SingletonStatic(){
           private static SingletonDemo instance = new SingletonDemo();
       }
       public static SingletonDemo getInstance(){
           return SingletonStatic.instance;
       }
   }
   ```




## 十、算法

### (一) 排序

![img](https://img-blog.csdn.net/201807222219527?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zODMzMzU1NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 1. 冒泡排序

```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
```

#### 2. 选择排序

![img](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif)

```java 
public class SelectSort {
    public static void selectSort(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
```

#### 3. 插入排序

![img](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015225645277-1151100000.gif)

```java
public class InsertSort {
    public static void insertSort(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return;
        }
        int current;
        for (int i = 0; i < length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
       }
    }
}
```



​	



# 前端

## 一、HTML(5)



## 二、CSS(3)



## 三、JavaScript(ES6+)



## 四、框架



### 1. Vue



### 2. React



## 五、工具类



### 1. JQuery



### 2. BootStrap















