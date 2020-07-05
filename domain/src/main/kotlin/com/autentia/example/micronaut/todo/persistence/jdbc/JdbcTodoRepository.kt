package com.autentia.example.micronaut.todo.persistence.jdbc

import com.autentia.example.micronaut.todo.Todo
import com.autentia.example.micronaut.todo.persistence.TodoRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.time.LocalDateTime
import javax.inject.Singleton

@Singleton
internal class JdbcTodoRepository(private val jdbcTemplate: JdbcTemplate) : TodoRepository {

    override fun findAll(): List<Todo> = jdbcTemplate.query(SELECT_ALL, TODO_ROW_MAPPER)

    override fun findBy(id: Int): Todo? = jdbcTemplate.queryForObject(SELECT_BY_ID, TODO_ROW_MAPPER, id)

    private companion object {
        private const val TABLE = "Todo"
        private const val ALL_COLUMNS = "id, title, creationDate, doneDate"
        private const val SELECT_ALL = "select $ALL_COLUMNS from $TABLE order by creationDate asc"
        private const val SELECT_BY_ID = "select $ALL_COLUMNS from $TABLE where id=?"

        private val TODO_ROW_MAPPER = RowMapper { rs: ResultSet, rowNum: Int ->
            Todo(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getObject("creationDate", LocalDateTime::class.java),
                rs.getObject("doneDate", LocalDateTime::class.java)
            )
        }
    }

}
