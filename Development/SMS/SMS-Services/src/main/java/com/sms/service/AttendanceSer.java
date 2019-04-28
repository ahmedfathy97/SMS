package com.sms.service;


import com.sms.model.AttendanceDTO;
import com.sms.model.course.StdDTO;
import com.sms.repository.AttendanceRep;
import com.sms.repository.CourseRep;
import com.sms.repository.GradeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public void createSheet(int courseID, AttendanceDTO data , boolean isUpdate ) {
        if (isUpdate == false) {
            int sheetID = this.repository.insertNewSheet(courseID, data.getAttendanceData());
            for (StdDTO student : data.getStudents())
                this.repository.insertStudentAttendance(sheetID, courseID, student);
        } else if(isUpdate == true) {
            for (StdDTO student : data.getStudents()) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                String strDate = dateFormat.format(data.getAttendanceData());
                this.repository.updateStudentAttendance(courseID,strDate,student);
            }
        }
    }

    private List<StdDTO> cloneList(List<StdDTO> students){
        List<StdDTO> newStdList = new ArrayList<>();
        for (StdDTO std : students )
            newStdList.add(std.clone());
        return newStdList;
    }
    public List<AttendanceDTO> getCourseAttendance(int courseID) {

        List<StdDTO> stdList = this.rep.findAllCourseStudents(courseID);
        List<StdDTO> stdAttendance = this.repository.viewAttendSheetInstructor(courseID);
        List<AttendanceDTO> attendanceDTOList = new ArrayList<>();


//        if(attendanceDTOList.size() == 0) {
//            AttendanceDTO item = new AttendanceDTO();
//            item.setAttendanceData(i.getAttendanceDate());
//            item.setStudents(cloneList(stdList));
//            attendanceDTOList.add(item);
//        }

        for (StdDTO i : stdAttendance) {
            boolean isFound = false ;
            for (AttendanceDTO sheet : attendanceDTOList) {
                if (i.getAttendanceDate().compareTo(sheet.getAttendanceData())== 0 ) {
                    isFound = true ;
                    break;
                }
            }
            if (!isFound)
            {
                AttendanceDTO item = new AttendanceDTO();
                item.setAttendanceData(i.getAttendanceDate());
                item.setStudents(cloneList(stdList));
//                item.setStudents(stdList);
                attendanceDTOList.add(item);
            }


        }

        for(AttendanceDTO sheet:attendanceDTOList){
            for(StdDTO std: sheet.getStudents()){
                for(StdDTO stdDto: stdAttendance)
                    if(stdDto.getAttendanceDate().compareTo(sheet.getAttendanceData())== 0 &&
                            std.getFullName().equals(stdDto.getFullName())) {
                        std.setIsAttend(stdDto.getIsAttend());
                        break;
                    }
            }
            System.out.println(sheet);
            System.out.println("");
        }


        System.out.println(attendanceDTOList);
       return attendanceDTOList ;
    }



    public List<AttendanceDTO> getStudentAttendance(int courseID , int stdID) {

        List<StdDTO> stdList = this.repository.findCourseStudent(courseID,stdID);
        List<StdDTO> stdAttendance = this.repository.viewAttendSheetStudent(courseID , stdID);
        List<AttendanceDTO> attendanceDTOList = new ArrayList<>();
        for (StdDTO i : stdAttendance) {
            if(attendanceDTOList.size() == 0)
            {
                AttendanceDTO item = new AttendanceDTO();
                List<StdDTO> newStdList = new ArrayList<>();
                for (StdDTO std : stdList )
                    newStdList.add(std.clone());
                item.setAttendanceData(i.getAttendanceDate());
                item.setStudents(newStdList);
                attendanceDTOList.add(item);
            }

            boolean isFound = false ;
            for (AttendanceDTO sheet : attendanceDTOList) {
                if (i.getAttendanceDate().compareTo(sheet.getAttendanceData())== 0 ) {
                    isFound = true ;
                    break;
                }
            }
            if (!isFound)
            {
                AttendanceDTO item = new AttendanceDTO();
                item.setAttendanceData(i.getAttendanceDate());
                item.setStudents(stdList);
                attendanceDTOList.add(item);
            }


        }

        for(AttendanceDTO sheet:attendanceDTOList){
            for(StdDTO std: sheet.getStudents()){
                for(StdDTO stdDto: stdAttendance)
                    if(stdDto.getAttendanceDate().compareTo(sheet.getAttendanceData())== 0 &&
                            std.getFullName().equals(stdDto.getFullName())) {
                        std.setIsAttend(stdDto.getIsAttend());
                        break;
                    }
            }
        }


        return attendanceDTOList ;
    }




}

