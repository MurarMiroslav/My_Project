package mm.service;

import java.util.List;
import mm.domain.User;
import mm.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {

	private final String api_url;
	private final RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
		this.restTemplate = restTemplate;
		this.api_url = api_url;
	}

	@Override
	public List<User> getUsers(Integer limit) {

		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(api_url)
				.queryParam("limit", limit);

		UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class);
		return userData.getData();
	}

	@Override
	public Flux<User> getUsers(Mono<Integer> limit) {

		return WebClient
				.create(api_url)
				.get()
				.uri(uriBuilder -> uriBuilder.queryParam("limit", limit.block()).build())
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMap(resp -> resp.bodyToMono(UserData.class))
				.flatMapIterable(UserData::getData);
	}
}
