import {Component, OnInit} from '@angular/core';
import {QuizService} from "../../../../../shared/services/quiz.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuestionType} from "../../../../../shared/data/quiz/question-type";
import {QuestionDto} from "../../../../../shared/data/quiz/question-dto";
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../infrastructure/components/alerts/success-alert.data";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {CourseService} from "../../../../../shared/services/course.service";

@Component({
  selector: 'app-add-quiz-quiestions',
  templateUrl: './add-quiz-questions.component.html',
  styleUrls: ['./add-quiz-questions.component.scss'],
  providers: [FormBuilder, QuizService, CourseService]
})
export class AddQuizQuestionsComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  questionTypeList: QuestionType [];
  questionsList: QuestionDto[] = [];
  mcqIsSelected: boolean = false;
  corID: number ;
  trueFalseIsSelsected: boolean = false;
  table: boolean = false;
  quizId: number;
  editMode: boolean = false;
  alert: AlertInput = new AlertInput();
  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService,
              private quizService: QuizService,
              private route: ActivatedRoute,
              private corDataService: CourseDataService) {
    this.route.paramMap.subscribe(params => {
      this.quizId = +params.get("quizID");
    });

    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);

      }
    );
    this.corDataService.requestCorID.next(true);
  }



  getALLquestionsTypes() {
    this.quizService.getAllQuestionsTypes().subscribe(res => {
      console.log("Success");
      this.questionTypeList = res;
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }


  onclickoption(event: any) {
    console.log(event);
    if (event == 1) {
      this.mcqIsSelected = true;
      this.trueFalseIsSelsected = false;

    } else if (event == 2) {
      this.trueFalseIsSelsected = true;
      this.mcqIsSelected = false;
    }
    else {

    }

  }


  formData: FormGroup = this.formBuilder.group({
    questiontype: [null, [Validators.required]],
    question: [null, [Validators.required]],
    modelAnswer: [null, [Validators.required]],
    questionGrade: [null, [Validators.required]],
    answer1: null,
    answer2: null,
    answer3: null,
    answer4: null
  });
  get form() { return this.formData.controls; }

  onclickAddQuestion() {
    let questionData: QuestionDto = new QuestionDto()
    debugger;
    questionData.questionTypeID = this.formData.get('questiontype').value;
    questionData.question = this.formData.get('question').value;
    questionData.modelAnswer = this.formData.get('modelAnswer').value;
    questionData.questionGrade = this.formData.get('questionGrade').value;
    questionData.answer1 = this.formData.get('answer1').value;
    questionData.answer2 = this.formData.get('answer2').value;
    questionData.answer3 = this.formData.get('answer3').value;
    questionData.answer4 = this.formData.get('answer4').value;
    this.questionsList.push(questionData);
    this.table = true;
    this.formData.reset();
  }

  editQuestion(index) {
    this.formData.get('questiontype').reset(this.questionsList[index].questionTypeID);
    this.formData.get('question').reset(this.questionsList[index].question);
    this.formData.get('modelAnswer').reset(this.questionsList[index].modelAnswer);
    this.formData.get('answer1').reset(this.questionsList[index].answer1);
    this.formData.get('answer2').reset(this.questionsList[index].answer2);
    this.formData.get('answer3').reset(this.questionsList[index].answer3);
    this.formData.get('answer4').reset(this.questionsList[index].answer4);
    this.questionsList.splice(index, 1);
    this.editMode = true;
  }


  deleteQuestion(index) {
    this.questionsList.splice(index, 1);
  }


  onSubmitQuestionsTable() {
    this.quizService.createQuizQuestions(this.quizId, this.questionsList).subscribe(res => {
      console.log("Success");
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err)
    });
  }
  
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
    this.getALLquestionsTypes();
  }

}
