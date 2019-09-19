package com.newt.pattern.iterator;

/**
 * 迭代器模式：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 */
public class IteratorRun {

  /**
   * 适用性：
   *     1.访问一个聚合对象的内容而无需暴露它的内部表示。
   *
   *     2.支持对聚合对象的多种遍历。
   *
   *     3.为遍历不同的聚合结构提供一个统一的接口(即,支持多态迭代)。
   * 参与者：
   *     1.Iterator
   *       迭代器定义访问和遍历元素的接口。
   *
   *     2.ConcreteIterator
   *       具体迭代器实现迭代器接口。
   *       对该聚合遍历时跟踪当前位置。
   *
   *     3.Aggregate
   *       聚合定义创建相应迭代器对象的接口。
   *
   *     4.ConcreteAggregate
   *       具体聚合实现创建相应迭代器的接口，该操作返回ConcreteIterator的一个适当的实例.
   *
   */
  public static void main(String[] args) {
    List list = new ListImpl();
    list.add("a");
    list.add("b");
    list.add("c");
    //第一种迭代方式
    Iterator it = list.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    System.out.println("=====");
    //第二种迭代方式
    for (int i = 0; i < list.getSize(); i++) {
      System.out.println(list.get(i));
    }

  }
}

interface Iterator {

  Object next();

  void first();

  void last();

  boolean hasNext();
}

class IteratorImpl implements Iterator {

  private List list;

  private int index;

  public IteratorImpl(List list) {
    index = 0;
    this.list = list;
  }

  @Override
  public void first() {
    index = 0;
  }

  @Override
  public void last() {
    index = list.getSize();
  }

  @Override
  public Object next() {
    Object obj = list.get(index);
    index++;
    return obj;
  }

  @Override
  public boolean hasNext() {
    return index < list.getSize();
  }
}

interface List {

  Iterator iterator();

  Object get(int index);

  int getSize();

  void add(Object obj);
}

class ListImpl implements List {

  private Object[] list;

  private int index;

  private int size;

  public ListImpl() {
    index = 0;
    size = 0;
    list = new Object[100];
  }

  @Override
  public Iterator iterator() {
    return new IteratorImpl(this);
  }

  @Override
  public Object get(int index) {
    return list[index];
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public void add(Object obj) {
    list[index++] = obj;
    size++;
  }
}