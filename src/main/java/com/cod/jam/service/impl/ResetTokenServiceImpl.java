package com.cod.jam.service.impl;

import com.cod.jam.model.ResetToken;
import com.cod.jam.repository.ResetTokenRepository;
import com.cod.jam.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {
    @Autowired
    private ResetTokenRepository repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    /*@Override
    public void guardar(ResetToken token) {
        repo.save(token);

    }*/

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }
}
