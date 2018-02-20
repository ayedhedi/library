import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { NGXLogger } from "ngx-logger";

import {Book} from "../model/book";

@Injectable()
export class ApiService {

  url: string = 'http://localhost:8000/api/library/query/books';

  constructor(private logger: NGXLogger,
              private http: HttpClient){}

  getBooks(keyword: string): Observable<Array<Book>> {
    let url = this.url;
    if (keyword) {
      this.logger.debug(`Looking for books with keyword: ${keyword}`);
      url = this.url + "?keyword="+keyword;
    }else {
      this.logger.debug(`Looking for all books !!`);
    }

    return this.http.get<Array<Book>>(url);
  }

}
