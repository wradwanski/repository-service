package com.wradwanski.repository.client.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

public class GithubErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        return new HttpServerErrorException(HttpStatus.valueOf(response.status()), response.reason());
    }
}
