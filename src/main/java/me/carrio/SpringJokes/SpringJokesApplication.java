package me.carrio.SpringJokes;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.carrio.SpringJokes.entity.Joke;
import me.carrio.SpringJokes.repository.JokesRepository;

@SpringBootApplication
public class SpringJokesApplication implements CommandLineRunner {

	@Autowired
	private JokesRepository jokeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJokesApplication.class, args);
	}
	
	
	@Override
    public void run(String... strings) throws Exception {
		System.out.printf("The database contains %s jokes.\n", jokeRepository.count());

	    // I'm not using the multi-argument constructor so that I can use scanner
		Scanner scanner = new Scanner(System.in);
	    // to read values directly into the joke properties.
	    Joke joke = new Joke();

	    // read the joke data
	    System.out.println("Tell us a joke: ");
	    joke.setJoke(scanner.nextLine());

	    System.out.println("What's the punchline?: ");
	    joke.setPunchline(scanner.nextLine());

	    System.out.println("On a scale of 1 to 10, how funny is this joke?");
	    // for the sake of simplicity I'm not validating this input
	    joke.setRating(scanner.nextInt());

	    // save the joke
	    jokeRepository.save(joke);

	    // how many jokes do we have now?
	    System.out.printf("The database contains %s jokes.\n", jokeRepository.count());
	    scanner.close();
    }
}
