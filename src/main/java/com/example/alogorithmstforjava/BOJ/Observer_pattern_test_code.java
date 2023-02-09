package com.example.alogorithmstforjava.BOJ;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(Subject subject);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class StockPrice implements Subject {
    private List<Observer> observers;
    private double price;

    public StockPrice() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }
}

class StockBuyer implements Observer {
    @Override
    public void update(Subject subject) {
        System.out.println("Stock price changed: " + ((StockPrice) subject).getPrice());
    }
}

public class Observer_pattern_test_code {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        StockBuyer buyer1 = new StockBuyer();
        StockBuyer buyer2 = new StockBuyer();

        stockPrice.registerObserver(buyer1);
        stockPrice.registerObserver(buyer2);

        stockPrice.setPrice(100.0);
        stockPrice.setPrice(150.0);

        stockPrice.removeObserver(buyer2);

        stockPrice.setPrice(200.0);
    }
}
