package com.example.test.controller;

import com.example.test.model.FilterCollection;
import com.example.test.search.FilterCollectionSearchValues;
import com.example.test.service.FilterCollectionService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:4200")
public class FilterCollectionController {

    private FilterCollectionService filterCollectionService;

    public FilterCollectionController(FilterCollectionService filterCollectionService) {
        this.filterCollectionService = filterCollectionService;
    }

    @GetMapping("/all")
    public List<FilterCollection> findAll() {
        return filterCollectionService.findAllByOrderByTitleAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<FilterCollection> add(@RequestBody FilterCollection filterCollection) {

        System.out.println("after ");

        if (filterCollection.getId() != null && filterCollection.getId() != 0) {
            return new ResponseEntity("redundant param", HttpStatus.NOT_ACCEPTABLE);
        }

        if (filterCollection.getTitle() == null || filterCollection.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(filterCollectionService.add(filterCollection));
    }

    @PutMapping("/update")
    public ResponseEntity<FilterCollection> update(@RequestBody FilterCollection filterCollection) {

        if (filterCollection.getId() == null || filterCollection.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }
        if (filterCollection.getTitle() == null || filterCollection.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        filterCollectionService.update(filterCollection);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FilterCollection> findById(@PathVariable Long id) {

        FilterCollection filterCollection = null;

        try {
            filterCollection = filterCollectionService.findById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(filterCollection);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FilterCollection> delete(@PathVariable Long id) {

        try {
            filterCollectionService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<FilterCollection>> search(@RequestBody FilterCollectionSearchValues filterCollectionSearchValues) {
        return ResponseEntity.ok(filterCollectionService.findByTitle(filterCollectionSearchValues.getText()));
    }
}
