package com.example.wiremock;

import feign.Headers;
import feign.RequestLine;

import java.util.Map;

public interface FeignApi {

    @RequestLine("POST /test")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Map test(Map map);
}
