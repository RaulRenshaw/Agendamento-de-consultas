package com.agendamento_consulta.config;

import com.agendamento_consulta.model.Roles;
import com.agendamento_consulta.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleDataLoader implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public RoleDataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (Roles.Values value : Roles.Values.values()){
            if (roleRepository.findByName(value.name()).isEmpty()){
                Roles roles = new Roles();
                roles.setName(value.name());
                roleRepository.save(roles);
            }
        }

    }
}
