package com.cod.jam.service.impl;


import com.cod.jam.model.Usuario;
import com.cod.jam.repository.UsuarioRepository;
import com.cod.jam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cod.jam.exception.ModelNotFoundExcept;
import javax.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        System.out.println("gg");
        return usuarioRepository.findAll();
    }


    @Override
    public Usuario findById(Integer id) throws Exception{
        Optional<Usuario> usuarioO=usuarioRepository.findById(id);
        if(!usuarioO.isPresent()){
            throw new ModelNotFoundExcept("ID NO ENCONTRADO: " + id);
        }
        return usuarioO.isPresent() ? usuarioO.get() : new Usuario();
    }

    @Override
    public Usuario save(Usuario usuario) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Usuario user = usuarioRepository.save(usuario);
        return usuarioRepository.save(user);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(!optionalUsuario.isPresent()){
            throw new Exception("el id: " + id+", no se encontró");
        }
       usuarioRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<Usuario> listarPageable(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByUsername(username);
        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        usuario.getRols().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), roles);
        return ud;
    }
}
