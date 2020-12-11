package Service;
import java.util.List;

import Entity.Movie;


public interface MovieService<Movie> {


			 public default List<Movie> retrieveMovies() {
				// TODO Auto-generated method stub
				return null;
			}
			  
			 public Entity.Movie getMovie(Long movieId);
			  
			 public void saveMovie(Movie movie);
			  
			 public void deleteMovie(Long movieId);
			  
			 public void updateMovie(Movie movie); /* den kserw an xreizetai*/
			}

