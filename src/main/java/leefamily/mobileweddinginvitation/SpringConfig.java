package leefamily.mobileweddinginvitation;

import leefamily.mobileweddinginvitation.repository.AttendanceRepository;
import leefamily.mobileweddinginvitation.repository.CommentRepository;
import leefamily.mobileweddinginvitation.repository.JdbcTemplateCommentRepository;
import leefamily.mobileweddinginvitation.repository.MemoryCommentRepository;
import leefamily.mobileweddinginvitation.service.AttendanceService;
import leefamily.mobileweddinginvitation.service.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
//    @Bean
    public CommentService commentService() {
        return new CommentService(commentRepository());
    }

//    @Bean
    public CommentRepository commentRepository() {
//        return new MemoryCommentRepository();
        return new JdbcTemplateCommentRepository(dataSource);
    }

//    @Bean
    public AttendanceService attendanceService() {
        return new AttendanceService(attendanceRepository());
    }

//    @Bean
    public AttendanceRepository attendanceRepository() {
//        return new MemoryCommentRepository();
        return new AttendanceRepository(dataSource);
    }
}
