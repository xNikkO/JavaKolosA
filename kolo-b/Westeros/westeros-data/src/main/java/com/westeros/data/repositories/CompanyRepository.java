package com.westeros.data.repositories;

import com.westeros.data.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select x from Company x where x.sourceId in (:sourceIds)")
    List<Company> withSourceIds(List<Integer> sourceIds);
}
