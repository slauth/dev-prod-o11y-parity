package de.slauth.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@SpringBootApplication
@RequestMapping("/reviews")
public class ReviewApp {

    private static final Logger logger = LoggerFactory.getLogger(ReviewApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ReviewApp.class, args);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void submitReview(@Valid @RequestBody Review review) {
        logger.atDebug().setMessage("Received new review")
                .addKeyValue("review_description", review.description)
                .addKeyValue("review_stars", review.stars)
                .log();
    }

    public record Review(
            @NotBlank @Size(max = 2000)
            String description,

            @Min(1) @Max(5)
            int stars
    ) {
    }
}
