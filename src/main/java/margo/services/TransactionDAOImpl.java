package margo.services;

import margo.models.Transaction;
import margo.repository.TransactionRepo;
import margo.services.dao.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class TransactionDAOImpl implements TransactionDAO {
    @Autowired
    private NamedParameterJdbcTemplate template;
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public List<Transaction> getALl() {
        return transactionRepo.findAll();
    }

    @Override
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        Transaction saveTransaction = transactionRepo.save(transaction);
        return saveTransaction;
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
