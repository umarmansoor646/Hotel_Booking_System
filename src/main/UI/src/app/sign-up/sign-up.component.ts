import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  signUpForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) {
    this.signUpForm = this.fb.group({
      name: [''],
      email: [''],
      password: ['']
    });
  }

  onSignUp() {
    // Implement your sign-up logic here
    console.log(this.signUpForm.value);
    this.router.navigate(['/sign-in']);
  }
}
