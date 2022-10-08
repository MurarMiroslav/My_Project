package mm.lambda;

import com.google.common.base.Supplier;

public class FunctionalInterfaceLambda extends Lambda {

	LambdaFunctionalInterface lambdaFunctionalInterfacee;

	public FunctionalInterfaceLambda(String surname, LambdaFunctionalInterface lambdaFunctionalInterfacee) {
		super(surname);
		this.lambdaFunctionalInterfacee = lambdaFunctionalInterfacee;
	}
}
