package com.tom.boot.test;

import com.tom.boot.domain.User;
import com.tom.boot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by adam.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("multiplesqlfiles")
public class UserRepositoryMultipleSqlFilesIntTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenTwoImportFilesWhenFindAllShouldReturnSixUsers() {
        Collection<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(6);
    }

}
