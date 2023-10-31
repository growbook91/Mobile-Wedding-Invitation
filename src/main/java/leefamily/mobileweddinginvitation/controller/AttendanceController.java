package leefamily.mobileweddinginvitation.controller;

import leefamily.mobileweddinginvitation.domain.Attendance;
import leefamily.mobileweddinginvitation.domain.Comment;
import leefamily.mobileweddinginvitation.service.AttendanceService;
import leefamily.mobileweddinginvitation.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AttendanceController {

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    private final AttendanceService attendanceService;

    // 참석 의사 팝업 열기
    // 작성자: kklee
    @GetMapping(value = "/attendance")
    public String popup() {
        return "attendance/attendancePopup";
    }

    @GetMapping(value = "/attendance/new")
    public String createForm() {
        return "attendance/createAttendanceForm";
    }

    // 참석 여부 조사
    @PostMapping(value = "/attendance/new")
    public String create(AttendanceForm form) {
        // TODO : 여기 수정
        Attendance attendance = new Attendance();
//        attendance.setContent(form.getContent());
//        attendance.setPassword(form.getPassword());
//        attendance.setName(form.getName());
        attendanceService.writeAttendance(attendance);
        return "blank";
    }
}
