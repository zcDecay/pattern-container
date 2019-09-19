package com.newt.pattern.template;

/**
 * 模版方法： 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。 TemplateMethod使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 */
public class TemplateMethodRun {

  /**
   * 适用性：
   *     1.一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
   *
   *     2.各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。
   *       首先识别现有代码中的不同之处，并且将不同之处分离为新的操作。
   *       最后，用一个调用这些新的操作的模板方法来替换这些不同的代码。
   *
   *     3.控制子类扩展。
   * 参与者：
   *     1.AbstractClass
   *       定义抽象的原语操作（primitiveoperation），具体的子类将重定义它们以实现一个算法的各步骤。
   *       实现一个模板方法,定义一个算法的骨架。
   *       该模板方法不仅调用原语操作，也调用定义在AbstractClass或其他对象中的操作。
   *
   *     2.ConcreteClass
   *       实现原语操作以完成算法中与特定子类相关的步骤。
   *
   */
  public static void main(String[] args) {
    Template temp = new TemplateConcrete();
    temp.update();
  }

}

abstract class Template {

  public abstract void print();

  public void update() {
    System.out.println("开始打印");
    for (int i = 0; i < 10; i++) {
      print();
    }
  }
}

class TemplateConcrete extends Template {

  @Override
  public void print() {
    System.out.println("这是子类的实现");
  }
}
