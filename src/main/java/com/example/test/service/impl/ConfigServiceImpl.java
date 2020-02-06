package com.example.test.service.impl;

import com.example.test.dao.ConfigDAO;
import com.example.test.entity.Config;
import com.example.test.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigDAO configDAO;

    @Override
    public Config update(Config config) {
        return configDAO.save(config);
    }

    @Override
    public Iterable<Config> findAll() {
        return configDAO.findAll();
    }

    @Override
    public Config getById(Long id) {
        Config config = configDAO.findById(id).get();
        return config;
    }
}
