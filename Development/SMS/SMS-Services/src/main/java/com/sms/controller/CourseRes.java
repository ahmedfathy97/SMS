package com.sms.controller;

import com.sms.configuration.ConfigManager;
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
import com.sms.service.GradeSer;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Path("/course")
public class CourseRes {
    private AttendanceSer attendance;
    private CourseRep courseRep;
    private CourseSer courseSer;
    private GradeRep gradeRepository;
    private QuizRep rep;
    private StudentRep repStd;
    private GradeSer gradeService;


    @Autowired
    public CourseRes(
            GradeSer gradeService,
            CourseRep repository,
            CourseSer courseSer,
            GradeRep gradeRepository,
            AttendanceSer attendance
            , QuizRep rep, StudentRep repStd) {
        this.courseSer = courseSer;
        this.gradeRepository = gradeRepository;
        this.courseRep = repository;
        this.attendance = attendance;
        this.rep = rep;
        this.repStd = repStd;
        this.gradeService = gradeService;
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated(actions = {AuthActions.ADD_COR})
    public int createNewCourse(@Context ContainerRequestContext request, CourseDTO details) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return courseRep.insertNewCourse(currentUser.getId(), details);
    }

    @POST
    @Path("/{corID}/enroll")
    @Authenticated(actions = {AuthActions.ENROLL_STUDENT})
    public void enrollStudentByID(@PathParam("corID") int corID, @Context ContainerRequestContext request) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        repStd.insertStudent(currentUser.getId(), corID);

    }

    @GET
    @Path("/{corID}/isStudent")
    @Authenticated()
    public boolean isStudent(@PathParam("corID") int corID, @Context ContainerRequestContext request) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);

        return this.courseRep.isEnrolled(currentUser.getId(), corID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade/quizes")
    public List<StdDTO> getQuizGrades(@PathParam("courseID") int courseID) {
        List<StdDTO> list = this.gradeService.getQuizGrade(courseID);
        return list;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    @Authenticated()
    public CourseResultSet myCourses(@Context ContainerRequestContext request, @QueryParam("pageNum") int pageNum) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return this.courseSer.myCourses(currentUser, pageNum);
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
        return this.courseSer.findAllCourseStudents(courseID, gradeType, attendanceDate);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/grade")
    @Authenticated()
    public CourseResultSet getCourseGrades(@Context ContainerRequestContext request,
                                           @PathParam("courseID") int courseID, @QueryParam("pageNum") int pageNum) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return courseSer.findCourseGrades(currentUser, courseID, pageNum);
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
    public CourseResultSet getCourseLectures(@PathParam("courseID") int courseID, @QueryParam("pageNum") int pageNum) {

        return courseSer.getCourseLectures(courseID, pageNum);
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
    public List<AttendanceDTO> getCourseAttendance(@Context ContainerRequestContext request, @PathParam("courseID") int courseID) {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        System.out.print("Sucessfully");
        List<AttendanceDTO> list = this.attendance.getCourseAttendance(currentUser, courseID);
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
    public Response createAnnouncement(@Context ContainerRequestContext request, @PathParam("courseID") int courseID, Announcement announcement) {
        try {
            UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
            System.out.print("Data Recieved Sucessfully");
            System.out.print(announcement.toString());
            this.courseSer.createAnnouncement(currentUser, courseID, announcement);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseID}/announcmentList")
    @Authenticated()
    public CourseResultSet getCourseAnnouncments(@PathParam("courseID") int courseID, @QueryParam("pageNum") int pageNum) {
        return this.courseSer.getCourseAnnouncments(courseID, pageNum);
    }

    @Path("/{corID}/img")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadCourseImg(@PathParam("corID") int corID,
                                    @QueryParam("fileName") String name,
                                    @QueryParam("fileType") String type,
                                    @QueryParam("ext") String ext,
                                    @FormDataParam("file") InputStream fileContent,
                                    @FormDataParam("file") FormDataContentDisposition fileDisposition) throws IOException {

        java.nio.file.Path path = Paths.get(ConfigManager.IMAGES_PATH + "/courses/" + corID + "/courseImg/" + name);
        Files.createDirectories(Paths.get(ConfigManager.IMAGES_PATH + "/courses/" + corID + "/courseImg/"));
        Files.copy(fileContent, path);

        this.courseRep.updateCorImgByID(corID, name);

        return Response.ok().build();
    }

    @Path("/{corID}/img")
    @GET
    @Produces("image/png")
    public Response getCourseImg(@PathParam("corID") int corID) throws FileNotFoundException {
        String imgPath = this.courseRep.findCorImgByID(corID);

        File file;

        if (imgPath != null)
            file = new File(ConfigManager.IMAGES_PATH + "/courses/" + corID + "/courseImg/" + imgPath);
        else
            file = new File(ConfigManager.IMAGES_PATH + "/courses/no-course.jpg");

        if (!file.exists())
            file = new File(ConfigManager.IMAGES_PATH + "/courses/no-course.jpg");

        return Response.ok(new FileInputStream(file), MediaType.APPLICATION_OCTET_STREAM).build();
    }
}
