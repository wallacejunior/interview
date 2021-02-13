package model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.*;

@Document
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String name = "";
	private String gender;
	private Date dtBirth;
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	private CidadeEntity city;
}
