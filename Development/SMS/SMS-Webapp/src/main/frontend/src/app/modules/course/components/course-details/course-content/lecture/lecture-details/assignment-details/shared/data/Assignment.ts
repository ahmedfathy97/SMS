export class Assignment {
  stdID: number;
  firstName: string;
  lastName: string;
  answerDate: string;
  answerID: number;
  assignID: number;
  dueDate: number;

  constructor(stdID: number, firstName: string, lastName: string, answerDate: string, answerID: number, assignID: number, dueDate: number) {
    this.stdID = stdID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.answerDate = answerDate;
    this.answerID = answerID;
    this.assignID = assignID;
    this.dueDate = dueDate;
  }
}

