package main.entity;

import main.hibernateUtil.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class test {
	
	private static EntityManager manager;
	private static EntityManager emf= HibernateUtil.getSessionFactory().createEntityManager();
	
	public static void main(String[] args){
		imprimirDatos();
	}
	
	private static void imprimirDatos(){
		manager = emf.getEntityManagerFactory().createEntityManager();
		
		Anime anime= manager.find(Anime.class,1L);
		
		List<Episode> episodes = anime.getEpisode();
		for(Episode episode : episodes){
			//System.out.println("* "+episode.toString());
		}
		
		System.out.println(anime);
		emf.close();
	}
}
