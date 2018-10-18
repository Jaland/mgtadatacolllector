package landister.magic.datacollector.repository;


import landister.magic.datacollector.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByUserName(String userName);

}
