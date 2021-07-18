package com.Iven.Dao;

public class ServiceInterfaceImpl implements ServiceInterface {
    @Override
    public void demo01() {
        System.out.println("由Spring容器代替开发人员完成对象的创建");
    }
}
