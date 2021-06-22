package com.example.booking;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix
@RestController
@RequestMapping("/bookings")
public class BookingServiceApplication {

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(groupKey = "hoank", commandKey = "hoank", fallbackMethod = "bookingFallBack")
  @GetMapping("/book-now")
  public String bookShow() {
    String emailResponse = restTemplate.getForObject("http://localhost:9001/emails/", String.class);
    String paymentResponse = restTemplate.getForObject("http://localhost:9002/payments/", String.class);
    return emailResponse + " - " + paymentResponse;
  }

  @GetMapping("/bookNowWithOutHystrix")
  public String bookShowWithOutHystrix() {
    String emailResponse = restTemplate.getForObject("http://localhost:9001/emails", String.class);
    String paymentResponse = restTemplate.getForObject("http://localhost:9002/payments", String.class);
    return emailResponse + " - " + paymentResponse;
  }

  public static void main(String[] args) {
    SpringApplication.run(BookingServiceApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public String bookingFallBack() {
    return "Service gateway failed . . .";
  }

}
