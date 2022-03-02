package zad1;

public class Context {

    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public double sortStrategy(int[] tab){
    return strategy.sort(tab);
    }

    public void changeStrategy(Strategy changedStrategy){
        this.strategy = changedStrategy;
    }
}
