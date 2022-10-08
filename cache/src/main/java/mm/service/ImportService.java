package mm.service;

import java.io.InputStream;
import mm.session.HouseKeeper;
import mm.session.Session;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ImportService {

	private final Session session;
	private final HouseKeeper houseKeeper;

	public ImportService(Session session) {
		this.session = session;
		this.houseKeeper = new HouseKeeper() {
			@Override
			public void cleanUp() {
				System.out.println("Starting housekeeping");
			}
		};
	}

	public String storeData(InputStream inputStream,  String filename) {
		return session.storeData(inputStream, filename);
	}

	@Scheduled(fixedDelayString = "#{@fileImportConfig.getSessionServiceConfig().getHousekeepingRate()}")
//	@Scheduled(fixedDelayString = "1000")
	public void runHousekeeping() {
		houseKeeper.cleanUp();
	}
}
