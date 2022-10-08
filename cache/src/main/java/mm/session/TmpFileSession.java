package mm.session;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TmpFileSession implements Session {

	private static final Cleaner cleaner = Cleaner.create();
	@Override
	public String storeData(InputStream inputStream, String filename) {
		try {
			Path tmpFile = Files.createTempFile(Path.of(System.getProperty("java.io.tmpdir")),"mm-", ".tmp");
			System.out.println("Created temporary file " + tmpFile + " for session");
//			System.out.println("Temp folder is: " + System.getProperty("java.io.tmpdir"));
			tmpFile.toFile().deleteOnExit();
			Files.copy(inputStream, tmpFile, StandardCopyOption.REPLACE_EXISTING);

			CleanableInputStream cleanableInputStream = new CleanableInputStream(inputStream);
			Cleanable cleanable = cleaner.register(cleanableInputStream, new CloseInputStream(inputStream));
			cleanableInputStream.setCleanable(cleanable);

			return "storeData";
		} catch (IOException e) {
			throw new RuntimeException("Failed to write content of inputStream to temporary file", e);
		}
	}

	@Override
	public void close() throws IOException {

	}

	private static class CloseInputStream implements Runnable {

		private final InputStream stream;

		CloseInputStream(InputStream stream) {
			this.stream = stream;
		}

		public void run() {
			try {
				stream.close();
				log.debug("Closed input stream for session");
			} catch (IOException e) {
				log.warn("Failed to close input stream for session", e);
			}
		}
	}
}
