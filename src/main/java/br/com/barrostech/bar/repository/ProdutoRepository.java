package br.com.barrostech.bar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.barrostech.bar.model.Produtos;
@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

	@Query("select p from Produtos p where p.nome like %?1%")
	List<Produtos> findProdByNome(String produto);

	@Query("select p from Produtos p where p.barras like %?1%")
	List<Produtos> findProdByCod(String codigo);
}
