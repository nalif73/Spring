package ru.geekbrains.context.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ru.geekbrains.context.repository", "ru.geekbrains.context.service"})
public class ApplicationConfiguration {

}
