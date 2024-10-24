import { Component, OnDestroy, OnInit } from '@angular/core';
import { DataService, Person } from '../services/data.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss'],
})
export class LayoutComponent implements OnInit, OnDestroy {
  persons: Person[] = [];
  private subscription: Subscription = new Subscription();

  constructor(private dataService: DataService) {}

  ngOnInit(): void {
    this.loadPersons();
  }

  loadPersons() {
    this.subscription.add(
      this.dataService.personalInfo.getAllPersons().subscribe({
        next: (data: Person[]) => {
          this.persons = data;
        },
        error: (error) => {
          console.error('Error loading persons:', error);
        },
      })
    );
  }

  onPersonCreated() {
    this.loadPersons();
  }

  onPersonDeleted() {
    this.loadPersons();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
