package leefamily.mobileweddinginvitation.service;

import leefamily.mobileweddinginvitation.domain.Attendance;
import leefamily.mobileweddinginvitation.domain.Comment;
import leefamily.mobileweddinginvitation.repository.AttendanceRepository;
import leefamily.mobileweddinginvitation.repository.CommentRepository;

public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    public AttendanceService(AttendanceRepository attendanceRepository){
        this.attendanceRepository = attendanceRepository;
    }

    public void writeAttendance(Attendance attendance){
        validateInputs(attendance);
        attendanceRepository.create(attendance);
    }

    private void validateInputs(Attendance attendance){
        //  TODO: validation이 실패하면 팝업 창이 떠야 함..
//        if(attendance.getSide().isEmpty()){
//            throw new IllegalArgumentException("구분을 선택해주세요.");
//        }
        if(attendance.getName().isEmpty()){
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        else if(attendance.getTotalNum() == 0){
            throw new IllegalArgumentException("참석인원을 입력해주세요.");
        }
//        else if(attendance.getFood().isEmpty()){
//            throw new IllegalArgumentException("식사여부를 선택해주세요.");
//        }
    }

}
