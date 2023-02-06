import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(user: string, pass: string) {
    let endpoint = 'signin';
    let url = environment.apihost + endpoint;

    let authData = {
      name: user,
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
}
