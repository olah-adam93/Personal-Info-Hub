import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DataService, Person } from '../../services/data.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.scss'],
})
export class PersonFormComponent implements OnInit {
  @Output() personCreated = new EventEmitter<void>();

  personForm!: FormGroup;
  validationErrors: { [key: string]: string } = {};
  message: { text: string; show: boolean } = { text: '', show: false };

  constructor(private fb: FormBuilder, private dataService: DataService) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm() {
    this.personForm = this.fb.group({
      lastName: [''],
      firstName: [''],
      birthName: [''],
      motherName: [''],
      gender: [''],
      nationality: [''],
      address: this.createAddressGroup(),
      mailingAddress: this.createAddressGroup(),
      residence: this.createAddressGroup(),
      phoneNumber: [''],
      taxId: [''],
      notes: [''],
    });
  }

  createAddressGroup(): FormGroup {
    return this.fb.group({
      postalCode: [''],
      city: [''],
      street: [''],
    });
  }

  onSubmit() {
    if (this.personForm.valid) {
      this.trimFormValues(this.personForm);
      this.createPerson();
    }
  }

  createPerson() {
    const person: Person = this.personForm.value;
    this.dataService.personalInfo.createPerson(person).subscribe({
      next: () => {
        this.validationErrors = {}; // Clear previous validation errors
        this.personCreated.emit(); // Emit personCreated event
        this.showSuccessMessage('Person created successfully!');
        this.personForm.reset(); // Reset form
      },
      error: (errorResponse) => {
        if (errorResponse.status === 400) {
          this.setValidationErrors(errorResponse.error);
        }
      },
    });
  }

  showSuccessMessage(message: string) {
    this.message.text = message;
    this.message.show = true;

    setTimeout(() => {
      this.message.show = false;
      this.message.text = '';
    }, 5000);
  }

  trimFormValues(form: FormGroup) {
    for (const control in form.controls) {
      if (form.controls[control]) {
        const value = form.controls[control].value;
        if (typeof value === 'string') {
          form.controls[control].setValue(value.trim());
        }
      }
    }
  }

  setValidationErrors(errors: { [key: string]: string }) {
    for (const key in errors) {
      if (this.personForm.get(key)) {
        // Mark the field as invalid and set the error message
        this.personForm.get(key)?.setErrors({ serverError: errors[key] });
      }
    }
  }
}
