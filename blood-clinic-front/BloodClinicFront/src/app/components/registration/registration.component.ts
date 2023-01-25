import { registerLocaleData } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  errorRegister: boolean = false;
  validateForm!: FormGroup;
 
  constructor(private router:Router,private fb: FormBuilder, private authService: AuthService) {}

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }

  const address = {
    address: this.validateForm.value.address,
    city: this.validateForm.value.city,
    country: this.validateForm.value.country
  }

  const body = {
      email: this.validateForm.value.email,
      passwordFirst: this.validateForm.value.passwordFirst,
      passwordSecond: this.validateForm.value.passwordSecond,
      phone_number: this.validateForm.value.phone_number,
      address : address,
      name: this.validateForm.value.name,
      surname: this.validateForm.value.surname,
      jmbg : this.validateForm.value.jmbg,
      job : this.validateForm.value.job,
      gender : this.validateForm.value.gender
  }
  console.log(body);
  this.authService.register(body).subscribe(data => {
    this.router.navigateByUrl(`login`);
    
  }, error => {
    this.errorRegister = true;
  })
  }

  updateConfirmValidator(): void {
    /** wait for refresh value */
    Promise.resolve().then(() => this.validateForm.controls.checkPassword.updateValueAndValidity());
  }

  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.validateForm.controls.passwordFirst.value) {
      return { confirm: true, error: true };
    }
    return {};
  };

  getCaptcha(e: MouseEvent): void {
    e.preventDefault();
  }

  

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null, [Validators.email, Validators.required]],
      passwordFirst: [null, [Validators.required]],
      passwordSecond: [null, [Validators.required, this.confirmationValidator]],
      name: [null, [Validators.required]],
      surname: [null, [Validators.required]],
      address: [null, [Validators.required]],
      phone_number: [null, [Validators.required]],
      city: [null, [Validators.required]],
      country:  [null, [Validators.required]],
      jmbg:  [null, [Validators.required]],
      job:  [null, [Validators.required]],
      gender:  [0, [Validators.required]]
    });
  }

}
