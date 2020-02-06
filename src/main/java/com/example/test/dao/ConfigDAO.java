package com.example.test.dao;

import com.example.test.entity.Config;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigDAO extends CrudRepository<Config, Long> {

}
