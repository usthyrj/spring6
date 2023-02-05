源码分析：
DefaultSingletonBeanRegistry类中有三个缓存：
    private final Map<String, Object> singletonObjects              //一级缓存
    private final Map<String, Object> earlySingletonObjects         //二级缓存
    private final Map<String, ObjectFactory<?>> singletonFactories  //三级缓存

    这三个map集合的key存储的都是bean的id

    一级缓存存储的是完整的单例bean对象，这个缓存中的bean对象都已经赋值了，是一个完整的bean
    二级缓存存储的是早期单例bean对象，这个缓存中的单例bean对象没有赋值，只是一个早期的实例对象
    三级缓存存储的是造早期单例bean对象的工厂对象，，这里面存储了大量的工厂对象，每个单例对象都会对应一个单例工厂对象

