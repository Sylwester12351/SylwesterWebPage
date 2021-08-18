package Sylwester.SylwesterWebPage.repository;

import Sylwester.SylwesterWebPage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.nick = ?1")
    public User findByNick(String nick);

}
