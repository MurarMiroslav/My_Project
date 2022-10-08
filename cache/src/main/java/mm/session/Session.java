package mm.session;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public interface Session extends Closeable {

	String storeData(InputStream inputStream, String filename);
}