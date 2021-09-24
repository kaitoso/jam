package com.cod.jam.service;

import com.cod.jam.model.ResetToken;

public interface ResetTokenService {
    ResetToken findByToken(String token);



    void eliminar(ResetToken token);
}
