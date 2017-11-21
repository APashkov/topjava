package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() throws Exception {
        service.get(START_SEQ+2, START_SEQ);
    }

    @Test
    public void delete() throws Exception {
        service.delete(START_SEQ+2, START_SEQ);
    }

    @Test
    public void getBetweenDates() throws Exception {
        service.getBetweenDates(LocalDate.of(2017, 11, 19), LocalDate.of(2017,
                11,21), START_SEQ);
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        service.getBetweenDateTimes(LocalDateTime.of(2017, 11, 19,8, 00),
                LocalDateTime.of(2017, 11, 20, 18, 00), START_SEQ);
    }

    @Test
    public void getAll() throws Exception {
        service.getAll(START_SEQ);
    }

    @Test
    public void update() throws Exception {
        Meal updated = new Meal(null, LocalDateTime.now(),"NewMeal", 1000);
        service.update(updated, START_SEQ);
    }
/*
    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "registered", "roles");
    }
*/
    @Test
    public void create() throws Exception {
        Meal newMeal = new Meal(null, LocalDateTime.now(),"NewMeal", 1000);
        Meal created = service.create(newMeal, START_SEQ);
        newMeal.setId(created.getId());
        //assertThat(newMeal).isEqualToIgnoringGivenFields(newMeal, "date_time");
    }
}