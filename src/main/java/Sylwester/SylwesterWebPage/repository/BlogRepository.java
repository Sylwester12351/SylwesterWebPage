package Sylwester.SylwesterWebPage.repository;

import Sylwester.SylwesterWebPage.entity.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long>{
}
