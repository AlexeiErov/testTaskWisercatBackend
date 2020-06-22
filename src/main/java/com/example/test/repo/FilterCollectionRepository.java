package com.example.test.repo;

import com.example.test.model.FilterCollection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilterCollectionRepository extends CrudRepository<FilterCollection, Long> {

    @Query("SELECT f FROM FilterCollection f where " +
            "(:title is null or :title='' or lower(f.title) like lower(concat('%', :title,'%')))  " +
            "order by f.title asc")
    List<FilterCollection> findByTitle(@Param("title") String title);

    List<FilterCollection> findAllByOrderByTitleAsc();

}
