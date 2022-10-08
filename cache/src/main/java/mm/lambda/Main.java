package mm.lambda;

import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

	private final Lambda getLambdaClass;

	private final FunctionalInterfaceLambda functionalInterfaceLambda;

	public Main(Lambda getLambdaClass, FunctionalInterfaceLambda useLambdaFunctionalInterface) {
		this.getLambdaClass = getLambdaClass;
		this.functionalInterfaceLambda = useLambdaFunctionalInterface;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("====================");
		System.out.println("getLambdaClass.getSurname(): " + getLambdaClass.getSurname() + " ===> " + ((MyLambda) getLambdaClass).getName());
		MyLambda lambda = (MyLambda) functionalInterfaceLambda.lambdaFunctionalInterfacee.createLambda();
		System.out.println("lambda.getSurname(): " + lambda.getSurname() + " ===> " + lambda.getName());
		System.out.println("====================");
	}
}
