import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorLogin: boolean = false;
  validateForm!: FormGroup;

  constructor(private router:Router,private fb: FormBuilder, private authService: AuthService) {}

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
    const body = {
        email: this.validateForm.value.email,
        password: this.validateForm.value.password
    }
    this.authService.login(body).subscribe(data => {
      localStorage.setItem('jwt', data.accessToken);
      const user = data;
      localStorage.setItem('role', data.role[0].name);
      this.router.navigate(['homepage']);
    }, error => { 
      this.errorLogin = true;   
    })
  }

  

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

}
