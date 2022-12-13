package com.artser.resourceServer.controller;

import com.artser.resourceServer.data.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {

  @GetMapping(value = "/private")
  public Message privateEndpoint() {
    return new Message("All good. You can see this because you are Authenticated.");
  }
}
