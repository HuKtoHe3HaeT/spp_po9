import java.util.*;

interface Transport {
    double calculatePassengerTime();
    double calculateCargoTime(double cargoWeight);
    void displayInfo();
}

interface Passenger {
    void createRequest(String destinationStation, Date dateTime);
    void chooseTrain(ArrayList<Train> trains);
    Invoice getInvoice(double price);
}

interface Transportation {
    void addStation(Station station);
    double getPriceForStation(Station station);
}

interface Priceable {
    void setPrice(Station station, double price);
}

class PassengerImpl implements Passenger {
    private String name;
    private String passportNumber;

    public PassengerImpl(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Пассажир: " + name + ", Паспорт: " + passportNumber;
    }

    public void createRequest(String destinationStation, Date dateTime) {
        System.out.println("Заявка создана на станцию: " + destinationStation + " на " + dateTime);
    }

    public void chooseTrain(ArrayList<Train> trains) {
        Train chosenTrain = trains.get(0);
        System.out.println("Выбран поезд: " + chosenTrain.getTrainNumber());
    }

    public Invoice getInvoice(double price) {
        System.out.println("Счет выставлен на сумму: " + price);
        return new Invoice(price);
    }
}

class Train implements Transportation, Priceable {
    private String trainNumber;
    private ArrayList<Station> stations;
    private HashMap<Station, Double> prices;

    public Train(String trainNumber) {
        this.trainNumber = trainNumber;
        this.stations = new ArrayList<>();
        this.prices = new HashMap<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void setPrice(Station station, double price) {
        prices.put(station, price);
        System.out.println("Установлена цену для поезда " + trainNumber + " на станции " + station + ": " + price);
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public double getPriceForStation(Station station) {
        return prices.get(station);
    }
}

class Station {
    private String name;
    private Date arrivalTime;
    private Date departureTime;

    public Station(String name, Date arrivalTime, Date departureTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Ticket {
    private Passenger passenger;
    private Train train;
    private Station destinationStation;
    private Date dateTime;
    private double price;

    public Ticket(Passenger passenger, Train train, Station destinationStation, Date dateTime, double price) {
        this.passenger = passenger;
        this.train = train;
        this.destinationStation = destinationStation;
        this.dateTime = dateTime;
        this.price = price;
    }

    public void printTicket() {
        System.out.println("Детали билета:");
        System.out.println("Пассажир: " + passenger);
        System.out.println("Поезд: " + train.getTrainNumber());
        System.out.println("Станция назначения: " + destinationStation);
        System.out.println("Дата и время: " + dateTime);
        System.out.println("Стоимость: " + price);
    }
}

class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public void printInvoice() {
        System.out.println("Счет на сумму: " + amount);
    }
}

class Administrator {
    public void addTrain(Train train) {
        System.out.println("Поезд добавлен: " + train.getTrainNumber());
    }

    public void setPrice(Train train, Station station, double price) {
        train.setPrice(station, price);
    }
}

class Main {
    public static void main(String[] args) {
        Passenger passenger = new PassengerImpl("Энакин Скайуокер", "ABC12345");
        Train train = new Train("Экспресс");
        Station station = new Station("ЗвездаСмерти", new Date(), new Date());

        train.addStation(station);

        Administrator admin = new Administrator();
        admin.setPrice(train, station, 50.0);

        passenger.createRequest("ЗвездаСмерти", new Date());

        ArrayList<Train> trains = new ArrayList<>();
        trains.add(train);

        passenger.chooseTrain(trains);

        double price = train.getPriceForStation(station);
        Invoice invoice = passenger.getInvoice(price);
        invoice.printInvoice();
        Ticket ticket = new Ticket(passenger, train, station, new Date(), price);
        ticket.printTicket();
    }
}
