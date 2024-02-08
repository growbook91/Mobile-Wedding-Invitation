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
        Attendance attendance = new Attendance();
        attendance.setSide(form.getSide());
        attendance.setName(form.getName());
        attendance.setTotalNum(form.getTotalNum());
        attendance.setCompanionName(form.getCompanionName());
        attendance.setFood(form.getFood());
        attendanceService.writeAttendance(attendance);
        return "blank";
    }

    //그냥 팝업 화면 여기에 하나 추가
    @GetMapping(value = "/attendance/imgPopup")
    public String imgPopup()
    {
        return "attendance/attendancePopup";
    }
}
