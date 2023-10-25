package leefamily.mobileweddinginvitation.repository;

import leefamily.mobileweddinginvitation.domain.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;

public class JdbcTemplateCommentRepository implements CommentRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCommentRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Comment create(Comment comment) {
        // ID 자동 부여 + 날짜 자동 부여
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("comment").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();

        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
        comment.setDate(date.format(new Date()));

        parameters.put("name", comment.getName());
        parameters.put("content", comment.getContent());
        parameters.put("password", comment.getPassword());
        parameters.put("date", comment.getDate());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        comment.setId(key.longValue());
        return comment;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update("delete from comment where id = ?", id) > 0;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        List<Comment> result = jdbcTemplate.query("select * from comment where id = ?", commentRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public List<Comment> findAll() {
        return jdbcTemplate.query("select * from comment", commentRowMapper());
    }

    private RowMapper<Comment> commentRowMapper() {
        return (rs, rowNum) -> {
            Comment comment = new Comment();
            comment.setId(rs.getLong("id"));
            comment.setName(rs.getString("name"));
            comment.setContent(rs.getString("content"));
            comment.setDate(rs.getString("date"));
            comment.setPassword(rs.getString("password"));
            return comment;
        };
    }
}
