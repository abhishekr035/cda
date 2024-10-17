package org.jsp.cda.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student
{

    @Id
    private int id;

    @OneToOne
    @MapsId
    private User user;

    private String profilePhoto;
    
    @ManyToOne
    private Department department;
    
    private String year; 

}

