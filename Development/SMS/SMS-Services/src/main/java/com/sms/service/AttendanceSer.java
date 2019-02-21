package com.sms.service;


import com.sms.model.AttendanceDTO;
import com.sms.model.course.StdDTO;
import com.sms.repository.AttendanceRep;
import com.sms.repository.CourseRep;
import com.sms.repository.GradeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createSheet(int courseID, AttendanceDTO data) {
        int sheetID = this.repository.insertNewSheet(courseID, data.getAttendanceData());
        for(StdDTO student: data.getStudents())
            this.repository.insertStudentAttendance(sheetID, courseID, student);

    }

    public List<AttendanceDTO> getCourseAttendance(int courseID) {

        List<StdDTO> stdList = this.rep.findAllCourseStudents(2);
        List<StdDTO> stdAttendance = this.repository.viewAttendSheetInstructor(courseID);
        List<AttendanceDTO> attendanceDTOList = new ArrayList<>();
        for (StdDTO i : stdAttendance) {
            if(attendanceDTOList.size() == 0)
            {
                AttendanceDTO item = new AttendanceDTO();
                item.setAttendanceData(i.getAttendanceDate());
                item.setStudents(stdList);
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
                    if(stdDto.getAttendanceDate() == sheet.getAttendanceData() &&
                            std.getFullName().equals(stdDto.getFullName()))
                        std.setIsAttend(stdDto.getIsAttend());
            }
        }


       return attendanceDTOList ;
    }

    public List<AttendanceDTO> getStudentAttendance(int courseID , int stdID) {

        List<StdDTO> stdList = this.rep.findAllCourseStudents(2);
        List<StdDTO> stdAttendance = this.repository.viewAttendSheetStudent(courseID ,stdID);
        List<AttendanceDTO> attendanceList = new ArrayList<>();
        for (StdDTO std : stdAttendance) {
            if(attendanceList.size() == 0)
            {
                AttendanceDTO item = new AttendanceDTO();
                item.setAttendanceData(std.getAttendanceDate());
                item.setStudents(stdList);
                attendanceList.add(item);
            }

            boolean isFound = false ;
            for (AttendanceDTO sheet : attendanceList) {
                if (std.getAttendanceDate().compareTo(sheet.getAttendanceData())== 0 ) {
                    isFound = true ;
                    break;
                }
            }
            if (!isFound)
            {
                AttendanceDTO item = new AttendanceDTO();
                item.setAttendanceData(std.getAttendanceDate());
                item.setStudents(stdList);
                attendanceList.add(item);
            }


        }

        for(AttendanceDTO sheet:attendanceList){
            for(StdDTO std: sheet.getStudents()){
                for(StdDTO stdDto: stdAttendance)
                    if(stdDto.getAttendanceDate() == sheet.getAttendanceData() &&
                            std.getFullName().equals(stdDto.getFullName()))
                        std.setIsAttend(stdDto.getIsAttend());
            }
        }


        return attendanceList ;
    }




}

