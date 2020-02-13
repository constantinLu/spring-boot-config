package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private String greeting;

    @Value("${my.list.values}")
    private List<String> myList;

    //@Value("#{${dbsettings}}")
    private Map<String, String> dbsettings;

    @Autowired
    DbSettings db;

    @Autowired
    private Environment env;



    @GetMapping("/greeting")
    public String greeting() {
        return greeting + " " + myList + "  " + db.getConnection();
    }

    @GetMapping("/envdetails")
    public String envDetails() {
        return env.toString();
    }
}
