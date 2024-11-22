package de.slauth.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    @ResponseStatus(NO_CONTENT)
    public void getNothing() {
    }
}
