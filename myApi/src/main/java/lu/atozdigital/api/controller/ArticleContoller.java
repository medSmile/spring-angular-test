package lu.atozdigital.api.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lu.atozdigital.api.repositories.OrderRepository;
import lu.atozdigital.api.request.ArticleRequest;
import lu.atozdigital.api.response.ArticleResponse;
import lu.atozdigital.api.services.ArticleService;
import lu.atozdigital.api.share.dto.ArticleDto;



@RestController
@RequestMapping("/article")
public class ArticleContoller {
	
	@Autowired
	ArticleService articleService;
	
	@PostMapping
	public ResponseEntity<ArticleResponse> createrArticle(@RequestBody ArticleRequest articleRequest) throws Exception 
	{
		
		ModelMapper modelMapper = new ModelMapper();
		
		ArticleDto articleDto = modelMapper.map(articleRequest, ArticleDto.class);
		
		ArticleDto newArticle = articleService.addArticle(articleDto);
		
		ArticleResponse articleResponse = modelMapper.map(newArticle, ArticleResponse.class);
		
		return new ResponseEntity<ArticleResponse>(articleResponse,HttpStatus.OK);
				
		
	}

	@GetMapping
	public ResponseEntity<List<ArticleResponse>> getArticles(){
		
		List<ArticleDto> articles = articleService.getAll();
		
		ModelMapper modelMapper = new ModelMapper();
		Type listType = new TypeToken<List<ArticleResponse>>(){}.getType();
		List<ArticleResponse> articleResponse = modelMapper.map(articles, listType);
		
		return new ResponseEntity<List<ArticleResponse>>(articleResponse,HttpStatus.OK);

		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<ArticleResponse> getOneArt(@PathVariable long id){
		
		ArticleDto articleDto = articleService.getOne(id);
		ModelMapper modelMapper = new ModelMapper();
		ArticleResponse article = modelMapper.map(articleDto, ArticleResponse.class);
		
		return new ResponseEntity<ArticleResponse>(article,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteOrder(@PathVariable long id) {
		
		articleService.deleteOrd(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{idOrder}/{id}")
	public ResponseEntity<Object> deleteFromOrder(@PathVariable long idOrder ,@PathVariable long id) {
		
		articleService.deleteFromOrd(idOrder,id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
