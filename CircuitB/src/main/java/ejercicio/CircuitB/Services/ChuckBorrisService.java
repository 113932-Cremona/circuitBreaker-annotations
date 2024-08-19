package ejercicio.CircuitB.Services;

import ejercicio.CircuitB.Dtos.RandomJoke;
import org.springframework.stereotype.Service;

@Service
public interface ChuckBorrisService {

    RandomJoke randomJockByCategory(String category);

}
