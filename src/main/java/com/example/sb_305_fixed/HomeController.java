package com.example.sb_305_fixed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Actor actor = new Actor();
        actor.setName("Sandra Bollock");
        actor.setRealname("Sandra Mae Bullowski");

        Movie movie = new Movie();
        movie.setTitle("The emoji movie");
        movie.setYear(2017);

        movie.setDescription("About emojis");
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);
        movieRepository.save(movie);
//      aaaaa
        Movie movie2 = new Movie();
        movie2.setTitle("Transformers");
        movie2.setYear(2018);

        movie2.setDescription("About robots ");
        movies.add(movie2);
        movieRepository.save(movie2);

        Movie movie3 = new Movie();
        movie3.setTitle("Dragon Ball Z");
        movie3.setYear(1994);
        movie3.setDescription("Fighting fights fighters");


        Actor actor2 = new Actor();
        actor2.setName("Tom Hanks");
        actor2.setRealname("Thomas Hank");


        Set<Movie> tomMovies = new HashSet<Movie>();
        Set<Actor> moviesWithTom = new HashSet<Actor>();

        moviesWithTom.add(actor2);
        tomMovies.add(movie);
        tomMovies.add(movie3);
        actor2.setMovies(tomMovies);

        movie3.setCast(moviesWithTom);
        // aaa

        actor.setMovies(movies);
        actorRepository.save(actor);
        actorRepository.save(actor2);
        movieRepository.save(movie);
        movieRepository.save(movie2);

        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());

        ArrayList<Movie> allMovies = (ArrayList<Movie>) movieRepository.findAll();
        model.addAttribute("allMovies", allMovies);



        return "index";

    }
}
