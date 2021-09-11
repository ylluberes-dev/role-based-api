package com.ylluberes.rolebasedapp.roles;

import com.ylluberes.rolebasedapp.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users;

}
