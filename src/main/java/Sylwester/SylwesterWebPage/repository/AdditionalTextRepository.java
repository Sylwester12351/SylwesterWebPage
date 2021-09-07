package Sylwester.SylwesterWebPage.repository;

import Sylwester.SylwesterWebPage.entity.AdditionalText;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalTextRepository extends CrudRepository<AdditionalText, Long> {
}
