package com.newt.pattern.factory;


/**
 * 工厂方法
 *    定义一个用于创建对象的接口，让子类决定实例化那个类，FactoryMethod使一个类的实例化延迟到其子类
 */
public class FactoryMethodRun {

    /**
     * 1.当一个类不知道它所必须创建的对象的类的时候。
     * 2.当一个类希望由它的子类来指定它所创建的对象的时候。
     * 3.当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者这一信息局部化的时候。
     */
    public static void main(String[] args) {
        IWorkFactory studentWorkFactory = new StudentWorkFactory();
        studentWorkFactory.getWork().doWork();

        IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        teacherWorkFactory.getWork().doWork();

    }


}

interface Work {

    void doWork();
}

class StudentWork implements Work {

    @Override
    public void doWork() {
        System.out.println("学生做作业!");
    }

}

class TeacherWork implements Work {

    @Override
    public void doWork() {
        System.out.println("老师审批作业!");
    }

}

interface IWorkFactory {

    Work getWork();
}

class StudentWorkFactory implements IWorkFactory {

    @Override
    public Work getWork() {
        return new StudentWork();
    }

}

class TeacherWorkFactory implements IWorkFactory {

    @Override
    public Work getWork() {
        return new TeacherWork();
    }

}

