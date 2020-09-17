  export interface Gender {
    genderName: string;
  }

  export interface Client {
    ownsAccount: boolean;
    visitsId: number[];
  }

  // tslint:disable-next-line:no-empty-interface
  export interface Employee {
  }

  export interface Embedded2 {
    gender: Gender;
    client: Client;
    employee: Employee;
  }

  export interface Self {
    href: string;
  }

  export interface User2 {
    href: string;
  }

  export interface Gender2 {
    href: string;
  }

  export interface Client2 {
    href: string;
  }

  export interface Employee2 {
    href: string;
  }

  export interface Links {
    self: Self;
    user: User2;
    gender: Gender2;
    client: Client2;
    employee: Employee2;
  }

  export interface User {
    firstName: string;
    lastName: string;
    address: string;
    contactNumber: string;
    otherInformation: string;
    userName: string;
    pesel: string;
    birthDate: string;
    isEmployee: boolean;
    isClient: boolean;
    _embedded: Embedded2;
    _links: Links;
  }

  export interface Embedded {
    users: User[];
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

