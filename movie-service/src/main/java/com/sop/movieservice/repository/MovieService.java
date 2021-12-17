package com.sop.movieservice.repository;

import com.sop.movieservice.entities.Movie;
import com.sop.movieservice.entities.MovieImdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class MovieService {


    private String apiKey = "AIzaSyC9YsICOM_mS2j2myqqQKNGvkSIi50FsIU";

    @Autowired
    private MovieRepository repository;

    public boolean addMovie(Movie movie) {
        try {
            repository.save(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editMovie(Movie movie) {
        try {
            repository.save(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteMovie(Movie movie) {
        try {
            repository.delete(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Movie> getAllMovies() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Movie> getMovieByName(String name) {
        try {
            return repository.findByMovieName(name);
        } catch (Exception e) {
            return null;
        }
    }

    public Movie getMovieById(String id) {
        try {
            Movie movie = repository.findByMovieId(id);

            if (movie.getImdbId() != null) {
                String movieImdbStr = WebClient.create()
                        .get()
                        .uri("http://www.omdbapi.com/?apikey=fb38d3b5&i=" + movie.getImdbId())
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                JSONObject movieImdb = new JSONObject(movieImdbStr);

                System.out.println(movieImdb);

                if (!movieImdb.getString("imdbRating").equals("N/A")) {
                    movie.setImdbRating(Double.parseDouble(movieImdb.getString("imdbRating")));
                }
                movie.setDirector(movieImdb.getString("Director"));
                movie.setPlot(movieImdb.getString("Plot"));
                movie.setActors(movieImdb.getString("Actors"));
            }

//            String ytObjectStr = WebClient.create()
//                    .get()
//                    .uri("https://youtube.googleapis.com/youtube/v3/search?q=" + movie.getName() + " trailer" + "&key=" + apiKey)
//                    .retrieve()
//                    .bodyToMono(String.class)
//                    .block();
//            JSONObject ytObject = new JSONObject(ytObjectStr);
//            JSONArray ytArray = ytObject.getJSONArray("items");
//
//            JSONObject ytItem = ytArray.getJSONObject(0);
//            JSONObject ytVdo = ytItem.getJSONObject("id");
//
//            String vdoId = ytVdo.getString("videoId");
//
//            System.out.println(ytArray);
//            System.out.println(ytItem);
//            System.out.println(ytVdo);
//            System.out.println(vdoId);
//
//            movie.setYoutubeId(vdoId);

            return movie;
        } catch (Exception e) {
            //thrown exception
            e.printStackTrace();
            throw new IllegalArgumentException();
//            return null;
        }
    }

}
