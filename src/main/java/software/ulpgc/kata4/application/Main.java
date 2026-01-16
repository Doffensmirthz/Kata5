package software.ulpgc.kata4.application;

import software.ulpgc.kata4.io.RemoteMovieLoader;
import software.ulpgc.kata4.model.Movie;
import software.ulpgc.kata4.tasks.HistogramBuilder;
import software.ulpgc.kata4.viewModel.Histogram;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RemoteMovieLoader remoteMovieLoader = new RemoteMovieLoader();
        List<Movie> movies = remoteMovieLoader.loadAll();
        movies = movies.stream()
                .filter(m -> m.releaseYear() > 1900)
                .filter(m -> m.releaseYear() < 2050).toList();
        Histogram histogram = new HistogramBuilder(movies).build(Movie::releaseYear);


        MainFrame.create()
                .display(histogram)
                .setVisible(true);
    }
}
