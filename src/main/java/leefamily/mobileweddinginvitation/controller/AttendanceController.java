package leefamily.mobileweddinginvitation.controller;

import leefamily.mobileweddinginvitation.domain.Attendance;
import leefamily.mobileweddinginvitation.domain.Comment;
import leefamily.mobileweddinginvitation.service.AttendanceService;
import leefamily.mobileweddinginvitation.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
    public String createAttendance(@ModelAttribute Attendance attendance, HttpServletResponse response) {
        //AttendanceForm을 그냥 attendance로 해도 될 것 같은데 나중에 수정하자.
        attendanceService.writeAttendance(attendance);

        // 참석에 대한 쿠키 생성
        Cookie cookie = new Cookie("popupYN", "N");
        cookie.setDomain("kangminlovesjihye.ddns.net");
        cookie.setPath("/");
        // 30초간 저장
        cookie.setMaxAge(5*60);
        response.addCookie(cookie);

        //blank로 가면 무슨 의미..?
        //blank.html로 가는 거구나
        //blank.html에서는 팝업 창을 닫고 새로고침.
        //TODO : 이건 나중에 큰 개선이 필요할 것 같다.
        return "blank";
    }


    // 여기에 validation하는 함수를 하나 더 생성한다.
    // 그래서 통과하면 블랭크 아니면 attendanc/new로 다시 돌아간다.
    // 노놉 내가 하려는 방식은 다음 걸로 넘어갈 때 data를 넘겨주는 방식인듯..?


}
