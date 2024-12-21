import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from 'src/app/services/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  data = {
    to : "",
    subject: "",
    message: ""
  }
  flag = false;

  constructor(private email:EmailService, private snak:MatSnackBar) { }

  ngOnInit(): void {
  }

  doSubmitForm() {
    console.log("try to submit the form");
    console.log("data", this.data);
    if (this.data.to=='' || this.data.message==''||this.data.subject=='') {
      this.snak.open("fields can not be empty!!", "OK");
      return;
    }
    this.flag=true;
    this.email.sendEmail(this.data).subscribe(Response=>{
      console.log(Response);
      this.flag=false;
      this.snak.open("Sent Successfully!!", "OK")
    },
    error => {
      console.log(error);
      this.flag=false;
      this.snak.open("Something went wrong!!", "OK")
    }
  )
  }
}
