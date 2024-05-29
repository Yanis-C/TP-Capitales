package com.capitales.eval.controller;


import com.capitales.eval.db.Country;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateCountryResponse(Country country) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", country.getId());
        map.put("name", country.getName());

        return ResponseEntity.ok(map);
    }
}