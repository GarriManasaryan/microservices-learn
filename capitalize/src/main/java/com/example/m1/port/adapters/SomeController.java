package com.example.m1.port.adapters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

//     This is a placeholder for the actual implementation of the controller.
//     You can add your endpoints and business logic here.
//
//     For example, you might want to add a method to handle HTTP GET requests:
     @GetMapping("/api/some")
     public void someMethod() {
         // Your logic here
         System.out.println("Hello from SomeController!");
         System.out.println("Hello from SomeController!");
         System.out.println("Hello from SomeController!");
         System.out.println("Hello from SomeController!");
         System.out.println("Hello from SomeController!");
     }

}
