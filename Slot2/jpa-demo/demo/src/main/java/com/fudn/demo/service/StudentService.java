    package com.fudn.demo.service;


    import com.fudn.demo.entity.Student;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.PersistenceContext;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    @Service
    public class StudentService {

        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void createStudent(String name, String email, int age) {
            Student s = new Student(name, email, age);
            em.persist(s);

            System.out.println("Saved with ID = " + s.getId());
        }

        @Transactional(readOnly = true)
        public void printAll() {
            em.createQuery("SELECT s FROM Student s", Student.class)
                    .getResultList()
                    .forEach(System.out::println);

        }
        @Transactional
        public void deleteStudent(Long id) {

            Student student = em.find(Student.class, id);

            // Nếu tìm thấy thì tiến hành xóa
            if (student != null) {
                em.remove(student);
                System.out.println("Đã xóa thành công sinh viên có ID = " + id);
            } else {
                System.out.println("Không tìm thấy sinh viên có ID = " + id + " để xóa!");
            }
        }
    }