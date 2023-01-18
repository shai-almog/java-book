package com.debugagent.demo.db;

import com.debugagent.demo.dto.ExerciseDTO;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
@Transactional
public class DBAccess {
    private final DataSource dataSource;

    @PostConstruct
    public void initDB() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute(
         """
             CREATE TABLE EXERCISES (
             id INT PRIMARY KEY IDENTITY,
             question VARCHAR(255),
             correctAnswer VARCHAR(255))
             """);
        jdbcTemplate.execute(
        """
            CREATE TABLE ANSWERS (
            id INT PRIMARY KEY IDENTITY,
            exercise_id INT NOT NULL,
            answer VARCHAR(255),
            FOREIGN KEY (exercise_id) REFERENCES EXERCISES(id))
            """);

        // This won't work since we need the primary key...
        //jdbcTemplate.update("INSERT INTO EXERCISES (question, correctAnswer) values (?, ?)",
        //        "1/2 * 1/2 =", "1/4");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            var preparedStatement =
                    con.prepareStatement("INSERT INTO EXERCISES (question, correctAnswer) values (?, ?)");
            preparedStatement.setString(1, "1/2 * 1/2 =");
            preparedStatement.setString(2, "1/4");
            return preparedStatement;
        }, keyHolder);
        var key = keyHolder.getKey();

        // key can be null, the following code will fail
        /*String query = "INSERT INTO ANSWERS (exercise_id, answer) values (?, ?)";
        jdbcTemplate.update(query, key, "2/2");
        jdbcTemplate.update(query, key, "1/2");
        jdbcTemplate.update(query, key, "1/8");*/
    }
}
