package com.booking;

import com.booking.entities.Student;
import com.booking.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BookingRestaurantApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingRestaurantApiApplication.class, args);
    }

    //Lanzar o probar una funcionalidad cuando se ejecute el SptringBoot
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student maria = new Student(
                    "María",
                    "Jones",
                    "maria.jones@upc.edu.pe",
                    21
            );
            Student maria2 = new Student(
                    "María",
                    "Jones",
                    "maria.jones2@upc.edu.pe",
                    24
            );
            Student ahmed = new Student(
                    "Ahmed",
                    "Altas",
                    "ahmed.altas@upc.edu.pe",
                    21
            );
            studentRepository.saveAll(List.of(maria,maria2,ahmed));

            studentRepository.findStudentByEmail("maria.jones2@upc.edu.pe")
                    .ifPresentOrElse(
                            System.out::println,
                            ()->System.out.println("Student Not Found")
                    );
            studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEquals(
                    "María",
                    21
            ).forEach(System.out::println);

            System.out.println("Deleting Maria 2");
            System.out.println(studentRepository.deleteStudentById(3L));
        };
    }
}
