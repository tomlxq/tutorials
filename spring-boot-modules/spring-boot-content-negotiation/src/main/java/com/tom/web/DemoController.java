package com.tom.web;

import com.tom.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/29
 */
@Controller
public class DemoController {
    final static Map<Long, Employee> employeeMap = new HashMap<>();

    static {
        employeeMap.put(10L, new Employee(10L, "Test Employee", "999-999-9999", "rh"));

    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("employeeHome", "employee", new Employee());
    }

    @RequestMapping(value = "/employee/{Id}", produces = {"application/json", "application/xml"}, method = RequestMethod.GET)
    public @ResponseBody
    Employee getEmployeeById(@PathVariable final long Id) {

        return employeeMap.get(Id);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee") final Employee employee, final BindingResult result, final ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        employeeMap.put(employee.getId(), employee);
        return "employeeView";
    }
}
