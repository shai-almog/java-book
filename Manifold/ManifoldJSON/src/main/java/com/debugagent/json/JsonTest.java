package com.debugagent.json;

import java.time.LocalDate;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        Test test = Test.builder().withFirstName("Someone")
                .withSurname("Surname")
                .withActive(true)
                .withDetails(List.of(
                        Test.details.detailsItem.builder().
                                withKey("Value 1").build()
                ))
                .build();

        System.out.println(test.write().toJson());
        System.out.println("\n\n" + test.write().toCsv());
        System.out.println("\n\n" + test.write().toXml());
        System.out.println("\n\n" + test.write().toYaml());

        Test readObject = Test.load().fromJson("""
                {
                  "firstName": "Someone",
                  "surname": "Surname",
                  "active": true,
                  "details": [
                    {
                      "key": "Value 1"
                    }
                  ]
                }
                """);


        User u = User.builder("Name", "email@domain.com")
                .withDate_of_birth(LocalDate.of(1999, 10, 11))
                .withGender(User.Gender.male)
                .build();
    }
}