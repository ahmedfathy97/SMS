package com.sms.service;


import com.sms.model.AttendanceDTO;
import com.sms.model.authorization.AuthRoles;
import com.sms.model.course.StdDTO;
import com.sms.model.user.UserVTO;
import com.sms.repository.AttendanceRep;
import com.sms.repository.CourseRep;
import com.sms.repository.GradeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceSer {
    private AttendanceRep repository;
    private CourseRep rep;

    @Autowired
    public AttendanceSer(AttendanceRep repository, CourseRep rep) {
        this.repository = repository;
        this.rep = rep;
    }

//    public List<StdDTO> numberOfAttStudent(int courseID){
//
//        List<StdDTO> attendNumber = repository.numberOfAttStudent(courseID);
//                return attendNumber ;
//    }

    public void createSheet(UserVTO currentUser, int courseID, AttendanceDTO data, boolean isUpdate) throws Exception {
        boolean isInstructor = this.rep.isInstructor(currentUser.getId(), courseID);
        if (!isInstructor)
            throw new Exception("Only Course Instructor can add Attendance");

        if(data.getAttendanceData().before(new Date()))
            throw new Exception("Can't insert Attendance in the past");

        if (isUpdate == false) {
            int sheetID = this.repository.insertNewSheet(courseID, data.getAttendanceData());
            for (StdDTO student : data.getStudents())
                this.repository.insertStudentAttendance(sheetID, courseID, student);
        } else if (isUpdate == true) {
            for (StdDTO student : data.getStudents()) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                String strDate = dateFormat.format(data.getAttendanceData());
                this.repository.updateStudentAttendance(courseID, strDate, student);
            }
        }
    }

    private List<StdDTO> cloneList(List<StdDTO> students) {
        List<StdDTO> newStdList = new ArrayList<>();
        for (StdDTO std : students)
            newStdList.add(std.clone());
        return newStdList;
    }


    public List<AttendanceDTO> getCourseAttendance(UserVTO currentUser, int courseID) {
        List<StdDTO> stdList = new ArrayList<>();
        //List<StdDTO> stdList = this.rep.findAllCourseStudents(courseID);
        List<StdDTO> stdAttendance = new ArrayList<>();
        if(currentUser.getRoleIDs().contains(AuthRoles.INSTRUCTOR.getID())){
           stdList = this.rep.findAllCourseStudents(courseID , -1);
            stdAttendance = repository.viewAttendSheetInstructor(courseID,-1);}
        else if (currentUser.getRoleIDs().contains(AuthRoles.STUDENT.getID())) {
            stdAttendance = repository.viewAttendSheetInstructor(courseID, currentUser.getId());
          stdList = this.rep.findAllCourseStudents(courseID , currentUser.getId());

        }
//        List<StdDTO> stdAttendance = this.repository.viewAttendSheetInstructor(courseID);
        List<AttendanceDTO> attendanceDTOList = this.repository.numberOfAttStudent(courseID);

//        for (StdDTO i : stdAttendance) {
//            boolean isFound = false;
//            for (AttendanceDTO sheet : attendanceDTOList) {
//                if (i.getAttendanceDate().compareTo(sheet.getAttendanceData()) == 0) {
//                    isFound = true;
//                    break;
//                }
//            }
//            if (!isFound) {
//                AttendanceDTO item = new AttendanceDTO();
//                item.setAttendanceData(i.getAttendanceDate());
//                item.setStudents(cloneList(stdList));
//                attendanceDTOList.add(item);
//            }
//
//
//        }

        for (AttendanceDTO sheet : attendanceDTOList) {
            sheet.setTotalStd(stdList.size());
            sheet.setStudents(cloneList(stdList));
            for (StdDTO std : sheet.getStudents()) {
                for (StdDTO stdDto : stdAttendance)
                    if (stdDto.getAttendanceDate().compareTo(sheet.getAttendanceData()) == 0 &&
                            std.getFullName().equals(stdDto.getFullName())) {
                        std.setIsAttend(stdDto.getIsAttend());

                        break;
                    }
            }
        }
        return attendanceDTOList;
    }


    public List<AttendanceDTO> getStudentAttendance(int courseID, int stdID) {

        List<StdDTO> stdList = this.repository.findCourseStudent(courseID, stdID);
        List<StdDTO> stdAttendance = this.repository.viewAttendSheetStudent(courseID, stdID);
        List<AttendanceDTO> attendanceDTOList = new ArrayList<>();
        for (StdDTO i : stdAttendance) {
            if (attendanceDTOList.size() == 0) {
                AttendanceDTO item = new AttendanceDTO();
                List<StdDTO> newStdList = new ArrayList<>();
                for (StdDTO std : stdList)
                    newStdList.add(std.clone());
                item.setAttendanceData(i.getAttendanceDate());
                item.setStudents(newStdList);
                attendanceDTOList.add(item);
            }

            boolean isFound = false;
            for (AttendanceDTO sheet : attendanceDTOList) {
                if (i.getAttendanceDate().compareTo(sheet.getAttendanceData()) == 0) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                AttendanceDTO item = new AttendanceDTO();
                item.setAttendanceData(i.getAttendanceDate());
                item.setStudents(stdList);
                attendanceDTOList.add(item);
            }


        }

        for (AttendanceDTO sheet : attendanceDTOList) {
            for (StdDTO std : sheet.getStudents()) {
                for (StdDTO stdDto : stdAttendance)
                    if (stdDto.getAttendanceDate().compareTo(sheet.getAttendanceData()) == 0 &&
                            std.getFullName().equals(stdDto.getFullName())) {
                        std.setIsAttend(stdDto.getIsAttend());
                        break;
                    }
            }
        }


        return attendanceDTOList;
    }


}

