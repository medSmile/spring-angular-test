import { OrdersSectionComponent } from './components/partials/orders-section/orders-section.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes } from '@angular/router';
import { ArticlesComponent } from './components/partials/articles/articles.component';

const routes: Routes = [
  
  { path: "" ,redirectTo: '/articles' ,pathMatch: 'full' },
  
  { path: "articles",
    component: ArticlesComponent
  },
  
  { path: "orders",
    component: OrdersSectionComponent
  },
]


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
