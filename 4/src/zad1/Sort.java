package zad1;

public class Sort {
    private Strategy strategy;
    public Sort(Strategy strategy){
        this.strategy = strategy;
    }

    public double sortStrategy(int[] tab){
        return strategy.sort(tab);
    }

    public void changeStrategy(Strategy changedStrategy){
        this.strategy = changedStrategy;
    }

    public Strategy getStrategy(){return strategy;}

}
