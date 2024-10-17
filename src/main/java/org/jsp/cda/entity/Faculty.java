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
public class Faculty 
{

    @Id
    private int userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private String profilePhoto;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String officeHours;

//    @OneToMany(mappedBy = "faculty")
//    private List<Course> courses;

    
}

