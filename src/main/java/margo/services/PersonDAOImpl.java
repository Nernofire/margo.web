package margo.services;

import margo.models.Person;
import margo.repository.PersonRepo;
import margo.services.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    PersonRepo personRepo;

    public List<Person> getAll() {
        return personRepo.findAll();
    }

    @Override
    public Person getOnePerson(Integer id) {
        return personRepo.getOne(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person editPerson(Person person) {
        Optional<Person> personOptional = personRepo.findById(person.getId());
        if (personOptional.isPresent()) {
            person.setId(person.getId());
            return personRepo.save(person);
        }
        return null;
    }

    @Override
    public void deletePerson(Integer id) {
        Optional<Person> personOptional = personRepo.findById(id);
        if (personOptional.isPresent()) {
            personOptional.get().setDeleted(true);
            personRepo.save(personOptional.get());
        }
    }
}
//@RestController
//public class StudentResource {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @GetMapping("/students")
//    public List<Student> retrieveAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    @GetMapping("/students/{id}")
//    public Student retrieveStudent(@PathVariable long id) {
//        Optional<Student> student = studentRepository.findById(id);
//
//        if (!student.isPresent())
//            throw new StudentNotFoundException("id-" + id);
//
//        return student.get();
//    }
//
//    @DeleteMapping("/students/{id}")
//    public void deleteStudent(@PathVariable long id) {
//        studentRepository.deleteById(id);
//    }
//
//    @PostMapping("/students")
//    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
//        Student savedStudent = studentRepository.save(student);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(savedStudent.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
//
//    }
//
//    @PutMapping("/students/{id}")
//    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
//
//        Optional<Student> studentOptional = studentRepository.findById(id);
//
//        if (!studentOptional.isPresent())
//            return ResponseEntity.notFound().build();
//
//        student.setId(id);
//
//        studentRepository.save(student);
//
//        return ResponseEntity.noContent().build();
//    }
