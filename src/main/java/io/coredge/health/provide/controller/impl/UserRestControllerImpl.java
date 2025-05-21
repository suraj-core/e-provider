package io.coredge.health.provide.controller.impl;

import io.coredge.health.provide.annotations.ValidUuid;
import io.coredge.health.provide.controller.UserController;
import io.coredge.health.provide.model.request.UserPayLoad;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.coredge.health.provide.constants.APIBasePathConstants.EndPoints.USER_V1_ENDPOINT;

@RestController
@RequestMapping("/v1/user")
public class UserRestControllerImpl implements UserController {

    @PostMapping("/SaveUser")
    @Override
    public ResponseEntity<String> getUser( @Valid @RequestBody UserPayLoad userPayLoad) {
        return ResponseEntity.ok("User saved successfully");
    }
}
