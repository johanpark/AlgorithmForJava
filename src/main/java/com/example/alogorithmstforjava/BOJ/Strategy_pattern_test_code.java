package com.example.alogorithmstforjava.BOJ;

interface Strategy {
    int doOperation(int a, int b);
}

class AdditionStrategy implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class SubtractionStrategy implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}

public class Strategy_pattern_test_code {
    public static void main(String[] args) {
        Context context = new Context(new AdditionStrategy());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new SubtractionStrategy());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }
}
