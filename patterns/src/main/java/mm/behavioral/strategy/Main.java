package mm.behavioral.strategy;

public class Main {

    public static void main(String[] args) {
//        final StrategyType strategyType = StrategyType.REMOVE;
//        final StrategyType strategyType = StrategyType.DOUBLE;
        final StrategyType strategyType = StrategyType.REPLACE;
        final String input = "hello from SDA knowledge base!";

        final SpacesModificationStrategyProvider provider = new SpacesModificationStrategyProvider();

        SpacesModificationStrategy strategy = provider.get(strategyType);
        final String output = strategy.modify(input);
        System.out.println("Result is " + output);
    }
}
