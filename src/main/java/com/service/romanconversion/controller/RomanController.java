package com.service.romanconversion.controller;
import com.service.romanconversion.model.Result;
import com.service.romanconversion.service.RomanService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Slf4j
@RestController
@Validated
@NoArgsConstructor
public class RomanController {

    @Autowired
    private RomanService romanService;

    public void RomanController(final RomanService romanService) {
        this.romanService = romanService;
    }

    @GetMapping(path = "/romannumeral")
    public @ResponseBody ResponseEntity getRomanValue(final @RequestParam( name = "query", required = true, defaultValue = "1")
                                                    @Min(1) @Max(255) int query){
        log.debug("Calling RomanService getRomanValueForInteger");
        return new ResponseEntity<Object>(romanService.getRomanValueForInteger(query), HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private String handleConstraintViolationException(ConstraintViolationException e) {
        return e.getMessage();
    }
}
