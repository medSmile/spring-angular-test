import { OrderService } from './../../../services/order.service';
import { Order } from './../../../models/order';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orders-section',
  templateUrl: './orders-section.component.html',
  styleUrls: ['./orders-section.component.css']
})
export class OrdersSectionComponent implements OnInit {

  orders: Order [] = [];

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
  }

  getAllOrders(){
    this.orderService.getAll().subscribe(res => this.orders = res as Order[])
  }

  editOrder(order: Order){
    this.orderService.update(order)
  }

}
