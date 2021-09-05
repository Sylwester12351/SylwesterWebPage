package Sylwester.SylwesterWebPage.repository;

import Sylwester.SylwesterWebPage.entity.HomeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeInfoRepository extends CrudRepository<HomeInfo, Long> {
}
