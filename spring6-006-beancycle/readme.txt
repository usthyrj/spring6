Bean生命周期五步：
    1. 实例化Bean
    2. 属性赋值
    3. 初始化
    4. 使用
    5. 销毁

Bean生命周期七步（在初始化bean前后添加两步）：
    1. 实例化Bean
    2. 属性赋值
    3. 执行Bean后处理器的before方法
    4. 初始化
    5. 执行after方法
    6. 使用
    7. 销毁

Bean生命周期十步（后处理器beafore前后添加两步， 在使用bean后添加一步）：
    1. 实例化Bean
    2. 属性赋值
       检查Bean是否实现了Aware的相关接口，并设置了相关依赖
    3. 执行Bean后处理器的before方法
       检查Bean是否实现了InitializingBean接口，并调用其方法。
    4. 初始化
    5. 执行after方法
    6. 使用
       检查Bean是否实现了DisposableBean接口，并调用其方法
    7. 销毁