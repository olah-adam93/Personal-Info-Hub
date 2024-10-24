import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DataService, Person } from '../../services/data.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.scss'],
})
export class PersonListComponent {
  @Input() persons: Person[] = [];
  @Output() personDeleted = new EventEmitter<void>();

  selectedPerson: Person | null = null;

  constructor(private dataService: DataService) {}

  selectPerson(person: Person) {
    this.selectedPerson = this.selectedPerson?.id === person.id ? null : person;
  }

  deletePerson(personId: string) {
    this.dataService.personalInfo.deletePerson(personId).subscribe({
      next: (response: any) => {
        this.handleDeleteSuccess(response, personId);
      },
      error: (errorResponse) => {
        this.handleDeleteError(errorResponse);
      },
    });
  }

  private handleDeleteSuccess(response: any, personId: string) {
    this.personDeleted.emit();
    if (this.selectedPerson?.id === personId) {
      this.selectedPerson = null;
    }
  }

  private handleDeleteError(errorResponse: any) {
    console.error('Error deleting person:', errorResponse);
  }
}
