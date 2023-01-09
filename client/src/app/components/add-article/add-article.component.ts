import { MatDialog } from '@angular/material/dialog';
import { ArticleService } from './../../services/article.service';
import { Article } from './../../models/article';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {

  articles: Article[] = [];

  article: Article = {
    name: '',
    price: '',
    picture: ''
  }
  constructor(private articleService: ArticleService,
              private dialog: MatDialog ) { }

  ngOnInit(): void {
  }
  
  getAllArticles(){
    this.articleService.getAll().subscribe(res => this.articles = res as Article[])
  }

  addArticle(){
    this.articleService.create(this.article);
    this.article ={
      name: '',
      price: '',
      picture: '',
    }
    this.dialog.closeAll();
  }

}
