package com.petclinic.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test15_TiempoRespuesta {

    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void medirTiempo() {
        long inicio = System.currentTimeMillis();

        driver.get("http://localhost:8080");

        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;

        Assertions.assertTrue(tiempo < 2000, "El sitio tardó demasiado en cargar");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
