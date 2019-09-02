package com.app.braingames;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String... args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        StartMenu startmenu = context.getBean(StartMenu.class);
        startmenu.run();

        }

    }
