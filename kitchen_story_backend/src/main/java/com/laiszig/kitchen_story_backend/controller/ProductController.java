package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.controller.request.ProductRequest;
import com.laiszig.kitchen_story_backend.controller.request.ProductSearchRequest;
import com.laiszig.kitchen_story_backend.entity.Product;
import com.laiszig.kitchen_story_backend.security.JwtUtil;
import com.laiszig.kitchen_story_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(
        origins = "http://localhost:4200"
)
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/products")
    public List<Product> getAll() {
            return productService.findAll();
    }

    @PostMapping("/searchproducts")
    public List<Product> searchProduct(@RequestBody ProductSearchRequest search) {
        return productService.searchByCategory(search.getCategoryId());
    }

    @PostMapping("/products")
    public ResponseEntity<ProductRequest> saveProduct(@RequestBody ProductRequest productRequest, @RequestHeader Map<String,String> headers) {
        String authorization = headers.get("authorization");
        String token = authorization.split(" ")[1];
        final String username = jwtTokenUtil.getUsernameFromToken(token);
        if("admin".equals(username) == false) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        productService.saveFoodItem(productRequest);
        return new ResponseEntity<>(productRequest, HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        try {
            Product product = productService.getFoodItem(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteFoodItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
