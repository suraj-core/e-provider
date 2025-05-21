package io.coredge.health.provide.controller;

import io.coredge.health.provide.model.request.UserPayLoad;
import org.springframework.http.ResponseEntity;

public interface UserController {
    public ResponseEntity<String> getUser(UserPayLoad userPayLoad);
}
