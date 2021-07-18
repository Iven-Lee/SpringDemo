package com.Iven.SetDI;
//简单类型的set注入
//引用类型的set注入
//构造注入
public class SetDi {
    private String name;
    private Integer age;
    private School school;

    @Override
    public String toString() {
        return "SetDi{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public SetDi(String name, Integer age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SetDi() {
    }

    public SetDi(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
