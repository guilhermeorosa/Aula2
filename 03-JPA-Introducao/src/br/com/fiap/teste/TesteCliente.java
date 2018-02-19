package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Sexo;
import br.com.fiap.entity.Status;

public class TesteCliente {

	public static void main(String[] args) {
		EntityManagerFactory cartorio =
				Persistence.createEntityManagerFactory("oracle");
		EntityManager emm = cartorio.createEntityManager();
		
		Cliente cliente = new Cliente
				("Guilherme",new GregorianCalendar(1997, Calendar.OCTOBER, 26), 
						0, Sexo.MASCULINO, null , Status.ATIVO);
		
		emm.getTransaction().begin();
		emm.persist(cliente);
		emm.getTransaction().commit();
		
		
		emm.close();
		cartorio.close();

	}

}
