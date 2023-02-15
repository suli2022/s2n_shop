import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(email: string, pass: string) {
    let endpoint = 'login';
    let url = environment.apihost + endpoint;

    let authData = {
      email: email,
      password: pass
    };

    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });

    let httpOption = {
      headers: headers
    };
    return this.http.post<any>(url, authData, httpOption);
  }
  logout() {
    let endpoint = 'logout';
    let url = environment.apihost + endpoint;
    let token = localStorage.getItem('token');
    localStorage.removeItem('token');
    let headers = new HttpHeaders({
      'Content-Type': 'applicaton/json',
      'Authorization': 'Bearer ' + token
    });
    let httpOption = {
      headers: headers
    };
    return this.http.post(url, "", httpOption);
  }
  isLoggedIn():any {
    if(localStorage.getItem('token') === null) {
      return false;
    }
    let token = localStorage.getItem('token');
    return token;
  }
}
