package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceImpl;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final MealService service;

    @Autowired
    public MealRestController(MealServiceImpl service) {
        this.service = service;
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        checkNew(meal);
        return service.create(meal);
    }

    public void delete(int id) throws NotFoundException {
        log.info("delete {}", id);
        service.delete(id);
    }

    public Meal get(int id) throws NotFoundException {
        log.info("get {}", id);
        return service.get(id);
    }

    public void update(Meal meal) {
        log.info("update {}", meal);
        assureIdConsistent(meal, meal.getId());
        service.update(meal);
    }

    public Collection<Meal> getAll() {
        log.info("getAll");
        return service.getAll();
    }

}