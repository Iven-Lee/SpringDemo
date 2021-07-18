package com.Iven.ComponetDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Component: 创建对象的， 等同于<bean>的功能
 *     属性：value 就是对象的名称，也就是bean的id值，
 *          value的值是唯一的，创建的对象在整个spring容器中就一个
 *     位置：在类的上面
 *
 *  @Component(value = "myStudent")等同于
 *   <bean id="myStudent" class="com.Iven.ComponetDi.student01" />
 *
 *  spring中和@Component功能一致，创建对象的注解还有：
 *  1.@Repository（用在持久层类的上面） : 放在dao的实现类上面，
 *               表示创建dao对象，dao对象是能访问数据库的。
 *  2.@Service(用在业务层类的上面)：放在service的实现类上面，
 *              创建service对象，service对象是做业务处理，可以有事务等功能的。
 *  3.@Controller(用在控制器的上面)：放在控制器（处理器）类的上面，创建控制器对象的，
 *              控制器对象，能够接受用户提交的参数，显示请求的处理结果。
 *  以上三个注解的使用语法和@Component一样的。 都能创建对象，但是这三个注解还有额外的功能。
 *  @Repository，@Service，@Controller是给项目的对象分层的。
 *
 *
 */
//使用value属性，指定对象名称
//@Component(value = "myStudent")

//省略value
@Component("myStudent")
//等价于<bean id="myStudent" class="com.Iven.ComponetDi.student01" />

//不指定对象名称，由spring提供默认名称: 类名的首字母小写
//@Component
public class student01 {
    /**
     * @Value: 简单类型的属性赋值
     *   属性： value 是String类型的，表示简单类型的属性值
     *   位置： 1.在属性定义的上面，无需set方法，推荐使用。
     *         2.在set方法的上面
     */
    @Value("Iven")
    private String name;
    //@Value("22")
    @Value("${myage}")  //使用ComponetDi/test.properties属性配置文件中的数据
    private Integer age;
    @Autowired
    private SchoolDemo schoolDemo;
    /**
     * 引用类型
     * @Autowired: spring框架提供的注解，实现引用类型的赋值。
     * spring中通过注解给引用类型赋值，使用的是自动注入原理 ，支持byName, byType
     * @Autowired:默认使用的是byType自动注入。
     *
     *   属性：required ，是一个boolean类型的，默认true
     *       required=true：表示引用类型赋值失败，程序报错，并终止执行。
     *       required=false：引用类型如果赋值失败， 程序正常执行，引用类型是null
     *
     *  位置：1）在属性定义的上面，无需set方法， 推荐使用
     *       2）在set方法的上面
     *
     *  如果要使用byName方式，需要做的是：
     *  1.在属性上面加入@Autowired
     *  2.在属性上面加入@Qualifier(value="bean的id") ：表示使用指定名称的bean完成赋值。
     */
    /**
     * 引用类型
     * @Resource: 来自jdk中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
     *            使用的也是自动注入原理，支持byName， byType .默认是byName
     *  位置： 1.在属性定义的上面，无需set方法，推荐使用。
     *        2.在set方法的上面
     * //默认是byName： 先使用byName自动注入，如果byName赋值失败，再使用byType
     */

    /**
     * 方法一（自动注入）
     * 默认使用的是byType自动注入
     * @Override
    */
    /**
     * 方法二
     * 使用byName方式（com.Iven.ComponetDi.SchoolDemo）
     * @Override
     * @Qualifier("schoolD")
     */
    /**
     * 方法三
     * 默认是byName： 先使用byName自动注入，如果byName赋值失败，再使用byType
     * @Resource
     */
    @Override
    public String toString() {
        return "student01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", schoolDemo=" + schoolDemo +
                '}';
    }

    public SchoolDemo getSchoolDemo() {
        return schoolDemo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSchoolDemo(SchoolDemo schoolDemo) {
        this.schoolDemo = schoolDemo;
    }

    public student01() {
    }

    public student01(String name, Integer age, SchoolDemo schoolDemo) {
        this.name = name;
        this.age = age;
        this.schoolDemo = schoolDemo;
    }


}
