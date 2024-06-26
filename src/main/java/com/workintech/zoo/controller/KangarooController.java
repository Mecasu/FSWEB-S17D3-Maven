package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;
    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
        }
    @GetMapping("/")
    public List<Kangaroo> findAll(){
        return kangaroos.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Kangaroo findById(@PathVariable int id){
        return kangaroos.get(id);
    }
    @PostMapping("/")
    public Kangaroo add(@RequestBody Kangaroo kangaroo){
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }
    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable int id, @RequestBody Kangaroo kangaroo){
        kangaroo.setId(id);
        kangaroos.put(id,kangaroo);
        return kangaroo;

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        kangaroos.remove(id);
    }
}
