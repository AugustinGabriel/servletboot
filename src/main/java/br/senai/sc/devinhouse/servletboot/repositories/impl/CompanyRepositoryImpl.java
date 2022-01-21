package br.senai.sc.devinhouse.servletboot.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sc.devinhouse.servletboot.models.Company;
import br.senai.sc.devinhouse.servletboot.repositories.CompanyRepository;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

	private int maxId = 1;

	private List<Company> companies = new ArrayList<>();

	public List<Company> findAll() {
		return this.companies;
	}
	
	public Company findById(int id) throws Exception {
		for (Company company : companies) {
			if (company.getId() == id) {
				return company;
			}
		}
		throw new Exception("Empresa com id " + id + " não encontrado");
	}

	public Company save(Company company) {
		company.setId(maxId++);
		this.companies.add(company);
		return company;
	}

	public Company save(int id, Company updatedCompany) throws Exception {
		Company currentCompany = this.findById(id);
		currentCompany.setName(updatedCompany.getName());
		currentCompany.setCnpj(updatedCompany.getCnpj());
		return currentCompany;
	}

	public void delete(int id) throws Exception {
		Company currentCompany = this.findById(id);
		companies.remove(currentCompany);
	}

}
