import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2'
import { timer } from 'rxjs';


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
      timer(3000);
      console.log()
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
        localStorage.setItem('role', data.role[0].name);
        console.log(localStorage.getItem('jwt'));
        Swal.fire('Sucess login!', 'success').then((result) => {this.router.navigate(['homepage']);});
        
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
