package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */



@Controller
public class HelloSpringController {

    // Responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name) {
        return "hello";
    }

    // Responds to /hello/LaunchCode
    @GetMapping ( "hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
            return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form"; // returns form.html template (.html is implied), and ResponseBody is not needed.
    }
}










// @Controller
// @RequestMapping("hello")
// public class HelloSpringController {

//
//
//
//    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "hello";
//    }
//
//    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }
//
//    // /hello/form
//    @GetMapping("form")
//    public String helloForm() {
//        return "form"; // returns form.html template (.html is implied), and ResponseBody is not needed.
//    }
//
//
//
//
//
//    //    // Handle request at path /hello
////    @GetMapping("hello")
////    @ResponseBody
////    public String hello() {
////        return "Hello, Spring!";
////    }
//
//    // lives at /hello/goodbye
//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
// }
// }