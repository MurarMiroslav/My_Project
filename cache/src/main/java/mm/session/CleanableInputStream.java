package mm.session;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Cleaner.Cleanable;

public class CleanableInputStream extends InputStream {

	private final InputStream delegate;
	private Cleanable cleanable;

	CleanableInputStream(InputStream delegate) {
		this.delegate = delegate;
	}

	public void setCleanable(Cleanable cleanable) {
		this.cleanable = cleanable;
	}

	@Override
	public int read() throws IOException {
		return delegate.read();
	}

	@Override
	public void close() throws IOException {
		super.close();
		if (cleanable != null) {
			cleanable.clean();
		}
	}
}
