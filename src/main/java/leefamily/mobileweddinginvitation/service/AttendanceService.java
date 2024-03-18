package leefamily.mobileweddinginvitation.service;

import leefamily.mobileweddinginvitation.domain.Attendance;
import leefamily.mobileweddinginvitation.domain.Comment;
import leefamily.mobileweddinginvitation.repository.AttendanceRepository;
import leefamily.mobileweddinginvitation.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository){
        this.attendanceRepository = attendanceRepository;
    }

    public void writeAttendance(Attendance attendance){
        validateInputs(attendance);
        attendanceRepository.create(attendance);
    }

    private void validateInputs(Attendance attendance){
        //  TODO: validation이 실패하면 메세지가 model attribute에 추가되게..!
        if(attendance.getSide() == null){
            throw new IllegalArgumentException("구분을 선택해주세요.");
        }
        else if(attendance.getName() == null){
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        else if(attendance.getFood() == null){
            throw new IllegalArgumentException("식사여부를 선택해주세요.");
        }

        else if(attendance.getCompanionName() == null){
            attendance.setCompanionName("");
        }

        else if(attendance.getTotalNum() == null){
            attendance.setTotalNum(0);
        }
    }

}
