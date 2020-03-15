package com.tom.eclipsecollections;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlatCollectUnitTest {


    @Test
    public void whenFlatCollect_thenCorrect() {
        String address1 = "73 Pacific St., Forest Hills, NY 11375";
        String address2 = "93 Bayport Ave., South Richmond Hill, NY 11419";
        String address3 = "548 Market St, San Francisco, CA 94104";
        String address4 = "8605 Santa Monica Blvd, West Hollywood, CA 90069";

        MutableList<String> addresses1 = FastList.newListWith(address1, address2);
        MutableList<String> addresses2 = FastList.newListWith(address3, address4);
        Student student1 = new Student("John", "Hopkins", addresses1);
        Student student2 = new Student("George", "Adams", addresses2);
        MutableList<Student> students = FastList.newListWith(student1, student2);
        List<String> expectedAddresses = new ArrayList<>();
        expectedAddresses.add("73 Pacific St., Forest Hills, NY 11375");
        expectedAddresses.add("93 Bayport Ave., South Richmond Hill, NY 11419");
        expectedAddresses.add("548 Market St, San Francisco, CA 94104");
        expectedAddresses.add("8605 Santa Monica Blvd, West Hollywood, CA 90069");
        MutableList<String> addresses = students.flatCollect(Student::getAddresses);

        Assertions.assertThat(addresses).containsExactlyElementsOf(expectedAddresses);
    }
}