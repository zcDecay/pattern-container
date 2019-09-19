package com.newt.pattern.factory;


/**
 * 抽象工厂模式
 *    创建一系列相关或者相互依赖对象接口，而无需指定他们的类
 */
public class AbstractFactoryRun {

    public static void main(String[] args) {
        IAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
        ICat blackCat = blackAnimalFactory.createCat();
        blackCat.eat();
        IDog blackDog = blackAnimalFactory.createDog();
        blackDog.eat();

        IAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
        ICat whiteCat = whiteAnimalFactory.createCat();
        whiteCat.eat();
        IDog whiteDog = whiteAnimalFactory.createDog();
        whiteDog.eat();

    }

}

/**
 *  声明一个创建抽象产品对象的操作接口
 */
interface IAnimalFactory {

    ICat createCat();

    IDog createDog();
}

class BlackAnimalFactory implements IAnimalFactory {

    @Override
    public ICat createCat() {
        return new BlackCat();
    }

    @Override
    public IDog createDog() {
        return new BlackDog();
    }

}

class WhiteAnimalFactory implements IAnimalFactory {

    @Override
    public ICat createCat() {
        return new WhiteCat();
    }

    @Override
    public IDog createDog() {
        return new WhiteDog();
    }

}

interface ICat {

    void eat();
}

interface IDog {

    void eat();
}

class BlackCat implements ICat {

    @Override
    public void eat() {
        System.out.println("The black cat is eating!");
    }

}

class WhiteCat implements ICat {
    @Override
    public void eat() {
        System.out.println("The white cat is eating!");
    }

}
class BlackDog implements IDog {

    @Override
    public void eat() {
        System.out.println("The black dog is eating");
    }

}
class WhiteDog implements IDog {

    @Override
    public void eat() {
        System.out.println("The white dog is eating!");
    }

}
