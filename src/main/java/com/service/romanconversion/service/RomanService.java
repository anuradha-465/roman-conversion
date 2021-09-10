package com.service.romanconversion.service;

import com.service.romanconversion.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
  This service class contains any logic tied to Roman conversion
    future enhancements - include all JPA database calls to store data.
 */

@Service
@Slf4j
public class RomanService {

    public Result getRomanValueForInteger(final int inputVal){
        log.debug("getRomanValueForInteger :: Input integer value"+inputVal);
        return new Result(inputVal,"I");
    }

}
