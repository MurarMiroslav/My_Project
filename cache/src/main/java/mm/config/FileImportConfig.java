package mm.config;

import com.google.common.base.Supplier;
import java.time.Duration;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mm.lambda.FunctionalInterfaceLambda;
import mm.lambda.Lambda;
import mm.lambda.LambdaFunctionalInterface;
import mm.lambda.MyLambda;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Getter
@Setter
public class FileImportConfig {

//	@Getter(AccessLevel.NONE)
	private FileImportSessionServiceConfig sessionServiceConfig = new FileImportSessionServiceConfig();


	@Getter
	@Setter
	public static class FileImportSessionServiceConfig {

		private Duration housekeepingRate = Duration.ofSeconds(1);
	}

	@Bean
	public Lambda getLambdaClass() {
		Supplier<MyLambda> myLambdaSupplier = () -> new MyLambda("getLambdaClass", " Miro");
		return myLambdaSupplier.get();
	}
	@Bean
	public FunctionalInterfaceLambda useLambdaFunctionalInterface() {
		LambdaFunctionalInterface  lambdaFunctionalInterface = () -> new MyLambda("useLambdaFunctionalInterface", " Miro");
		return new FunctionalInterfaceLambda("FunctionalInterfaceLambda ", lambdaFunctionalInterface);
	}
}
