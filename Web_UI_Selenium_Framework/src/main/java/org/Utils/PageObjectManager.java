package org.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class PageObjectManager {
    private static final Map<Class<?>, Object> pageObjects = new HashMap<>();
    private static final Object lock = new Object();

    @SuppressWarnings("unchecked")
    public static <T> T getPageObject(WebDriver driver, Class<T> pageClass) {
        synchronized (lock) {
            if (!pageObjects.containsKey(pageClass)) {
                T pageObject = PageFactory.initElements(driver, pageClass);
                pageObjects.put(pageClass, pageObject);
            }
            return (T) pageObjects.get(pageClass);
        }

    }

}
