package br.com.barrostech.bar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.barrostech.bar.model.Produtos;
@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produtos, Long> {

	@Query("select p from Produtos p where p.nome like %?1%")
	List<Produtos> findProdByNome(String produto);

	@Query("select p from Produtos p where p.barras like %?1%")
	List<Produtos> findProdByCod(String codigo);
	
	@Query("select p from Produtos p where p.validade between ?1 and ?2 ")
	List<Produtos> findProdByValidade(String data_inicio,String data_final);
}
