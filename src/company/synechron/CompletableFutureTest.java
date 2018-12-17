package company.synechron;

import java.net.PasswordAuthentication;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * What is completableFuture Explain test case when to use
 * https://www.baeldung.com/java-completablefuture
 * https://www.callicoder.com/java-8-completablefuture-tutorial/
 * https://dzone.com/articles/20-examples-of-using-javas-completablefuture
 * http://www.deadcoderising.com/java8-writing-asynchronous-code-with-completablefuture/
 * https://www.youtube.com/watch?v=ImtZgX1nmr8
 * 
 * @author nitin
 *
 */

public class CompletableFutureTest {
	final static Logger LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

	public static <T> CompletableFuture<T> repeat(final Supplier<T> action, final Predicate<T> until) {

		return CompletableFuture.supplyAsync(() -> Stream.generate(action).filter(until).findFirst().get());
	}

	private static <T> T getSuppliedValue(final CompletableFuture<T> futureAction) {
		try {
			return futureAction.get();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	public void testRepeat() {
		Supplier<PasswordAuthentication> action = () -> {
			final String[] passwordVault = new String[] { "password", "secret", "secretPassword" };

			final int len = passwordVault.length;

			return new PasswordAuthentication("mickeyMouse",
					passwordVault[ThreadLocalRandom.current().nextInt(len)].toCharArray());
		};
		@SuppressWarnings("static-access")
		Predicate<PasswordAuthentication> until = passwordAuth -> {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			final String password = String.valueOf(passwordAuth.getPassword());

			LOGGER.info("Received password: {}.", password);

			return password.equals("secret");
		};

		repeat(action, until);
	}

	public static void main(String[] args) {
		CompletableFutureTest completableFutureTest = new CompletableFutureTest();
		completableFutureTest.testRepeat();
	}

}
