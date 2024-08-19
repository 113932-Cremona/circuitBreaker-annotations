package ejercicio.CircuitB.Services;

import ejercicio.CircuitB.Dtos.RandomJoke;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class ChuckNorrisServiceImpl implements ChuckBorrisService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "items", fallbackMethod = "metodoAlterno")
    @Override
    public RandomJoke randomJockByCategory(String category) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<RandomJoke> resp = restTemplate.exchange("https://api.chucknorris.io/jokes/random?category="+category,HttpMethod.GET,entity,RandomJoke.class);

        return resp.getBody();

    }

    public RandomJoke metodoAlterno(String category,Throwable throwable) {
        // Implementación del método alternativo en caso de fallo
        String[] array = new String[]{category};
        return new RandomJoke(array, LocalDateTime.now(), "n/n", "n/n", null, null, "Chuck Norris once kicked a horse in the chin. Its descendants are known today as Giraffes.");
    }

}
