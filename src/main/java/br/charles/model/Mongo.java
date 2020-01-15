package br.charles.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class Mongo {
	private Integer chave;
	private String valor;
}