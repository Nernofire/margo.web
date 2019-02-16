package margo.controllers.person;

import margo.models.Person;
import margo.services.PersonDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * PersonController class controls Person CRUD in the project.
 * It uses "/person" mapping prefix.
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonDAOImpl personDAO;

    /**
     * Mapping to the person overview page.
     * @return Returns list of users and link to the page.
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView viewAllUsers() {
        ModelAndView obj = new ModelAndView("/person/person");

        List<Person> peopleList = personDAO.getAll();
        obj.addObject("people_list", peopleList);
        return obj;
    }

    /**
     * Mapping to person edit page
     * @param id ID of the selected user.
     * @return Method returns link to the edit page and person data for editing.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPerson(@PathVariable("id") int id) {
        ModelAndView obj = new ModelAndView("/person/edit");

        obj.addObject("person", personDAO.getOnePerson(id));
        return obj;
    }

    /**
     * Mapping to person creation page
     * @return Link to the person creation page.
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String creation() {
        return "/person/create";
    }

    /**
     * Method creates new person in the DB.
     * @param person collected data from front-end.
     * @return redirects to the main Person overview page
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createPerson(Person person) {
        personDAO.savePerson(person);

        return "redirect:/person/index";
    }

    /**
     * Method updates selected person.
     * @param person collected data from front-end.
     * @return redirects to the main Person overview page
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updatePerson(Person person) {
        personDAO.editPerson(person);

        return "redirect:/person/index";
    }
}