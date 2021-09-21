package Sylwester.SylwesterWebPage.repository;



import Sylwester.SylwesterWebPage.entity.PlayerRaport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRaportRepository extends CrudRepository<PlayerRaport, Long> {

    @Query (
            value = "SELECT * FROM player_raport WHERE player_name = :name",
            nativeQuery = true)
    public PlayerRaport find(@Param("name") String name);


}
