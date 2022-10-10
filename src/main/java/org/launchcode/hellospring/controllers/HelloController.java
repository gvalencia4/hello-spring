package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay, worked on by Gabriel Valencia
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
//    Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

//    // lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, String lang) {
        // return "Hello, " + name + "!";
        return  "<html>" +
                "<body>" +
                "<p style='color:red;'>" + createMessage(name, lang) + "</p>" +
                "</body>" +
                "</html>";

    }

    public static String createMessage(String name, String lang) {

        switch (lang) {
            case "english":
                return "Hello, " + name + "!";
            case "french":
                return "Bonjour, " + name + "!";
            case "german":
                return "Hallo, " + name + "!";
            case "italian":
                return "Ciao, " + name + "!";
            case "spanish":
                return "Hola, " + name + "!";
            default:
                return "Error, no lang selected";
        }
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='lang'>" +
                "  <option value='english'>English</option>" +
                "  <option value='french'>French</option>" +
                "  <option value='german'>German</option>" +
                "  <option value='italian'>Italian</option>" +
                "  <option value='spanish'>Spanish</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}