package com.ad.oas.util;

import com.ad.oas.exception.DataParsingException;
import com.ad.oas.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ResultUtils {
    @Resource(name="objectMapper")
    private ObjectMapper objectMapper;

    public String resultToString(@NonNull final Result result){
        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new DataParsingException("Result cannot be parsed to String.");
        }
    }
}
