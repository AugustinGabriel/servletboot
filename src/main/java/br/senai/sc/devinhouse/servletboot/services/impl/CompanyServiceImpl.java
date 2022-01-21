package br.senai.sc.devinhouse.servletboot.services.impl;

import br.senai.sc.devinhouse.servletboot.models.Company;
import br.senai.sc.devinhouse.servletboot.repositories.CompanyRepository;
import br.senai.sc.devinhouse.servletboot.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	public Company getCompanyById(int id) throws Exception {
		return companyRepository.findById(id);
	}

	public Company create(Company company) {
		return companyRepository.save(company);
	}

	public Company update(int id, Company updatedCompany) throws Exception {
		return companyRepository.save(id, updatedCompany);
	}

	public void remove(int id) throws Exception {
		companyRepository.delete(id);
	}

}
