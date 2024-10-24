import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';

export interface Address {
  postalCode: string;
  city: string;
  street: string;
}

export interface Nationality {
  nationality: string;
  countryCode: string;
}

export interface Person {
  id: string;
  lastName: string;
  firstName: string;
  birthName: string;
  motherName: string;
  gender: string;
  nationality: string;
  address: Address;
  mailingAddress: Address;
  residence: Address;
  phoneNumber: string;
  taxId: string;
  notes: string;
}

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private apiService: ApiService) {}

  personalInfo = {
    getAllPersons: (): Observable<Person[]> =>
      this.apiService.get('/api/persons'),
    getPersonById: (id: string): Observable<Person> =>
      this.apiService.get(`/api/persons/${id}`),
    createPerson: (person: Person): Observable<Person> =>
      this.apiService.post('/api/persons', person),
    updatePerson: (id: string, person: Person): Observable<Person> =>
      this.apiService.put(`/api/persons/${id}`, person),
    deletePerson: (id: string): Observable<void> =>
      this.apiService.delete(`/api/persons/${id}`),
  };
}
