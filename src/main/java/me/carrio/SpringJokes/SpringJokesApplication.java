package me.carrio.SpringJokes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.carrio.SpringJokes.entity.Joke;
import me.carrio.SpringJokes.repository.JokesRepository;
import me.carrio.SpringJokes.service.MenuService;

@SpringBootApplication
public class SpringJokesApplication implements CommandLineRunner {

	@Autowired
	private JokesRepository jokeRepository;
	@Autowired
	private MenuService menuService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJokesApplication.class, args);
	}
	
	
	@Override
    public void run(String... strings) throws Exception {
		System.out.printf("The database contains %s jokes.\n", jokeRepository.count());

		while(true){
	        int primaryAction = menuService.promptForMainMenuSelection();

	        if(primaryAction == MenuService.LIST_JOKES){
	            List<Joke> jokes = jokeRepository.findAll();
	            menuService.displayJokes(jokes);

	        } else if(primaryAction == MenuService.CREATE_JOKE){
	            // collect the joke data
	            Joke joke = menuService.promptForJokeData();

	            // save the joke
	            jokeRepository.save(joke);

	        } else if(primaryAction == MenuService.VIEW_JOKE){
	            // which joke?
	            int id = menuService.promptForJokeID();

	            // read the joke
	            Optional<Joke> jokeOpt = jokeRepository.findById(id);

	            if(jokeOpt.isPresent()){
	                // display the joke
	                menuService.displayJoke(jokeOpt.get());
	            } else {
	                menuService.displayNoSuchJoke();
	            }

	        } else if(primaryAction == MenuService.EDIT_JOKE){
	            // which joke?
	            int index = menuService.promptForJokeID();

	            // read the joke
	            Optional<Joke> jokeOpt = jokeRepository.findById(index);

	            if(jokeOpt.isPresent()){
	                // update the joke data
	                Joke joke = menuService.promptForJokeData(jokeOpt.get());

	                // update the joke
	                jokeRepository.save(joke);
	            } else {
	                menuService.displayNoSuchJoke();
	            }

	        } else if(primaryAction == MenuService.DELETE_JOKE){
	            // which joke?
	            int index = menuService.promptForJokeID();

	            // delete the joke
	            jokeRepository.deleteById(index);

	        } else if(primaryAction == MenuService.QUIT){

	            // break out of the loop
	            break;

	        }
	    }
    }
}
