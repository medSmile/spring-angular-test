import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private url: string,private http: HttpClient) { }
  
  getAll() {
    return this.http.get(this.url);
  }

  create(resource: any) {
    return this.http.post(this.url,resource);
            
  }

  delete(resource: any) {
    return this.http.delete(this.url+'/'+resource.id);
  }

  update(resource: any) {
    return this.http.put(this.url+'/'+resource.id,resource);
  }
}
