package br.com.barrostech.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barrostech.bar.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);

}
