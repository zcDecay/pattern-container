package com.newt.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时,所有依赖于它的对象都得到通知并被自动更新。
 */
public class ObserverRun {

  /**
   * 适用性：
   *     1.当一个抽象模型有两个方面,其中一个方面依赖于另一方面。
   *       将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。
   *
   *     2.当对一个对象的改变需要同时改变其它对象,而不知道具体有多少对象有待改变。
   *
   *     3.当一个对象必须通知其它对象，而它又不能假定其它对象是谁。
   * 参与者：
   *     1.Subject（目标）
   *       目标知道它的观察者。可以有任意多个观察者观察同一个目标。
   *       提供注册和删除观察者对象的接口。
   *
   *     2.Observer（观察者）
   *       为那些在目标发生改变时需获得通知的对象定义一个更新接口。
   *
   *     3.ConcreteSubject（具体目标）
   *       将有关状态存入各ConcreteObserver对象。
   *       当它的状态发生改变时,向它的各个观察者发出通知。
   *
   *     4.ConcreteObserver（具体观察者）
   *       维护一个指向ConcreteSubject对象的引用。
   *       存储有关状态，这些状态应与目标的状态保持一致。
   *       实现Observer的更新接口以使自身状态与目标的状态保持一致
   *
   */
  public static void main(String[] args) {
    Policeman thPol = new TianHePoliceman();
    Policeman hpPol = new HuangPuPoliceman();

    Citizen citizen = new HuangPuCitizen(hpPol);
    citizen.sendMessage("unnormal");
    citizen.sendMessage("normal");

    System.out.println("===========");

    citizen = new TianHeCitizen(thPol);
    citizen.sendMessage("normal");
    citizen.sendMessage("unnormal");

  }
}

abstract class Citizen {

  List<Policeman> pols;

  String help = "normal";

  public void setHelp(String help) {
    this.help = help;
  }

  public String getHelp() {
    return this.help;
  }

  abstract void sendMessage(String help);

  public void setPolicemen() {
    this.pols = new ArrayList();
  }

  public void register(Policeman pol) {
    this.pols.add(pol);
  }

  public void unRegister(Policeman pol) {
    this.pols.remove(pol);
  }
}

interface Policeman {

  void action(Citizen ci);
}

class HuangPuCitizen extends Citizen {

  public HuangPuCitizen(Policeman pol) {
    setPolicemen();
    register(pol);
  }

  @Override
  public void sendMessage(String help) {
    setHelp(help);
    for (int i = 0; i < pols.size(); i++) {
      Policeman pol = pols.get(i);
      //通知警察行动
      pol.action(this);
    }
  }
}

class TianHeCitizen extends Citizen {

  public TianHeCitizen(Policeman pol) {
    setPolicemen();
    register(pol);
  }

  @Override
  public void sendMessage(String help) {
    setHelp(help);
    for (int i = 0; i < pols.size(); i++) {
      Policeman pol = pols.get(i);
      //通知警察行动
      pol.action(this);
    }
  }
}

class HuangPuPoliceman implements Policeman {

  @Override
  public void action(Citizen ci) {
    String help = ci.getHelp();
    if (help.equals("normal")) {
      System.out.println("一切正常, 不用出动");
    }
    if (help.equals("unnormal")) {
      System.out.println("有犯罪行为, 黄埔警察出动!");
    }
  }
}

class TianHePoliceman implements Policeman {

  @Override
  public void action(Citizen ci) {
    String help = ci.getHelp();
    if (help.equals("normal")) {
      System.out.println("一切正常, 不用出动");
    }
    if (help.equals("unnormal")) {
      System.out.println("有犯罪行为, 天河警察出动!");
    }
  }
}
