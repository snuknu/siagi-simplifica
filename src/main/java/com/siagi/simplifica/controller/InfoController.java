package com.siagi.simplifica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siagi.simplifica.util.info.Info;

@RestController
@RequestMapping("info")
public class InfoController {

  @GetMapping
  public ResponseEntity<Info> test() {
    return ResponseEntity.ok(Info.getInstance());
  }

}
