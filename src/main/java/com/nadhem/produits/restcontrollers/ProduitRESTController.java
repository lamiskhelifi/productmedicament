package com.nadhem.produits.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nadhem.produits.ProduitDTO;
import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.service.ProduitService;

import jakarta.persistence.OneToMany;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
@Autowired
ProduitService produitService;
@RequestMapping(method = RequestMethod.POST)
public ProduitDTO createProduit(@RequestBody ProduitDTO produitDTO) {
return produitService.saveProduit(produitDTO);
}
@RequestMapping(method = RequestMethod.PUT)
public ProduitDTO updateProduit(@RequestBody ProduitDTO produitDTO) {
return produitService.updateProduit(produitDTO);
}

@JsonIgnore
@OneToMany(mappedBy = "categorie")
private List<Produit> produits;

}