package com.nadhem.produits.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.entities.Produit;
public interface ProduitRepository extends JpaRepository<Produit, Long> {

		List<Produit> findByNomProduit(String nom);
		 List<Produit> findByNomProduitContains(String nom);

		 @Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
		 List<Produit> findByNomPrix (String nom, Double prix);
		 @Query("select p from Produit p where p.categorie = ?1")
		 List<Produit> findByCategorie (Categorie categorie);
		 List<Produit> findByOrderByNomProduitAsc();
		
		@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
		List<Produit> trierProduitsNomsPrix ();
	
}
