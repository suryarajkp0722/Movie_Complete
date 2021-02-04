/**
 * 
 */
package com.learning.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author surya
 *
 */
@CrossOrigin
@RestController
public class MoviesController {
	static final Logger log =    LoggerFactory.getLogger(MoviesController.class);
    ArrayList<Movie> allMovieStorage = new ArrayList<Movie>();
    
	@GetMapping("/testGet")
	public String Test() {
		System.out.println("*************** Test Get ****************");
		return "testGet";
	}
	
	@PostMapping("/testPost")
	public String Test1() {
		System.out.println("*************** Test Post ****************");
		return "testPost";
	}
	
	
	@GetMapping("/getAllMovie")
	public ArrayList<Movie> getAllMovies(HttpServletRequest request,   HttpServletResponse response){	
		HttpSession session = request.getSession();
		ArrayList<Movie> allMovies = new ArrayList<Movie>();
		for(Movie m :getDefaultMovieList() ) {
			addMovieToSession(session, m);
		}
		for(int i = 0; i<=10; i++) {
			String strOfI = Integer.toString(i);
			Movie moviefromsesion = (Movie)session.getAttribute(strOfI);
			allMovies.add(moviefromsesion);
		}
		return allMovies;
	}
	
	
	
	@PostMapping("/addMovie")
	public String addMovie(HttpServletRequest request,   HttpServletResponse response, @RequestBody Movie movie) {
		HttpSession session = request.getSession();
		Movie movieToAdd = new Movie();
		if(null != movie) {
		movieToAdd.setId(movie.getId());
		movieToAdd.setErrorMessage(movie.getErrorMessage());
		movieToAdd.setMovieReleasedate(movie.getMovieReleasedate());
		movieToAdd.setMovieCast(movie.getMovieCast());
		movieToAdd.setMovieDirector(movie.getMovieDirector());
		movieToAdd.setMovieMusician(movie.getMovieGenre());
		movieToAdd.setMovieName(movie.getMovieName());
		movieToAdd.setMovieProducer(movie.getMovieProducer());
		movieToAdd.setMovieRating(movie.getMovieRating());		
		addMovieToSession(session, movieToAdd);
		return "Movie has been added sucessfully";
		}else {
		return "Something went wrong. Please provide the correct data";
		}
		
	}
	
	public ArrayList<Movie> getDefaultMovieList(){
		ArrayList<Movie> allDefaultMovies = new ArrayList<Movie>();
		System.out.println("*************** Start Movie 1 ****************");
		Movie movie1 = new Movie();
		movie1.setId("1");
		movie1.setMovieCast("test");
		movie1.setMovieDirector("test");
		movie1.setMovieGenre("test");
		movie1.setMovieMusician("test");
		movie1.setMovieName("test");		
		System.out.println("*************** End Movie 1  ****************");
		System.out.println("*************** Start Movie 2  ****************");
		Movie movie2 = new Movie();
		movie2.setId("2");
		movie2.setMovieCast("test");
		movie2.setMovieDirector("test");
		movie2.setMovieGenre("test");
		movie2.setMovieMusician("test");
		movie2.setMovieName("test");
		System.out.println("*************** End Movie 2  ****************");
		allDefaultMovies.add(movie1);
		allDefaultMovies.add(movie2);
		return allDefaultMovies;
	}
	
	public void addMovieToSession(HttpSession session , Movie movie) {
		if(null != session && null != movie) {
		System.out.println("Adding Movie");
		session.setAttribute(movie.getId(), movie);
		}
	}
	
	@GetMapping("/getMovieFromSession")
	public Movie getMovieFromSession(HttpServletRequest request,   HttpServletResponse response, @RequestParam String id) {
		HttpSession session = request.getSession();
		Movie moviefromsesion = (Movie)session.getAttribute(id);
        if(null == moviefromsesion ) {
        	moviefromsesion = new Movie();
            moviefromsesion.setErrorMessage("Movie with id "+id+" not found");
        	 return moviefromsesion;
        }
		return moviefromsesion;
	}
	
	@PutMapping("/updateMovie")
	public String updateMovie(HttpServletRequest request,   HttpServletResponse response, @RequestParam String id,@RequestBody Movie movie ) {
		HttpSession session = request.getSession();
		Movie moviefromsesion = (Movie)session.getAttribute(id);
        if(null != moviefromsesion ) {
        	session.removeAttribute(id);
        	addMovieToSession(session,movie);
        	return "Movie has overridden";
        }else {
        	addMovieToSession(session,movie);
        	return "Did not find the movie.Movie has added";
        }
	}
	
	@DeleteMapping("/deleteMovie")
	public String deleteMovie(HttpServletRequest request,   HttpServletResponse response, @RequestParam String id ) {
		HttpSession session = request.getSession();
		Movie moviefromsesion = (Movie)session.getAttribute(id);
        if(null != moviefromsesion ) {
        	session.removeAttribute(id);        	
        	return "Movie has been deleted";
        }else {
        	return "Did not find the movie.Please request with correct movie id";
        }
	}
	

}
