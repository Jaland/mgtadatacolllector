package landister.magic.datacollector.domain;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "game")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "game_id")
    private Integer id;

    private boolean win;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "opponent_name")
    private String opponentName;

    private String rank;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "game")
    private List<GameCard> cards;

    public Game() {
    }

    public Game(Integer id, boolean win, String userName, String opponentName, String rank, List<GameCard> cards) {
        this.id = id;
        this.win = win;
        this.userName = userName;
        this.opponentName = opponentName;
        this.rank = rank;
        this.cards = cards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<GameCard> getCards() {
        return cards;
    }

    public void setCards(List<GameCard> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return win == game.win &&
                Objects.equals(id, game.id) &&
                Objects.equals(userName, game.userName) &&
                Objects.equals(opponentName, game.opponentName) &&
                Objects.equals(rank, game.rank) &&
                Objects.equals(cards, game.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, win, userName, opponentName, rank, cards);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", win=" + win +
                ", userName='" + userName + '\'' +
                ", opponentName='" + opponentName + '\'' +
                ", rank='" + rank + '\'' +
                ", cards=" + cards +
                '}';
    }
}
