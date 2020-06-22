package com.example.test.service;

import com.example.test.model.FilterCollection;
import com.example.test.repo.FilterCollectionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FilterCollectionService {

    private final FilterCollectionRepository filterCollectionRepository;

    public FilterCollectionService(FilterCollectionRepository filterCollectionRepository) {
        this.filterCollectionRepository = filterCollectionRepository;
    }

    public List<FilterCollection> findAll() {
        return (List<FilterCollection>) filterCollectionRepository.findAll();
    }

    public FilterCollection add(FilterCollection filterCollection) {
        return filterCollectionRepository.save(filterCollection);
    }

    public FilterCollection update(FilterCollection filterCollection) {
        return filterCollectionRepository.save(filterCollection);
    }

    public void deleteById(Long id) {
        filterCollectionRepository.deleteById(id);
    }

    public List<FilterCollection> findByTitle(String text) {
        return filterCollectionRepository.findByTitle(text);
    }

    public FilterCollection findById(Long id) {
        return filterCollectionRepository.findById(id).get();
    }

    public List<FilterCollection> findAllByOrderByTitleAsc() {
        return filterCollectionRepository.findAllByOrderByTitleAsc();
    }
}
