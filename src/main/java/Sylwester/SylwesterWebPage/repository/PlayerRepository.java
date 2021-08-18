package Sylwester.SylwesterWebPage.repository;

import Sylwester.SylwesterWebPage.entity.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.PostUpdate;

//SELECT * PLAYER_HP FROM players WHERE player_nick = :nick
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query(
            value = "SELECT * FROM players WHERE player_nick = :nick",
            nativeQuery = true)
    public Player find(@Param("nick") String nick);


//    @Modifying
//    @Query(
//            value = "UPDATE player_hp FROM players WHERE player_nick = :nick, player_hp = :hp",
//            nativeQuery = true)
//    public void updateHP(@Param("nick") String nick, int hp);

}
