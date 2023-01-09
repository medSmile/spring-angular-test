import { environment } from './../../environments/environment.prod';
import { DataService } from './data.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService extends DataService{

  constructor(http: HttpClient) {
  super(`${environment.apiUrl}`,http)

   }
}
