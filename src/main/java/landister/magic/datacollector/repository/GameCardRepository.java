package landister.magic.datacollector.repository;


import landister.magic.datacollector.domain.Game;
import landister.magic.datacollector.domain.GameCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameCardRepository extends CrudRepository<GameCard, Integer> {
    List<GameCard> findByGame(Game game);
}
