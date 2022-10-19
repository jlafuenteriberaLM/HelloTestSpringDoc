package com.hello.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RestControllerEndpoint(id = "status")
public class CustomActuatorEndpoint {

  @Value("${application.version}")
  private String version;

  @GetMapping()
  public @ResponseBody ResponseEntity<CustomStatusResponse> customStatusEndpoint() {
    CustomStatusResponse psr = new CustomStatusResponse();
    psr.setVersion(version);
    return new ResponseEntity<>(psr, HttpStatus.OK);
  }
}