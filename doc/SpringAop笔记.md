1. Spring AOP和AspectJ的区别
> 连接点区别：  
> Spring AOP:   1.方法级别   
> AspectJ:      1. 方法级别  2. 字段  3.构造器
>
> 织入区别：
> Spring AOP是在【运行期】通过动态代理织入的
> AspectJ可以在编译期和类加载期织入

Tip: Spring AOP虽然使用了AspectJ的注解，不过这只是借用注解, 实际上仍然使用的是SpringAop的动态代理
