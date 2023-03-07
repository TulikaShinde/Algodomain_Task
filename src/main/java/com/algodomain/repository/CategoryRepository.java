package com.algodomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algodomain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
