package com.example.test.service;

import com.example.test.entity.Config;

public interface ConfigService {
    Config update(Config config);

    Iterable<Config> findAll();

    Config getById(Long id);
}
