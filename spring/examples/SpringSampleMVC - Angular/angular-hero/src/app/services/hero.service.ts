import { Injectable } from '@angular/core';

import { Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import { Hero } from '../models/hero.model';
import { ClientMessage } from '../models/client-message.model';
import { HERO_URL } from '../../environments/environment';

@Injectable()
export class HeroService {

  constructor(private http: HttpClient) { }

  public registerHero(hero: Hero): Observable<ClientMessage> {
    return this.http
            .post(`${HERO_URL}register`, hero)
            .catch(this.handleError);
  }

  public findHero(hero: Hero): Observable<Hero> {
    return this.http
            .post(`${HERO_URL}findHero`, hero)
            .catch(this.handleError);
  }

  public findAllHeroes(): Observable<Hero[]> {
    return this.http
            .get(`${HERO_URL}findAllHeroes`)
            .catch(this.handleError);
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }
}
