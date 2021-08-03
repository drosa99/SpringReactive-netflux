package drosa99.spring.reactivenetflux.repositories;

import drosa99.spring.reactivenetflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
