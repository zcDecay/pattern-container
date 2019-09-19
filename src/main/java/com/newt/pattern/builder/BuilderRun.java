package com.newt.pattern.builder;


/**
 * 构造者模式
 *  将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 */
public class BuilderRun {

  /**
   * 1.当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
   * 2.当构造过程必须允许被构造的对象有不同的表示时。
   */
  /**
   * 参与者： Builder：为创建一个Product对象的各个部件指定抽象接口。 ConcreteBuilder： 实现Builder的接口以构造和装配该产品的各个部件。
   * 定义并明确它所创建的表示。 提供一个检索产品的接口。 Director：构造一个使用Builder接口的对象。 Product：
   * 表示被构造的复杂对象。ConcreteBuilder创建该产品的内部表示并定义它的装配过程。 包含定义组成部件的类，包括将这些部件装配成最终产品的接口。
   *
   * @author knys
   */
  public static void main(String[] args) {
    PersonDirector pd = new PersonDirector();
    Person person = pd.constructPerson(new ManBuilder());
    System.out.println(person.getBody());
    System.out.println(person.getFoot());
    System.out.println(person.getHead());
  }
}

interface PersonBuilder {

  void buildHead();

  void buildBody();

  void buildFoot();

  Person buildPerson();
}

class ManBuilder implements PersonBuilder {

  Person person;

  public ManBuilder() {
    person = new Man();
  }

  @Override
  public void buildBody() {
    person.setBody("建造人的身体");
  }

  @Override
  public void buildFoot() {
    person.setFoot("建造人的脚");
  }

  @Override
  public void buildHead() {
    person.setHead("建造人的头");
  }

  @Override
  public Person buildPerson() {
    return person;
  }
}

class PersonDirector {

  public Person constructPerson(PersonBuilder pb) {
    pb.buildHead();
    pb.buildBody();
    pb.buildFoot();
    return pb.buildPerson();
  }
}

class Person {

  private String head;

  private String body;

  private String foot;

  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getFoot() {
    return foot;
  }

  public void setFoot(String foot) {
    this.foot = foot;
  }
}

class Man extends Person {

}
