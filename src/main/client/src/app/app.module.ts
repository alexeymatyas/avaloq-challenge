import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SimulationControlComponent } from './simulation-control/simulation-control.component';
import { SimulationsComponent } from './simulations/simulations.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { StatisticsComponent } from './statistics/statistics.component';
import { SimulationTabsComponent } from './simulation-tabs/simulation-tabs.component';
import { StatisticsDetailsComponent } from './statistics-details/statistics-details.component';

@NgModule({
  declarations: [
    AppComponent,
    SimulationControlComponent,
    SimulationsComponent,
    StatisticsComponent,
    SimulationTabsComponent,
    StatisticsDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
