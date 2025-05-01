package com.isai.demo_system_management_trailers.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isai.demo_system_management_trailers.models.Gender;

public interface GenderRepository
        extends JpaRepository<Gender, Integer> {
    
}
