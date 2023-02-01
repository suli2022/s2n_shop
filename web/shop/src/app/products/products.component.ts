import { Component, OnInit } from '@angular/core';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  constructor(private api: ApiService) { }

  ngOnInit(): void {
    
  }
  addProducts() {
    this.api.addProducts('aaa')
    .subscribe({
      next: data => {
        console.log('vissza: ' + data)
      },
      error: err => {
        console.log('Hiba! A termék felévtele sikertelen!')
      }
    });    
  }

}
