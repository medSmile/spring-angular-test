import { AddArticleComponent } from './../../add-article/add-article.component';
import { MatDialog } from '@angular/material/dialog';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  dialogAdd() {
    this.dialog.open(AddArticleComponent,{
      height: 'auto',
      width: '600px',
    })

}

}
