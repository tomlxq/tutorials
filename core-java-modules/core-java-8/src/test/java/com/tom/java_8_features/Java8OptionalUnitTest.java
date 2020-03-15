package com.tom.java_8_features;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Java8OptionalUnitTest {

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
    public void checkOptional_whenAsExpectedWithNewObj_thenCorrect() {

        List<String> listOpt = list != null ? list : new ArrayList<>();
        assertTrue(listOpt == list);

        List<String> listOpt2 = Optional.ofNullable(list).orElseGet(() -> new ArrayList<>());
        assertTrue(listOpt2 == list);


        List<String> listOpt3 = Optional.of(list).orElse(new ArrayList<>());
        List<String> listNull = null;
        List<String> listOptNull = Optional.ofNullable(listNull).orElse(new ArrayList<>());
        assertTrue(listOpt3 == list);
        assertTrue(listOptNull.isEmpty());
    }

    private String getUserAddr() {
        User user = getUser();
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String street = address.getStreet();
                if (street != null) {
                    return street;
                }
            }
        }
        return "not specified";
    }

    @Test
    public void checkOptional_whenAsExpectedWithNullDecide_thenCorrect() {
        //before java8
        assertEquals(getUserAddr(), "1st Avenue");

        Optional<User> user = Optional.ofNullable(getUser());
        String result = user.map(User::getAddress).map(Address::getStreet).orElse("not specified");
        assertEquals(result, "1st Avenue");

        Optional<OptionalUser> optionalUser = Optional.ofNullable(getOptionalUser());
        String resultOpt = optionalUser.flatMap(OptionalUser::getAddress).flatMap(OptionalAddress::getStreet).orElse("not specified");
        assertEquals(resultOpt, "1st Avenue");

        Optional<User> userNull = Optional.ofNullable(getUserNull());
        String resultNull = userNull.map(User::getAddress).map(Address::getStreet).orElse("not specified");
        assertEquals(resultNull, "not specified");

        Optional<OptionalUser> optionalUserNull = Optional.ofNullable(getOptionalUserNull());
        String resultOptNull = optionalUserNull.flatMap(OptionalUser::getAddress).flatMap(OptionalAddress::getStreet).orElse("not specified");
        assertEquals(resultOptNull, "not specified");
    }

    @Test
    public void checkOptional_whenAsExpected_thenCorrect() {
        Optional<String> optionalEmpty = Optional.empty();
        assertFalse(optionalEmpty.isPresent());

        String str = "value";
        Optional<String> optional = Optional.of(str);
        assertEquals(optional.get(), "value");

        Optional<String> optionalNullable = Optional.ofNullable(str);
        Optional<String> optionalNull = Optional.ofNullable(null);
        assertEquals(optionalNullable.get(), "value");
        assertFalse(optionalNull.isPresent());


    }

    public String getOrThrowBeforeJava8() {
        String value = null;
        String result = "";
        try {
            result = value.toUpperCase();
        } catch (NullPointerException exception) {
            throw new CustomException();
        }
        return result;
    }

    @Test(expected = CustomException.class)
    public void callMethod_whenCustomExceptionBeforeJava8_thenCorrect() {
        String result = getOrThrowBeforeJava8();
    }

    public String getOrThrow() {
        String value = null;
        Optional<String> valueOpt = Optional.ofNullable(value);
        String result = valueOpt.orElseThrow(CustomException::new).toUpperCase();
        return result;
    }

    @Test(expected = CustomException.class)
    public void callMethod_whenCustomException_thenCorrect() {
        User user = new User();
        String result = getOrThrow();
    }

    private User getUser() {
        User user = new User();
        Address address = new Address();
        address.setStreet("1st Avenue");
        user.setAddress(address);
        return user;
    }

    private OptionalUser getOptionalUser() {
        OptionalUser user = new OptionalUser();
        OptionalAddress address = new OptionalAddress();
        address.setStreet("1st Avenue");
        user.setAddress(address);
        return user;
    }

    private OptionalUser getOptionalUserNull() {
        OptionalUser user = new OptionalUser();
        OptionalAddress address = new OptionalAddress();
        address.setStreet(null);
        user.setAddress(address);
        return user;
    }

    private User getUserNull() {
        User user = new User();
        Address address = new Address();
        address.setStreet(null);
        user.setAddress(address);
        return user;
    }

}