package lu.atozdigital.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lu.atozdigital.api.entites.ArticleEntity;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleEntity, Long>{

}
