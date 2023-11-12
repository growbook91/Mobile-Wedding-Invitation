package leefamily.mobileweddinginvitation.repository;

import leefamily.mobileweddinginvitation.domain.Attendance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;

public class AttendanceRepository {

    private final JdbcTemplate jdbcTemplate;

    public AttendanceRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Attendance create(Attendance attendance) {
        // ID 자동 부여
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("attendance").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("name", attendance.getName());
        parameters.put("companionName", attendance.getCompanionName());
        parameters.put("side", attendance.getSide());
        parameters.put("food", attendance.getFood());
        parameters.put("totalNum", attendance.getTotalNum());

        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        attendance.setId(key.longValue());
        return attendance;
    }


//    public List<Attendance> findAll() {
//        return jdbcTemplate.query("select * from attendance", AttendanceRowMapper());
//    }

//    private RowMapper<Attendance> AttendanceRowMapper() {
//        return (rs, rowNum) -> {
//            Attendance attendance = new Attendance();
//            attendance.setId(rs.getLong("id"));
//
//            return attendance;
//        };
//    }
}
