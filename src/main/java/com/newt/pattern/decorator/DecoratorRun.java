package com.newt.pattern.decorator;

/**
 * 装饰模式： 动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。
 */
public class DecoratorRun {

  /***
   * 适用性
   *     1.在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
   *     2.处理那些可以撤消的职责。
   *     3.当不能采用生成子类的方法进行扩充时。
   * 参与者：
   *    1.Component
   *       定义一个对象接口，可以给这些对象动态地添加职责。
   *     2.ConcreteComponent
   *       定义一个对象，可以给这个对象添加一些职责。
   *     3.Decorator
   *       维持一个指向Component对象的指针，并定义一个与Component接口一致的接口。
   *     4.ConcreteDecorator
   *       向组件添加职责。
   */
  public static void main(String[] args) {
    Man man = new Man();
    ManDecoratorA md1 = new ManDecoratorA();
    ManDecoratorB md2 = new ManDecoratorB();

    md1.setPerson(man);
    md2.setPerson(md1);
    md2.eat();

  }
}

interface Person {

  void eat();
}

class Man implements Person {

  @Override
  public void eat() {
    System.out.println("男人在吃");
  }
}

abstract class Decorator implements Person {

  protected Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  public void eat() {
    person.eat();
  }
}

class ManDecoratorA extends Decorator {

  @Override
  public void eat() {
    super.eat();
    reEat();
    System.out.println("ManDecoratorA类");
  }

  public void reEat() {
    System.out.println("再吃一顿饭");
  }
}

class ManDecoratorB extends Decorator {

  @Override
  public void eat() {
    super.eat();
    System.out.println("===============");
    System.out.println("ManDecoratorB类");
  }
}
