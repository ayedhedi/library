import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';
import { ApiService} from "../shared/service/api.service";
import { Book} from "../shared/model/book";
import 'rxjs/Rx';

@Component({
  selector: 'books',
  templateUrl: 'books.component.html',
  styleUrls: ['books.component.css'],
  providers: [NGXLogger, ApiService]
})
export class BooksComponent implements OnInit {

  books: Book[];
  selectedBook: Book;
  keyword: string;

  constructor(private logger: NGXLogger,
              private api: ApiService) { }

  ngOnInit() {
  }

  search() {
    this.api.getBooks(this.keyword).subscribe(response => {
      this.books = response.map(b => {return new Book(b);})
    });
  }

  view(book: Book){
    this.selectedBook = book;
  }
}
