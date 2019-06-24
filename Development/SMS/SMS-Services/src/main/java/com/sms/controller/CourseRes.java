package com.sms.controller;

import com.sms.controller.filter.AuthenticationFilter;
import com.sms.model.AttendanceDTO;
import com.sms.model.annotation.Authenticated;
import com.sms.model.authorization.AuthViews;
import com.sms.model.authorization.AuthActions;
import com.sms.model.course.*;
import com.sms.model.course.quiz.QuizDTO;
import com.sms.model.user.UserVTO;
import com.sms.repository.CourseRep;
import com.sms.repository.QuizRep;
import com.sms.repository.StudentRep;
import com.sms.service.AttendanceSer;
import com.sms.repository.GradeRep;
import com.sms.service.CourseSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/course")
public class CourseRes {
    private AttendanceSer attendance;
    private CourseRep courseRep;
    private CourseSer courseSer;
    private GradeRep gradeRepository;
    private QuizRep rep;
    private StudentRep repStd;


    @Autowired
    public CourseRes(
            CourseRep repository,
            CourseSer courseSer,
            GradeRep gradeRepository,
            AttendanceSer attendance
            , QuizRep rep,StudentRep repStd) {
        this.courseSer = courseSer;
        this.gradeRepository = gradeRepository;
        this.courseRep = repository;
        this.attendance = attendance;
        this.rep = rep;
        this.repStd=repStd;
    }



    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated(actions = {AuthActions.ADD_COR})
    public int createNewCourse(@Context ContainerRequestContext request, CourseDTO details) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
return 5;
//         return  courseRep.insertNewCourse(currentUser.getId() , details);
    }

    @POST
    @Path("/{corID}/enroll")
    @Authenticated(actions = {AuthActions.ENROLL_STUDENT})
    public void enrollStudentByID(@PathParam("corID") int corID, @Context ContainerRequestContext request){
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        repStd.insertStudent(currentUser.getId(),corID);

    }

    @GET
    @Path("/{corID}/isStudent")
    @Authenticated()
    public boolean isStudent(@PathParam("corID") int corID,@Context ContainerRequestContext request){
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);

         return this.courseRep.isEnrolled(currentUser.getId(),corID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    @Authenticated()
//    public CourseResultSet findAllCourses(@Context ContainerRequestContext request) {
//    @Authenticated()
//    @Authenticated(views = {AuthViews.CREATE_LEC})
    public CourseResultSet myCourses(@Context ContainerRequestContext request,@QueryParam("pageNum") int pageNum) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return this.courseSer.myCourses(currentUser,pageNum);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    @Authenticated()
    public CourseResultSet findAllCourses(@QueryParam("pageNum") int pageNum) {

        return this.courseSer.findALLCourses(pageNum);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{corID}")
    public CourseVTO viewCourse(@PathParam("corID") int corID) {
        CourseVTO viewData = this.courseRep.findByID(corID);
        return viewData;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/students")
    public List<StdDTO> findCourseStudents(
            @PathParam("courseID") int courseID,
            @QueryParam("gradeType") String gradeType,
            @QueryParam("attendanceDate") String attendanceDate) {
        return this.courseSer.findAllCourseStudents(courseID , gradeType , attendanceDate );
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade")
    public List<StdDTO> getCourseGrades(@PathParam("courseID") int courseID,@QueryParam("pageNum") int pageNum) {
        List<StdDTO> list = this.gradeRepository.findCourseGrades(courseID, pageNum);
        return list;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade/student/{studentID}")
    public StdDTO getStudentGrades(@PathParam("courseID") int courseID, @PathParam("studentID") int studentID) {
        StdDTO list = this.gradeRepository.findStudentGrades(courseID, studentID);
        return list;

    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{instructorID}/courses")
//    public List<CourseVTO> findInstructorCourses(@PathParam("instructorID") int instructorID) {
//        List<CourseVTO> list = this.courseRep.findAllInstructorCourses(instructorID);
//        return list;
//    }



    @POST
    @Path("/{courseID}/lecture")
    @Consumes(MediaType.APPLICATION_JSON)
    @Authenticated(actions = {AuthActions.ADD_LEC})
    public void createNewLecture(@PathParam("courseID") int courseID, LectureDTO lectureDTO) {
        courseRep.insertNewLecture(courseID, lectureDTO);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/lectures")
    public List<LectureVTO> getCourseLectures(@PathParam("courseID") int courseID) {
        List<LectureVTO> lectureVTOList = courseSer.getCourseLectures(courseID);
        return lectureVTOList;
    }


    @POST
    @Path("/{courseID}/newQuiz")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated(actions = {AuthActions.CREATE_QUIZ})
    public int createQuiz(@PathParam("courseID") int courseID, QuizDTO quizData) {
        return courseSer.createQuiz(courseID, quizData);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/quizes")
    @Authenticated(views = {AuthViews.COURSE_QUIZES})
    public List<CourseQuizesVTO> getCourseQuizes(@PathParam("courseID") int courseID) {
        List<CourseQuizesVTO> courseQuizesVTOList = courseSer.getCourseQuizes(courseID);
        return courseQuizesVTOList;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/exams")
    @Authenticated(views = {AuthViews.COURSE_EXAMS})
    public List<CourseExamsVTO> getCourseExams(@PathParam("courseID") int courseID) {
        List<CourseExamsVTO> courseExamsVTOList = courseSer.getCourseExams(courseID);
        return courseExamsVTOList;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/attendance")
    @Authenticated(views = {AuthViews.ADD_ATTENDANCE})
    public List<AttendanceDTO> getCourseAttendance(@PathParam("courseID") int courseID) {
        System.out.print("Sucessfully");
        List<AttendanceDTO> list = this.attendance.getCourseAttendance(courseID);
        return list;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/student/{stdID}")
    public List<AttendanceDTO> getStudentAttendance(@PathParam("courseID") int courseID, @PathParam("stdID") int stdID) {
        System.out.print("Sucessfully");
        List<AttendanceDTO> list = this.attendance.getStudentAttendance(courseID, stdID);
        return list;
    }




    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/newAnnouncment")
    @Authenticated(actions = {AuthActions.COR_ADD_ANNOUNCEMENT})
    public Response createAnnouncement(@Context ContainerRequestContext request,@PathParam("courseID") int courseID, Announcement announcement) {
        try {
            UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
            System.out.print("Data Recieved Sucessfully");
            System.out.print(announcement.toString());
            this.courseSer.createAnnouncement(currentUser,courseID, announcement);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/announcmentList")
    @Authenticated(views = {AuthViews.ADD_ATTENDANCE})
    public List<Announcement> getCourseAnnouncments(@PathParam("courseID") int courseID,@QueryParam("pageNum") int pageNum )
    {
        List<Announcement> announcementList = courseSer.getCourseAnnouncments(courseID , pageNum ) ;
        return announcementList ;
    }
//    public List<Announcement> getCourseAnnouncments(@PathParam("courseID") int courseID )
//    {
//        List<Announcement> announcementList = courseSer.getCourseAnnouncments(courseID ) ;
//        return announcementList ;
//    }



}
