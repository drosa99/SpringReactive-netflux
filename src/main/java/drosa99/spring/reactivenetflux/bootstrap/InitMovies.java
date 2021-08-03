package drosa99.spring.reactivenetflux.bootstrap;

import drosa99.spring.reactivenetflux.domain.Movie;
import drosa99.spring.reactivenetflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Filme 1","Filme 2","Filme 3","Filme 4","Filme 5")
                        .map(title -> new Movie(title))
                        .flatMap(movieRepository::save)
                ).subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
        });
    }
}
