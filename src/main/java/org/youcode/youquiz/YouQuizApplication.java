package org.youcode.youquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YouQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouQuizApplication.class, args);
        System.out.println("YouQuiz Application Started");
    }

}
