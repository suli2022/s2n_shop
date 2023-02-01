import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  login(user: string, pass: string) {
    let endpoint = 'signin';
    let url = environment.apihost + endpoint;

    let authData = {
      name: user,
      password: pass
    };

    // let headers = 

  }
}
