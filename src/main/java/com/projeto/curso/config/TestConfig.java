package com.projeto.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.curso.entities.User;
import com.projeto.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired // ** Obs abaixo
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User user1 = new User(null, "Walter White", "ww@email.com", "111222333");
        User user2 = new User(null, "Jack Black", "jb@email.com", "111222334");
    
        userRepository.saveAll(Arrays.asList(user1,user2));
    }

    // ** Sem a anotação, a injeção deveria ser feita manualmente, 
    // via construtor; Exemplo:
        // private final UserRepository userRepository;
        // public TestConfig(UserRepository userRepository) {
        //     this.userRepository = userRepository;
        // }
    // pro: ideal para garantir imutabilidade 
}
