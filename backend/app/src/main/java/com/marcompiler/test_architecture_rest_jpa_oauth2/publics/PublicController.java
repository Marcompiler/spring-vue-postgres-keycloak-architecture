package com.marcompiler.test_architecture_rest_jpa_oauth2.publics;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String helloPublic() {
        return "Hello public";
    }
}
