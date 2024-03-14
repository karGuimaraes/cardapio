package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;

import io.micrometer.common.lang.NonNull;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<FoodResponseDTO> create(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FoodResponseDTO(foodData));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAll() {
        List<FoodResponseDTO> allFoods = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return ResponseEntity.ok(allFoods);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<FoodResponseDTO> getOne(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Food food = repository.findById(id).orElse(null);
        if (food == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new FoodResponseDTO(food));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/{id}")
    public ResponseEntity<FoodResponseDTO> update(@PathVariable Long id, @RequestBody FoodRequestDTO data) {
        if (id == null) {
            return ResponseEntity.badRequest().build(); 
        }
        Food food = repository.findById(id).orElse(null);

        if(food == null) {
            return ResponseEntity.notFound().build();
        }

        food.setTitle(data.title());
        food.setImage(data.image());
        food.setPrice(data.price());
        repository.save(food);
        return ResponseEntity.ok(new FoodResponseDTO(food));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
