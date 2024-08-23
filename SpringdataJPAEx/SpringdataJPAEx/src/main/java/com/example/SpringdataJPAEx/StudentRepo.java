package com.example.SpringdataJPAEx;


import org.hibernate.metamodel.internal.AbstractEmbeddableRepresentationStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SpringdataJPAEx.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}