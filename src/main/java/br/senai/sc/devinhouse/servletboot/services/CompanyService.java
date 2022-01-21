package br.senai.sc.devinhouse.servletboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senai.sc.devinhouse.servletboot.models.Company;

@Service
public interface CompanyService {

	List<Company> getAllCompanies();
	
	Company getCompanyById(int id) throws Exception;

	Company create(Company company);

	Company update(int id, Company updatedCompany) throws Exception;

	void remove(int id) throws Exception;

}
