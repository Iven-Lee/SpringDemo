package com.Iven;

import static org.junit.Assert.assertTrue;

import com.Iven.AOPDemo.SomeService;
import com.Iven.ComponetDi.student01;
import com.Iven.Dao.ServiceInterface;
import com.Iven.SetDI.SetDi;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * demo01
     * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件中的所有的对象。
     * spring创建对象：默认调用的是无参数构造方法
     * 底层：反射机制
     * 基于XML<bean>标签
     * 对应包com.Iven.Dao
     * <bean>标签SpringBeans.xml
     */
    @Test
    public void demo01(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config="SpringBeans.xml";
        //2.创建表示spring容器的对象， ApplicationContext
        // ApplicationContext就是表示Spring容器，通过容器获取对象了
        // ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取某个对象， 你要调用对象的方法（接口）
        //getBean("配置文件中的bean的id值")
        //<bean id="someService" class="com.Iven.Dao.ServiceInterfaceImpl" />
        ServiceInterface service = (ServiceInterface ) ac.getBean("someService");

        //使用spring创建好的对象
        service.demo01();
    }
    /**
     * demo02
     * 基于XML<bean>标签完成属性set注入（简单类型与引用类型）
     * 对应包com.Iven.SetDI
     * <bean>标签SpringBeans.xml
     */
    @Test
    public void demo02(){
        String config="SpringBeans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        SetDi myStudent =  (SetDi) ac.getBean("myStudent");
        System.out.println("student对象="+myStudent);

    }
    /**
     * demo03
     * 基于XML<bean>标签完成属性构造注入（spring调用有参构造）
     * 对应包com.Iven.SetDI
     * <bean>标签SpringBeans.xml
     */
    @Test
    public void demo03(){
        String config="SpringBeans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        SetDi myStudent =  (SetDi) ac.getBean("setDi");
        System.out.println("student对象="+myStudent);

    }
    /**
     * demo04
     * 基于注解的DI实现
     * 基本数据类型@Value、引用数据类型@Autowired
     * 对应包com.Iven.ComponetDi
     * 注解配置文件：ComponetDi/applicationContext.xml
     * 属性配置文件ComponetDi/test.properties属性配置文件
     * 组件扫描器<component-scan>的标签，指名注解在项目中的位置
     * 属性配置文件标签：<context:property-placeholder location="" />
     */
    @Test
    public void demo04(){
        String config="ComponetDi/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        student01 myStudent =  (student01) ac.getBean("myStudent");
        System.out.println("student对象="+myStudent);
    }
    /**
     * demo05
     * AOP实现
     * 1）前置通知@Before
     * 2）后置通知@AfterReturning
     * 3）环绕通知@Around
     * 4）异常通知@AfterThrowing
     * 5）最终通知@After
     * 目标类：com.Iven.AOPDemo.SomeServiceImpl
     * 切面类：com.Iven.AOPDemo.MyAspectj
     * AOP配置文件：AOPresource/applicationContext.xml
     */
    @Test
    public void demo05(){
        String config="AOPresource/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        System.out.println("proxy:"+proxy.getClass().getName());
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        proxy.doSome("lisi",20);
    }
}
