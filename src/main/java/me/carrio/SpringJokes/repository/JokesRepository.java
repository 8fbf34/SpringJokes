package me.carrio.SpringJokes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.carrio.SpringJokes.entity.Joke;

public interface JokesRepository extends JpaRepository<Joke, Integer> {
}