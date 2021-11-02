package Sylwester.SylwesterWebPage.repository;


import Sylwester.SylwesterWebPage.entity.NewsDataBase;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<NewsDataBase, Long> {
}
