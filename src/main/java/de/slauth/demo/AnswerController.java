package de.slauth.demo;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

    @Observed
    @GetMapping
    public Map<String, Object> getAnswer(
            @RequestParam(defaultValue = "The ultimate question of life, the universe, and everything")
            String question
    ) {
        logger.atDebug().setMessage("Going to calculate answer")
                .addKeyValue("question", question).log();

        int answer = 42;

        logger.atInfo().setMessage("Answer is ready")
                .addKeyValue("question", question).addKeyValue("answer", answer).log();

        return Map.of(
                "question", question,
                "answer", answer
        );
    }
}
