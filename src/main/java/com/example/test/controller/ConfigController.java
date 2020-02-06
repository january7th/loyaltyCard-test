package com.example.test.controller;

import com.example.test.entity.Config;
import com.example.test.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api-v1")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @CrossOrigin
    @RequestMapping(value = "/configs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Config> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Config config) {
        Config cf = configService.getById(id);
        if (cf.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cf.setValue(config.getValue());
        Config result = configService.update(cf);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    for test
//    @CrossOrigin
//    @RequestMapping(value = "/configs/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Config> getNoteById(@PathVariable(value = "id") Long id) {
//        Config result = configService.getById(id);
//        if (result.getId() == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/configs", method = RequestMethod.GET)
//    public String index() {
//        Iterable<Config> all = configService.findAll();
//
//        StringBuilder sb = new StringBuilder();
//
//        all.forEach(p -> sb.append(p.getName() + " 1 điểm = " + p.getValue() + "<br>"));
//
//        return sb.toString();
//    }
}
