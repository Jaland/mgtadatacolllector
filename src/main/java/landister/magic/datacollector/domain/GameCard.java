package landister.magic.datacollector.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game_card")
public class GameCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "game_card_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

    @Column(name = "card_id")
    private Integer card_id;

    @Column(name = "turn_played")
    private Integer turnPlayed;

    public GameCard() {
    }

    public GameCard(Game game, Integer card_id, Integer turnPlayed) {
        this.game = game;
        this.card_id = card_id;
        this.turnPlayed = turnPlayed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public Integer getTurnPlayed() {
        return turnPlayed;
    }

    public void setTurnPlayed(Integer turnPlayed) {
        this.turnPlayed = turnPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCard gameCard = (GameCard) o;
        return Objects.equals(id, gameCard.id) &&
                Objects.equals(game, gameCard.game) &&
                Objects.equals(card_id, gameCard.card_id) &&
                Objects.equals(turnPlayed, gameCard.turnPlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game, card_id, turnPlayed);
    }

    @Override
    public String toString() {
        return "GameCard{" +
                "id=" + id +
                ", game=" + game +
                ", card_id=" + card_id +
                ", turnPlayed=" + turnPlayed +
                '}';
    }
}
