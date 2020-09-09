 export interface ClientIdentificator {
    isInUse: boolean;
  }

 export interface AquaparkAttractionUsage {
    timeSpendInMinutes: number;
    enteringTime: string;
    leavingTime: string;
  }

 export interface Client {
    ownsAccount: boolean;
    visitsId: number[];
  }

 export interface Embedded2 {
    clientIdentificator: ClientIdentificator;
    aquaparkAttractionUsages: AquaparkAttractionUsage[];
    client: Client;
  }

 export interface Self {
    href: string;
  }

 export interface Visit2 {
    href: string;
  }

 export interface ClientIdentificator2 {
    href: string;
  }

 export interface AquaparkAttractionUsages {
    href: string;
  }

 export interface Client2 {
    href: string;
  }

 export interface Links {
    self: Self;
    visit: Visit2;
    clientIdentificator: ClientIdentificator2;
    aquaparkAttractionUsages: AquaparkAttractionUsages;
    client: Client2;
  }

 export interface Visit {
    date: string;
    startTime: string;
    endTime: string;
    value: number;
    identificatorId: number;
    hasEnded: boolean;
    _embedded: Embedded2;
    _links: Links;
  }

 export interface Embedded {
    visits: Visit[];
  }

 export interface Self2 {
    href: string;
    templated: boolean;
  }

 export interface Profile {
    href: string;
  }

 export interface Search {
    href: string;
  }

 export interface Links2 {
    self: Self2;
    profile: Profile;
    search: Search;
  }

 export interface Page {
    size: number;
    totalElements: number;
    totalPages: number;
    number: number;
  }

 export interface RootObject {
    _embedded: Embedded;
    _links: Links2;
    page: Page;
  }

