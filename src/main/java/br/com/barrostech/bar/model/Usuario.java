package br.com.barrostech.bar.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	private String username;
	
	private String password;
	
	private String nome;

	@ManyToMany
	@JoinTable(name = "usuario_roles",joinColumns = @JoinColumn(
			name = "usuario_id",referencedColumnName = "username"),
			inverseJoinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "nomeRole"))
	private List<Role>roles;


	public List<Role> getRole() {
		return roles;
	}

	public void setRole(List<Role> role) {
		this.roles = role;
	}

	public String getNome() {
		return nome;
	}

	public void setNomeCompleto(String nome) {
		this.nome = nome;
	}

	

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
