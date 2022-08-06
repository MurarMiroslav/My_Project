package mm.structural.decorator;

public class Main {

	public static void main(String[] args) {

		FragStatistics statistics = new FirstPersonShooterFragStatistics();

		statistics.incrementDeathCount(); // nothing appears on the 									screen
		statistics.incrementFragCount(); // nothing appears on the 									screen

		// use of decorators
		System.out.println("\nStarting using decorators: \n");
		FragStatistics decoratedStatistics = new FragDeathRatioDecorator(new FragInfoDecorator(new DisplayCountersDecorator(new DeathCountInfoDecorator(statistics))));

		decoratedStatistics.incrementFragCount();
		decoratedStatistics.incrementFragCount();
		decoratedStatistics.incrementFragCount(); // because we are good players!
		decoratedStatistics.incrementDeathCount();
		decoratedStatistics.incrementDeathCount();

	}
}
