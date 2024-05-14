// Интерфейс команды
interface Command {
    void execute();
}

// Реализация команды для выполнения арифметической операции
class ArithmeticCommand implements Command {
    private Calculator calculator;
    private char operator;

    public ArithmeticCommand(Calculator calculator, char operator) {
        this.calculator = calculator;
        this.operator = operator;
    }

    @Override
    public void execute() {
        calculator.performOperation(operator);
    }
}

// Реализация команды для очистки экрана
class ClearCommand implements Command {
    private Calculator calculator;

    public ClearCommand(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        calculator.clearScreen();
    }
}

// Класс клавиши
class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}

// Класс калькулятора
class Calculator {
    // Методы для выполнения арифметических операций и очистки экрана
    public void performOperation(char operator) {
        System.out.println("Performing operation: " + operator);
        // Логика выполнения операции
    }

    public void clearScreen() {
        System.out.println("Clearing the screen");
        // Логика очистки экрана
    }
}

// Пример использования
public class Task_03 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Создаем кнопку для выполнения арифметической операции
        Command addCommand = new ArithmeticCommand(calculator, '+');
        Button addButton = new Button(addCommand);

        // Создаем кнопку для очистки экрана
        Command clearCommand = new ClearCommand(calculator);
        Button clearButton = new Button(clearCommand);

        // Используем кнопки
        addButton.click(); // Выполнить сложение
        clearButton.click(); // Очистить экран
    }
}
