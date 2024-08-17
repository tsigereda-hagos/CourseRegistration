package edu.miu.cs.cs425.courseregistration.controller;

import edu.miu.cs.cs425.courseregistration.domain.Faculty;
import edu.miu.cs.cs425.courseregistration.services.FacultyService;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("")
    public String showFacultyPage(ModelAndView model) {
        List<Faculty> list = facultyService.getAllFaculties();
        model.addObject("faculties", list);
        return "faculty-list";
    }

    @GetMapping("/add")
    public String showNewFacultyForm(ModelAndView model) {
        model.addObject("newFaculty", new Faculty());
        return "faculty-create";
    }

    @PostMapping("/add")
    public String addNewFaculty(Faculty faculty) {
        facultyService.addFaculty(faculty);
        return "redirect:../faculty";
    }

    @DeleteMapping("/delete/{facultyId}")
    @ResponseBody
    public String deleteFaculty(@PathVariable("facultyId") String id) {
        facultyService.deleteFaculty(Integer.parseInt(id));
        return "redirect:../../faculty";
    }

    @GetMapping("/edit/{facultyId}")
    public String showUpdateFaculty(@PathVariable("facultyId") String id, ModelAndView model) throws NotFoundException {
        Faculty faculty = facultyService.getFaculty(Integer.parseInt(id));
        model.addObject("faculty", faculty);
        return "faculty-edit";
    }

    @PostMapping("/edit")
    public String updateFaculty(ModelAndView model, Faculty faculty) {
        facultyService.editFaculty(faculty);
        return "redirect:../faculty";
    }
}