package gl51.movie.service.impl

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void "injectionshouldwork"() {
        expect:
            registry != null
    }

    void "favoritesshouldbeempty"() {
        expect:
            registry.listFavorites() == []
    }

    void "addingafacoviteshouldfillinthedatabase"() {
        when:
            registry.addMovieToFavorites("aaaaa")
        then:
            registry.listFavorites().size() == 1
    }
}
