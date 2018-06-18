package me.carrio.SpringJokes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="joke")
public class Joke {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="content", length=500)
	private String joke;
	@Column(name="punchline", length=500)
    private String punchline;
	@Column(name="rating")
    private int rating;
    
    public Joke() {}

    public Joke(String joke, String punchline, int rating) {
        this.joke = joke;
        this.punchline = punchline;
        this.rating = rating;
    }

    @Column
    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Column
    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    @Column
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
