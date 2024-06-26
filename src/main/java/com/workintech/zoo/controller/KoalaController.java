package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KoalaController {
    private Map<Integer, Koala> koalas;
    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
    }
    @GetMapping("/")
    public List<Koala> findAll(){
        return koalas.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala findById(@PathVariable int id){
        return koalas.get(id);
    }
    @PostMapping("/")
    public Koala add(@RequestBody Koala koala){
        koalas.put(koala.getId(), koala);
        return koala;
    }
    @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala){
        koala.setId(id);
        koalas.put(id,koala);
        return koala;

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        koalas.remove(id);
    }
}
