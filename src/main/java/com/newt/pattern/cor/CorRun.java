package com.newt.pattern.cor;

/**
 * 职责链模式：
 *     使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，
 *     并沿着这条链传递该请求，直到有一个对象处理它为止。
 *
 *     这一模式的想法是，给多个对象处理一个请求的机会，从而解耦发送者和接受者.
 */
public class CorRun {

  /**
   * 适用性：
   *     1.有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定。
   *
   *     2.你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
   *
   *     3.可处理一个请求的对象集合应被动态指定。
   * 参与者：
   *     1.Handler
   *       定义一个处理请求的接口。
   *       （可选）实现后继链。
   *
   *     2.ConcreteHandler
   *       处理它所负责的请求。
   *       可访问它的后继者。
   *       如果可处理该请求，就处理之；否则将该请求转发给它的后继者。
   *
   *     3.Client
   *       向链上的具体处理者(ConcreteHandler)对象提交请求。
   *
   */
  public static void main(String[] args) {
    RequestHandle hr = new HRRequestHandle();
    RequestHandle pm = new PMRequestHandle(hr);

    //team leader处理离职请求
    Request request = new DimissionRequest();
    hr.handleRequest(request);

    System.out.println("===========");
    //team leader处理加薪请求
    request = new AddMoneyRequest();
    pm.handleRequest(request);
  }
}
interface RequestHandle {
  void handleRequest(Request request);
}
class HRRequestHandle implements RequestHandle {

  @Override
  public void handleRequest(Request request) {
    if (request instanceof DimissionRequest) {
      System.out.println("要离职, 人事审批!");
    }

    System.out.println("请求完毕");
  }
}
class PMRequestHandle implements RequestHandle {

  RequestHandle rh;

  public PMRequestHandle(RequestHandle rh) {
    this.rh = rh;
  }

  @Override
  public void handleRequest(Request request) {
    if (request instanceof AddMoneyRequest) {
      System.out.println("要加薪, 项目经理审批!");
    } else {
      rh.handleRequest(request);
    }
  }
}

interface Request{
  void myRequest();
}

class DimissionRequest implements Request{
  @Override
  public void myRequest() {
    System.out.println("请求Dimission");
  }
}

class AddMoneyRequest implements Request{
  @Override
  public void myRequest() {
    System.out.println("请求AddMoney");
  }
}