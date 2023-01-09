package lu.atozdigital.api.services;

import java.util.List;

import lu.atozdigital.api.share.dto.ArticleDto;

public interface ArticleService {
	
	ArticleDto addArticle(ArticleDto article);
	
	List<ArticleDto> getAll();
	
	ArticleDto getOne(long id);
	
	void deleteOrd(long id);
	
	void deleteFromOrd(long ord, long id);
}
