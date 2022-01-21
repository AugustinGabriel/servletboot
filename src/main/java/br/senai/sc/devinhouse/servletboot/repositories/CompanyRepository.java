package br.senai.sc.devinhouse.servletboot.repositories;

import br.senai.sc.devinhouse.servletboot.models.Company;

import java.util.List;

public interface CompanyRepository {

	List<Company> findAll();

	Company findById(int id) throws Exception;

	Company save(Company company);

	Company save(int id, Company updatedCompany) throws Exception;

	void delete(int id) throws Exception;

}
