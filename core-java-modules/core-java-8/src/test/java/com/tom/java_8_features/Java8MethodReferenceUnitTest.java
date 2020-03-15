package com.tom.java_8_features;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class Java8MethodReferenceUnitTest {

    private List<String> list;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
    }

    @Test
    public void checkStaticMethodReferences_whenWork_thenCorrect() {

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        boolean isReal = users.stream().anyMatch(u -> User.isRealUser(u));
        boolean isRealRef = users.stream().anyMatch(User::isRealUser);
        assertTrue(isReal);
        assertTrue(isRealRef);
    }

    @Test
    public void checkInstanceMethodReferences_whenWork_thenCorrect() {
        User user = new User();
        boolean isLegalName = list.stream().anyMatch(user::isLegalName);
        assertTrue(isLegalName);
    }

    @Test
    public void checkParticularTypeReferences_whenWork_thenCorrect() {
        long count = list.stream().filter(String::isEmpty).count();
        assertEquals(count, 2);
    }

    @Test
    public void checkConstructorReferences_whenWork_thenCorrect() {
        Stream<User> stream = list.stream().filter(StringUtils::isNotBlank).map(User::new);
        List<User> userList = stream.collect(Collectors.toList());
        log.info("{}", userList);
        assertEquals(userList.size(), list.size() - 2);
        assertTrue(userList.get(0) instanceof User);
    }
}