import {Component, Input} from '@angular/core';

declare var jQuery: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @Input() title: string;

  constructor() {
    this.title = 'DebuggerLabs';
  }

}
