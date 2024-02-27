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
        //AttendanceForm을 그냥 attendance로 해도 될 것 같은데 나중에 수정하자.
        Attendance attendance = new Attendance();
        attendance.setSide(form.getSide());
        attendance.setName(form.getName());
        attendance.setTotalNum(form.getTotalNum());
        attendance.setCompanionName(form.getCompanionName());
        attendance.setFood(form.getFood());
        attendanceService.writeAttendance(attendance);

        return "blank";
    }

    // 여기에 validation하는 함수를 하나 더 생성한다.
    // 그래서 통과하면 블랭크 아니면 attendanc/new로 다시 돌아간다.
    // 노놉 내가 하려는 방식은 다음 걸로 넘어갈 때 data를 넘겨주는 방식인듯..?


}
