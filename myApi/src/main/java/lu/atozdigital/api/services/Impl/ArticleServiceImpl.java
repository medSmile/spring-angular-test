package lu.atozdigital.api.services.Impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lu.atozdigital.api.services.ArticleService;
import lu.atozdigital.api.share.dto.ArticleDto;
import lu.atozdigital.api.entites.ArticleEntity;
import lu.atozdigital.api.entites.OrderEntity;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.repositories.OrderRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public ArticleDto addArticle(ArticleDto article) {
		
		ModelMapper modelMapper = new ModelMapper();
		ArticleEntity articleEntity = modelMapper.map(article, ArticleEntity.class);
		ArticleEntity newArticle = articleRepository.save(articleEntity);
		ArticleDto articleDto = modelMapper.map(newArticle, ArticleDto.class);
		
		return articleDto;
	}

	@Override
	public List<ArticleDto> getAll() {
		List<ArticleEntity> articles = (List<ArticleEntity>) articleRepository.findAll();
		
		ModelMapper modelMapper = new ModelMapper();
		Type ListType = new TypeToken<List<ArticleDto>>(){}.getType();
		List<ArticleDto> allArticles = modelMapper.map(articles, ListType);
		
		return allArticles;
	}

	@Override
	public ArticleDto getOne(long id) {
		ArticleEntity article = articleRepository.findById(id).get();
		if(article == null) throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, "article not found");
		ModelMapper modelMapper = new ModelMapper();
		ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);
		
		return articleDto;
	}
	
	@Override
	public void deleteOrd(long id) {
		articleRepository.deleteById(id);
		
	}
	
	
	@Override
	public void deleteFromOrd(long idOrd, long id) {
		
		OrderEntity orderEntity = orderRepository.findById(idOrd).get();
		ArticleEntity articleEntity = articleRepository.findById(id).get();
		int index = orderEntity.getArticles().indexOf(articleEntity);
		orderEntity.getArticles().remove(index);
	}

	

}
