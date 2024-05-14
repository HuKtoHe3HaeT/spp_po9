public abstract class Coffee {
    public void grindCoffee() {
        System.out.println("Перемалываем кофе");
    }

    public void makeCoffee() {
        System.out.println("Делаем кофе");
    }

    public void pourIntoCup() {
        System.out.println("Наливаем в чашку");
    }

    public abstract void prepareCoffee();
}

class ItalianStyleAmericano extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен итальянский американо");
    }
}

class ItalianStyleCappucino extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен итальянский капучино");
    }
}

class ItalianStyleCaffeLatte extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен итальянский кафе латте");
    }
}

class ItalianStyleEspresso extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен итальянский эспрессо");
    }
}

class AmericanStyleAmericano extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен американский американо");
    }
}

class AmericanStyleCappucino extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен американский капучино");
    }
}

class AmericanStyleCaffeLatte extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен американский кафе латте");
    }
}

class AmericanStyleEspresso extends Coffee {
    @Override
    public void prepareCoffee() {
        System.out.println("Приготовлен американский эспрессо");
    }
}

enum CoffeeType {
    ESPRESSO,
    AMERICANO,
    CAFFE_LATTE,
    CAPPUCCINO
}

abstract class CoffeeFactory {
    public abstract Coffee createCoffee(CoffeeType type);
}

class ItalianCoffeeFactory extends CoffeeFactory {
    @Override
    public Coffee createCoffee(CoffeeType type) {
        Coffee coffee = null;
        switch (type) {
            case AMERICANO:
                coffee = new ItalianStyleAmericano();
                break;
            case ESPRESSO:
                coffee = new ItalianStyleEspresso();
                break;
            case CAPPUCCINO:
                coffee = new ItalianStyleCappucino();
                break;
            case CAFFE_LATTE:
                coffee = new ItalianStyleCaffeLatte();
                break;
        }
        return coffee;
    }
}

class AmericanCoffeeFactory extends CoffeeFactory {
    @Override
    public Coffee createCoffee(CoffeeType type) {
        Coffee coffee = null;
        switch (type) {
            case AMERICANO:
                coffee = new AmericanStyleAmericano();
                break;
            case ESPRESSO:
                coffee = new AmericanStyleEspresso();
                break;
            case CAPPUCCINO:
                coffee = new AmericanStyleCappucino();
                break;
            case CAFFE_LATTE:
                coffee = new AmericanStyleCaffeLatte();
                break;
        }
        return coffee;
    }
}

abstract class CoffeeShop {

    private final CoffeeFactory coffeeFactory;

    public CoffeeShop(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();
        coffee.prepareCoffee();

        System.out.println("Вот ваш " + type.toString() + "! Спасибо, приходите еще!");
        return coffee;
    }
}

class ItalianCoffeeShop extends CoffeeShop {

    public ItalianCoffeeShop(CoffeeFactory coffeeFactory) {
        super(coffeeFactory);
    }
}

class AmericanCoffeeShop extends CoffeeShop {
    public AmericanCoffeeShop(CoffeeFactory coffeeFactory) {
        super(coffeeFactory);
    }
}
 class Main {
    public static void main(String[] args) {
        CoffeeFactory italianCoffeeFactory = new ItalianCoffeeFactory();
        CoffeeShop italianCoffeeShop = new ItalianCoffeeShop(italianCoffeeFactory);
        italianCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE);

        CoffeeFactory americanCoffeeFactory = new AmericanCoffeeFactory();
        CoffeeShop americanCoffeeShop = new AmericanCoffeeShop(americanCoffeeFactory);
        americanCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE);
    }
}

