package com.nadhem.produits.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nadhem.produits.ProduitDTO;
import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.repos.ProduitRepository;
public interface ProduitService {
Produit saveProduit(Produit p);
Produit updateProduit(Produit p);
void deleteProduit(Produit p);
void deleteProduitById(Long id);
Produit getProduit(Long id);
List<Produit> getAllProduits();
List<Produit> findByNomProduit(String nom);
List<Produit> findByNomProduitContains(String nom);
List<Produit> findByNomPrix (String nom, Double prix);
List<Produit> findByCategorie (Categorie categorie);
List<Produit> findByCategorieIdCat(Long id);
List<Produit> findByOrderByNomProduitAsc();
List<Produit> trierProduitsNomsPrix();

@Service
public class ProduitServiceImpl implements ProduitService {
@Autowired
ProduitRepository produitRepository;
@Override
public ProduitDTO saveProduit(Produit p) {
return convertEntityToDto( produitRepository.save(p));
}
@Override
public ProduitDTO getProduit(Long id) {
return convertEntityToDto( produitRepository.findById(id).get());
}
@Override
public List<ProduitDTO> getAllProduits() {
	return produitRepository.findAll().stream()
			.map(this::convertEntityToDto)
			.collect(Collectors.toList());
			//OU BIEN
			/*List<Produit> prods = produitRepository.findAll();
			List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
			for (Produit p : prods)
			listprodDto.add(convertEntityToDto(p));
			return listprodDto;*/
			}
Produit convertDtoToEntity(ProduitDTO produitDto);
@Override
public Produit convertDtoToEntity(ProduitDTO produitDto) {
Produit produit = new Produit();
produit.setIdProduit(produitDto.getIdProduit());
produit.setNomProduit(produitDto.getNomProduit());
produit.setPrixProduit(produitDto.getPrixProduit());
produit.setDateCreation(produitDto.getDateCreation());
produit.setCategorie(produitDto.getCategorie());
 return produit;
}
ProduitDTO saveProduit(ProduitDTO p);
ProduitDTO updateProduit(ProduitDTO p);
@Override
public ProduitDTO saveProduit(ProduitDTO p) {
 return convertEntityToDto( produitRepository.save(convertDtoToEntity(p)));
}
@Override
public ProduitDTO updateProduit(ProduitDTO p) {
 return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)))
}


}
}