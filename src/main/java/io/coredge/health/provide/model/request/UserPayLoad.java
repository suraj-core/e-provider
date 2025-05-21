package io.coredge.health.provide.model.request;


import io.coredge.health.provide.annotations.ValidUuid;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPayLoad {
    @ValidUuid
    private  String name;

    private  String phoneNumber;
}
