package com.agendamento_consulta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String name;

    public enum Values{
        BASIC(1L),
        ADMIN(2L);
        Long roleId;

        Values(Long roleid){
            this.roleId = roleid;
        }
        public long getRoleId(){
            return roleId;
        }
    }
}
