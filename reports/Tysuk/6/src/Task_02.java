
class AnalogClock {
    private int hours;
    private int minutes;
    private int seconds;

    public void setClock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void rotateHands() {
        // Логика поворота стрелок
    }

    // Методы для получения времени
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}

// Фасад для работы с часами
class ClockFacade {
    private AnalogClock analogClock;

    public ClockFacade() {
        this.analogClock = new AnalogClock();
    }

    // Методы для установки времени
    public void setTime(int hours, int minutes, int seconds) {
        analogClock.setClock(hours, minutes, seconds);
    }

    // Методы для получения времени в цифровом формате
    public int getHours() {
        return analogClock.getHours();
    }

    public int getMinutes() {
        return analogClock.getMinutes();
    }

    public int getSeconds() {
        return analogClock.getSeconds();
    }
}

// Пример использования
public class Task_02 {
    public static void main(String[] args) {
        ClockFacade clock = new ClockFacade();

        // Устанавливаем время
        clock.setTime(12, 30, 0);

        // Получаем время в цифровом формате
        System.out.println("Time: " + clock.getHours() + ":" + clock.getMinutes() + ":" + clock.getSeconds());
    }
}
