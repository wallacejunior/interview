package model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.*;

@Entity
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne(cascade = CascadeType.ALL)
	private long Id;
	private String nome = "";
	private String sexo;
	private Date dtNacimento;
	private int idade;
	private CidadeEntity cidade;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDtNacimento() {
		return dtNacimento;
	}
	public void setDtNacimento(Date dtNacimento) {
		this.dtNacimento = dtNacimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public CidadeEntity getCidade() {
		return cidade;
	}
	public void setCidade(CidadeEntity cidade) {
		this.cidade = cidade;
	}
	
}
