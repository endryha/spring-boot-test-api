package com.hla.test.api;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/name")
@RestController
public class NameController {

    private final Faker faker;

    public NameController(Faker faker) {
        this.faker = faker;
    }

    @GetMapping("/random")
    public String getRandomName() {
        Name name = faker.name();
        return name.firstName() + " " + name.lastName();
    }
}
