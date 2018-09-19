package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/students")
public class WebController {

    @Autowired
    private StudentService service;

    @PostMapping()
    public String save(Student student, @RequestParam("numberGroup") String numberGroup) {
        student.setGroup(service.getGroup(numberGroup));
        if(student.isNew()) {
            service.create(student);
        } else {
            service.update(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Student student = new Student();
        student.setDateAdmission(LocalDate.now());
        model.addAttribute("student", student);
        return "studentForm";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")int id, Model model) {
        model.addAttribute("student", service.get(id));
        return "studentForm";
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("students", service.getAll());
        return "students";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")int id) {
        service.delete(id);
        return "redirect:/students";
    }

    @PostMapping("/search")
    public String search(@RequestParam("param")String param,
                         @RequestParam("startDate") LocalDate startDate,
                         @RequestParam("endDate") LocalDate endDate,
                         Model model) {
        model.addAttribute("students", service.search(param, startDate, endDate));
        return "students";
    }
}
