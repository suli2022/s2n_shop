import { Component, OnInit } from '@angular/core';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {
  products !: any;
  constructor(private api: ApiService) { }

  ngOnInit(): void {
    this.getProducts();
  }
  getProducts() {
    this.api.getProducts().subscribe({
      next: (result) => {
        console.log(result)
        this.products = result;
      },
      error: (err) => {}
    })
  }
}
