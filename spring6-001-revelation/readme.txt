1. OCP
    what:
        开闭原则：对扩展开放、对修改关闭。
    OCP是最核心最基本的原则，其他的六个原则都是为他服务的。
    核心：
        扩展系统功能时没有修改以前的写法，则符合OCP。

2. DIP
    what:
        依赖倒置原则：上依赖下都违背了依赖倒置原则，上不再依赖下则符合DIP
    DIP核心：
        面向接口编程、面向抽象编程。

3. 当前程序既违背OCP又违背DIP,how?
    ans:采用控制反转（IoC）思想

4. IoC
    反转的是什么？
        1.不在程序中硬编码new对象。
        2.不在程序中硬编码维护对象关系。
    IoC是一种编程思想，因为比较新，未被纳入GoF23中

5. Spring框架
    实现了IoC
        可new对象以及维护对象关系
        Spring是一个实现了IoC思想的容器
    IoC实现方式有多种，最重要的是DI
    DI的两种常见方式：
        1.set注入
        2.构造器注入
    DI的D? I?
        Dependency：两对象的关系
        Injection：让两对象产生关系的手段















