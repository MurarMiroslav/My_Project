package mm.creational.abstractFactory;

public class FactoryProvider {

	public CarFactory createFactory(CarType carType) {
		switch (carType) {
			case AUDI_A4:
				return new AudiA4Factory();
			case TOYOTA_COROLLA:
				return new ToyotaCorollaFactory();
			default:
				throw new UnsupportedOperationException();
		}
	}
}
