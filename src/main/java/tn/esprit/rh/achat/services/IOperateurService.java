package tn.tekup.rh.achat.services;

import tn.tekup.rh.achat.entities.Operateur;

import java.util.List;


public interface IOperateurService {

	List<Operateur> retrieveAllOperateurs();

	Operateur addOperateur(Operateur o);

	void deleteOperateur(Long id);

	Operateur updateOperateur(Operateur o);

	Operateur retrieveOperateur(Long id);

}
