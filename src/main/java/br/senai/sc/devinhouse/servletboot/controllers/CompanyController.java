package br.senai.sc.devinhouse.servletboot.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.devinhouse.servletboot.models.Company;
import br.senai.sc.devinhouse.servletboot.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> get() {
        System.out.println("GET :");
        List<Company> companys;
        try {
            companys = companyService.getAllCompanies();
        } catch (Exception e) {
            return null;
        }
        return companys;
    }

    @GetMapping("/{id}")
    public Company getId(@PathVariable("id") Integer id) {
        System.out.println("GET :" + id);
        Company company;
        try {
            company = companyService.getCompanyById(id);
        } catch (Exception e) {
            return null;
        }
        return company;
    }

    @PostMapping
    public Company post(@RequestBody Company company) {
        System.out.println("POST :" + company);
        company = companyService.create(company);
        return company;
    }

    @PutMapping("/{id}")
    public Company put(@PathVariable("id") Integer id, @RequestBody Company company) throws Exception {
        System.out.println("PUT: " + company);
        company = companyService.update(id, company);
        return company;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        System.out.println("DELETE: " + id);
        try {
            companyService.remove(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
