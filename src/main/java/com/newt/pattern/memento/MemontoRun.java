package com.newt.pattern.memento;

/**
 * 备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
 */
public class MemontoRun {

  /***
   * 适用性：
   *     1.必须保存一个对象在某一个时刻的(部分)状态,这样以后需要时它才能恢复到先前的状态。
   *
   *     2.如果一个用接口来让其它对象直接得到这些状态，将会暴露对象的实现细节并破坏对象的封装性。
   * 参与者：
   *     1.Memento
   *       备忘录存储原发器对象的内部状态。
   *
   *     2.Originator
   *       原发器创建一个备忘录,用以记录当前时刻它的内部状态。
   *       使用备忘录恢复内部状态.
   *
   *     3.Caretaker
   *       负责保存好备忘录。
   *       不能对备忘录的内容进行操作或检查。
   *
   *
   */
  public static void main(String[] args) {
    Originator org = new Originator();
    org.setState("开会中");

    Caretaker ctk = new Caretaker();
    ctk.setMemento(org.createMemento());//将数据封装在Caretaker

    org.setState("睡觉中");
    org.showState();//显示

    org.setMemento(ctk.getMemento());//将数据重新导入
    org.showState();

  }


}

class Memento {

  private String state;

  public Memento(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}

class Originator {

  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Memento createMemento() {
    return new Memento(state);
  }

  public void setMemento(Memento memento) {
    state = memento.getState();
  }

  public void showState() {
    System.out.println(state);
  }
}

class Caretaker {

  private Memento memento;

  public Memento getMemento() {
    return this.memento;
  }

  public void setMemento(Memento memento) {
    this.memento = memento;
  }
}
