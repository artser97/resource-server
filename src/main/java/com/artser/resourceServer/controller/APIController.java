package com.artser.resourceServer.controller;

import com.artser.resourceServer.data.Message;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4040")
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {


  @GetMapping(value = "/private")
  public Message privateEndpoint() {
    return new Message("All good. You can see this because you are Authenticated.");
  }

  @GetMapping(value ="/admin")
  @PreAuthorize("hasAuthority('read:all')")
  public Message getAdmin() {
    return new Message("All good. You can see this because you are Admin.");
  }


  @GetMapping(value ="/read")
  @PreAuthorize("hasAuthority('read:messages')")
  public Message getRead() {
    return new Message("All good. You can see this because you have Read permissions.");
  }
}
