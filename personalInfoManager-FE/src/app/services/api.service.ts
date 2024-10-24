import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private httpClient: HttpClient) {}

  get(path: string, options?: any): Observable<any> {
    return this.httpClient.get(`${environment.serverUri}${path}`, {
      ...options,
      params: new HttpParams({
        fromObject: options?.params,
      }),
    });
  }

  post(path: string, body: any = {}, options?: any): Observable<any> {
    return this.httpClient.post(
      `${environment.serverUri}${path}`,
      body,
      options
    );
  }

  put(path: string, body: any = {}, options?: any): Observable<any> {
    return this.httpClient.put(
      `${environment.serverUri}${path}`,
      body,
      options
    );
  }

  delete(path: string, options?: any): Observable<any> {
    return this.httpClient.delete(`${environment.serverUri}${path}`, options);
  }
}
