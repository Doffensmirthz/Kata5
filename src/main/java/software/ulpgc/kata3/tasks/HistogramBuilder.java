package software.ulpgc.kata3.tasks;

import software.ulpgc.kata3.model.Movie;
import software.ulpgc.kata3.viewModel.Histogram;

import java.util.List;
import java.util.function.Function;

public class HistogramBuilder {
    private final List<Movie> movies;

    public HistogramBuilder(List<Movie> movies) {
        this.movies = movies;
    }

    public Histogram build(Function<Movie, Integer> transform){
        Histogram histogram = new Histogram();
        for (Movie movie: movies){
            histogram.put(transform.apply(movie));
        }
        return histogram;
    }
}
