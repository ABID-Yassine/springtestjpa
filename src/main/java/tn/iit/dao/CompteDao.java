package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entities.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, Long> {

}
