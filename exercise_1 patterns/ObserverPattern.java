import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

class NewsAgency extends Subject {
    private String latestNews;

    public void setNews(String news) {
        this.latestNews = news;
        notifyObservers(news);
    }

    public String getLatestNews() {
        return latestNews;
    }
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        Subscriber subscriber1 = new Subscriber("John");
        Subscriber subscriber2 = new Subscriber("Jane");

        agency.addObserver(subscriber1);
        agency.addObserver(subscriber2);

        agency.setNews("New Java release 15!");
    }
}
