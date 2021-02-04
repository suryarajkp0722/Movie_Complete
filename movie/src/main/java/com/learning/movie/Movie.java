/**
 * 
 */
package com.learning.movie;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * @author surya
 *
 */

public class Movie {
	
	private String id;
	private String movieName;
	private String movieCast;
	private String movieDirector;
	private String movieMusician;
	private String movieProducer;
	private String movieRating;
	private String movieReleasedate;
	private String movieGenre;
	private String errorMessage;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the movieCast
	 */
	public String getMovieCast() {
		return movieCast;
	}
	/**
	 * @param movieCast the movieCast to set
	 */
	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}
	/**
	 * @return the movieDirector
	 */
	public String getMovieDirector() {
		return movieDirector;
	}
	/**
	 * @param movieDirector the movieDirector to set
	 */
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	/**
	 * @return the movieMusician
	 */
	public String getMovieMusician() {
		return movieMusician;
	}
	/**
	 * @param movieMusician the movieMusician to set
	 */
	public void setMovieMusician(String movieMusician) {
		this.movieMusician = movieMusician;
	}
	/**
	 * @return the movieProducer
	 */
	public String getMovieProducer() {
		return movieProducer;
	}
	/**
	 * @param movieProducer the movieProducer to set
	 */
	public void setMovieProducer(String movieProducer) {
		this.movieProducer = movieProducer;
	}
	/**
	 * @return the movieRating
	 */
	public String getMovieRating() {
		return movieRating;
	}
	/**
	 * @param movieRating the movieRating to set
	 */
	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}
	/**
	 * @return the movieReleasedate
	 */
	public String getMovieReleasedate() {
		return movieReleasedate;
	}
	/**
	 * @param movieReleasedate the movieReleasedate to set
	 */
	public void setMovieReleasedate(String movieReleasedate) {
		this.movieReleasedate = movieReleasedate;
	}
	/**
	 * @return the movieGenre
	 */
	public String getMovieGenre() {
		return movieGenre;
	}
	/**
	 * @param movieGenre the movieGenre to set
	 */
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
    	
	

}
