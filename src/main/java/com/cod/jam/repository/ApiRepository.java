package com.cod.jam.repository;

import com.cod.jam.model.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api,Integer> {
}
