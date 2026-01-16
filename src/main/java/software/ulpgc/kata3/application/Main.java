package software.ulpgc.kata3.application;

import software.ulpgc.kata3.io.RemoteMovieLoader;
import software.ulpgc.kata3.model.Movie;
import software.ulpgc.kata3.tasks.HistogramBuilder;
import software.ulpgc.kata3.viewModel.Histogram;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RemoteMovieLoader remoteMovieLoader = new RemoteMovieLoader();
        List<Movie> movies = remoteMovieLoader.loadAll();
        Histogram histogram = new HistogramBuilder(movies).build(Movie::releaseYear);
        for(int bin : histogram){
            System.out.println(bin + " tiene " + histogram.count(bin) + " apariciones");
        }
        MainFrame.create()
                .display(histogram)
                .setVisible(true);
    }
}
