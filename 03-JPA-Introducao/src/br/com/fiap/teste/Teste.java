package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Carro;
import br.com.fiap.entity.Transmissao;

public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		Carro carro = new Carro("Celta", 2010, "1.0", "GM", 
				"DRE-9893", new GregorianCalendar(2010, Calendar.APRIL, 2), 
				false, false, null, Transmissao.MECANICA);
		
		em.getTransaction().begin(); //inicializa uma transa��o
		em.persist(carro);
		em.getTransaction().commit(); //realiza o commit
		
		
		em.close();
		fabrica.close();
	}
}
