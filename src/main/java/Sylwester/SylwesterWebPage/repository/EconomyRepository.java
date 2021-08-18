package Sylwester.SylwesterWebPage.repository;

import Sylwester.SylwesterWebPage.entity.Economy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomyRepository extends CrudRepository<Economy, Long> {
}
