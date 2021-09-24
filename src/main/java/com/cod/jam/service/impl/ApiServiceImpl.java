package com.cod.jam.service.impl;

import com.cod.jam.exception.ModelNotFoundExcept;
import com.cod.jam.model.Api;
import com.cod.jam.model.Empresa;
import com.cod.jam.repository.ApiRepository;
import com.cod.jam.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private ApiRepository apiRepository;
    @Override
    public Api findById(Integer id) throws Exception {
        Optional<Api> apiO=apiRepository.findById(id);
        if(!apiO.isPresent()){
            throw new ModelNotFoundExcept("ID NO ENCONTRADO: " + id);
        }
        return apiO.isPresent() ? apiO.get() : new Api();
    }

    @Override
    public List<Api> findAll() {
        return this.apiRepository.findAll();
    }

    @Override
    public Api save(Api api) {
        return apiRepository.save((api));
    }

    @Override
    public Api update(Api api) {
        return apiRepository.save((api));
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Api> optionalApi = apiRepository.findById(id);
        if(!optionalApi.isPresent()){
            throw new Exception("el id: " + id+", no se encontró");
        }
        apiRepository.deleteById(id);
        return true;
    }
}
