package br.senai.sc.devinhouse.servletboot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	private Integer id;
    private String name;
    private String cnpj;

}
