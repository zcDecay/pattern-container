package com.newt.pattern.command;

/**
 * 命令模式： 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤消的操作。
 */
public class CommandRun {

  /**
   * 适用性：
   *     1.抽象出待执行的动作以参数化某对象。
   *
   *     2.在不同的时刻指定、排列和执行请求。
   *
   *     3.支持取消操作。
   *
   *     4.支持修改日志，这样当系统崩溃时，这些修改可以被重做一遍。
   *
   *     5.用构建在原语操作上的高层操作构造一个系统。
   * 参与者：
   *     1.Command
   *       声明执行操作的接口。
   *
   *     2.ConcreteCommand
   *       将一个接收者对象绑定于一个动作。
   *       调用接收者相应的操作，以实现Execute。
   *
   *     3.Client
   *       创建一个具体命令对象并设定它的接收者。
   *
   *     4.Invoker
   *       要求该命令执行这个请求。
   *
   *     5.Receiver
   *       知道如何实施与执行一个请求相关的操作。任何类都可能作为一个接收者。
   *
   */
  public static void main(String[] args) {
    Receiver rec = new Receiver();
    Command cmd = new CommandImpl(rec);
    Invoker i = new Invoker();
    i.setCommand(cmd);
    i.execute();

  }

}

abstract class Command {

  protected Receiver receiver;

  public Command(Receiver receiver) {
    this.receiver = receiver;
  }

  public abstract void execute();
}

class CommandImpl extends Command {

  public CommandImpl(Receiver receiver) {
    super(receiver);
  }

  @Override
  public void execute() {
    receiver.receive();
  }
}

class Invoker {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void execute() {
    command.execute();
  }
}

class Receiver {

  public void receive() {
    System.out.println("This is Receive class!");
  }
}
