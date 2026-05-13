package com.fudn.demo;

import com.fudn.demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JPADemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JPADemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentService service) {
        return args -> {
            System.out.println("--- BƯỚC 1: THÊM SINH VIÊN ---");
            service.createStudent("Nguyễn Văn A", "a@fpt.edu.vn", 20);
            service.createStudent("Trần Thị B", "b@fpt.edu.vn", 21);

            System.out.println("\n--- BƯỚC 2: DANH SÁCH BAN ĐẦU ---");
            service.printAll();

            System.out.println("\n--- BƯỚC 3: TEST XÓA SINH VIÊN ---");

            service.deleteStudent(1L);

            System.out.println("\n--- BƯỚC 4: DANH SÁCH SAU KHI XÓA ---");
            service.printAll();
        };
    }
}