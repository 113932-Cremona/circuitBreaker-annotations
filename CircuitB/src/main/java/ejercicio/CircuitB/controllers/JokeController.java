package ejercicio.CircuitB.controllers;

import ejercicio.CircuitB.Dtos.RandomJoke;
import ejercicio.CircuitB.Services.ChuckBorrisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {
    @Autowired
    private ChuckBorrisService chuckNorrisService;

    @GetMapping("/getJokeByCategory/{category}")
    public ResponseEntity<RandomJoke> getAll(@PathVariable String category){
        return ResponseEntity.ok(chuckNorrisService.randomJockByCategory(category));
    }

}
