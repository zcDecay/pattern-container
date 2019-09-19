package com.newt.pattern.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * 解释器命令：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 */
public class InterpreterRun {

  /**
   * 适用性：
   *     当有一个语言需要解释执行,并且你可将该语言中的句子表示为一个抽象语法树时，可使
   *     用解释器模式。而当存在以下情况时该模式效果最好：
   *
   *     1.该文法简单对于复杂的文法,文法的类层次变得庞大而无法管理。
   *
   *     2.效率不是一个关键问题最高效的解释器通常不是通过直接解释语法分析树实现的,而是首先将它们转换成另一种形式。
   * 参与者：
   *    1.AbstractExpression(抽象表达式)
   *       声明一个抽象的解释操作，这个接口为抽象语法树中所有的节点所共享。
   *
   *     2.TerminalExpression(终结符表达式)
   *       实现与文法中的终结符相关联的解释操作。
   *       一个句子中的每个终结符需要该类的一个实例。
   *
   *     3.NonterminalExpression(非终结符表达式)
   *       为文法中的非终结符实现解释(Interpret)操作。
   *
   *     4.Context（上下文）
   *       包含解释器之外的一些全局信息。
   *
   *     5.Client（客户）
   *       构建(或被给定)表示该文法定义的语言中一个特定的句子的抽象语法树。
   *       该抽象语法树由NonterminalExpression和TerminalExpression的实例装配而成。
   *       调用解释操作。
   *
   */
  public static void main(String[] args) {
    Context ctx = new Context();
    ctx.add(new SimpleExpression());
    ctx.add(new AdvanceExpression());
    ctx.add(new SimpleExpression());

    for (Expression eps : ctx.getList()) {
      eps.interpret(ctx);
    }

  }

}

abstract class Expression {

  abstract void interpret(Context ctx);
}

class AdvanceExpression extends Expression {

  @Override
  void interpret(Context ctx) {
    System.out.println("这是高级解析器!");
  }
}

class SimpleExpression extends Expression {

  @Override
  void interpret(Context ctx) {
    System.out.println("这是普通解析器!");
  }
}

class Context {

  private String content;

  private List<Expression> list = new ArrayList();

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return this.content;
  }

  public void add(Expression eps) {
    list.add(eps);
  }

  public List<Expression> getList() {
    return list;
  }
}
