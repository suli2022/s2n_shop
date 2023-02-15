import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  productForm !: FormGroup;
  products:any = [];
  constructor(
    private api: ApiService,
    private formBuilder: FormBuilder
    ) { }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      inputId: [''],
      inputName: ['', Validators.required],
      inputItemnumber: [''],
      inputQuantity: [''],
      inputPrice: ['']
    });
    this.getProducts();
  }
  getProducts() {
    this.api.getProducts().subscribe({
      next: (products:any) => {        
        this.products = products;
      },
      error: (err) => {
        console.log('Hiba! A REST API lekérdezés sikertelen!');
        console.log(err);
      }
    });
  }
  onClick() {
    this.addProduct();
  }
  addProduct() {
    let data = {
      name: this.productForm.value.inputName,
      itemnumber: this.productForm.value.inputItemnumber,
      quantity: this.productForm.value.inputQuantity,
      price: this.productForm.value.inputPrice
    };
    this.clearField();
    this.api.addProduct(data)
    .subscribe({
      next: (data:any) => {
        console.log('vissza: ' + data);
        this.getProducts();
      },
      error: (err:any) => {
        console.log('Hiba! A termék felévtele sikertelen!')
      }
    });
  }

  clearField() {
    this.productForm.patchValue({
        inputName: '', 
        inputItemnumber: '',
        inputQuantity: '',
        inputPrice: ''
      });
  }

  deleteProduct(id: number) {
    this.api.deleteProduct(id).subscribe({
      next: (res) => {
        console.log(res);
        this.getProducts();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  editProduct(product: any) {
    this.productForm.patchValue({inputId: product.id});
    this.productForm.patchValue({inputName: product.name});
    this.productForm.patchValue({inputItemnumber: product.itemnumber});
    this.productForm.patchValue({inputQuantity: product.quantity});
    this.productForm.patchValue({inputPrice: product.price});
  }
  updateProduct() {
    let data = {
      name: this.productForm.value.inputName,
      itemnumber: this.productForm.value.inputItemnumber,
      quantity: this.productForm.value.inputQuantity,
      price: this.productForm.value.inputPrice
    };    
  }

}
