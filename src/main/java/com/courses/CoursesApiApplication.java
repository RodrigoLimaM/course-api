package com.courses;

import com.courses.entities.Course;
import com.courses.entities.Curriculum;
import com.courses.entities.Student;
import com.courses.entities.Subject;
import com.courses.repositories.CourseRepository;
import com.courses.repositories.CurriculumRepository;
import com.courses.repositories.StudentRepository;
import com.courses.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CoursesApiApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

//	@Autowired
//	private StudentRepository studentRepository;
//
//	@Autowired
//	private CurriculumRepository curriculumRepository;
//
//	@Autowired
//	private SubjectRepository subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoursesApiApplication.class, args);
	}

	@Override // temporary
	public void run(String... args) throws Exception {
		Course curso1 = new Course("Análise e Desenvolvimento de Sistemas", "Exatas");
		Course curso2 = new Course("Biologia", "Biológicas");
		Course curso3 = new Course("Economia", "Exatas");
		Course curso4 = new Course("Educação Física", "Biológicas");
		Course curso5 = new Course("educação Alternativa", "Humanas");

		//insert
		courseRepository.save(curso1);
		courseRepository.save(curso2);
		courseRepository.save(curso3);
		courseRepository.save(curso4);
		courseRepository.save(curso5);

//		Student aluno1 = new Student("Rodrigo", curso1);
//		Student aluno2 = new Student("Rebeca", curso2);
//		Student aluno3 = new Student("Humberto", curso4);
//
//		studentRepository.save(aluno1);
//		studentRepository.save(aluno2);
//		studentRepository.save(aluno3);
//
//		Curriculum grade1 = new Curriculum("Graduação em Backend", aluno1);
//		Curriculum grade2 = new Curriculum("Graduação em Psicologia do Trabalho", aluno2);
//		Curriculum grade3 = new Curriculum("Graduação em Academia de Rua", aluno3);
//
//		curriculumRepository.save(grade1);
//		curriculumRepository.save(grade2);
//		curriculumRepository.save(grade3);
//
//		Set<Curriculum> gradesMateria1 = new HashSet<>();
//		gradesMateria1.add(grade1);
//		Subject materia1 = new Subject("Java", gradesMateria1);
//		Subject materia2 = new Subject("Node", gradesMateria1);
//
//		subjectRepository.save(materia1);
//		subjectRepository.save(materia2);
	}
}
