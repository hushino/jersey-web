package main.service;

import main.entity.Anime;
import main.entity.Episode;
import main.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EpisodeService {
	
	private Session session = null;
	private Transaction transaction = null;
	
	public List<Episode> getAllEpisodesOfAnAnime(Long animeId) {
		session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Episode> arreglo = new ArrayList<>();
		for (Object oneObject : session.createQuery("FROM Episode t WHERE t.parentId=:animeId ORDER BY t.updateDate ASC ")
				.setParameter("animeId", animeId)
				.getResultList())
		{
			arreglo.add((Episode) oneObject);
		}
		session.close();
		return arreglo;
	}
	
	//"FROM Anime a join a.episode r where r.parentId=:animeId" trae el anime del cap
	public Episode addEpisode(Long animeId, Episode episode) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.getTransaction();
		transaction.begin();
		episode.setParentId(animeId);
		session.save(episode);
		transaction.commit();
		session.close();
		return episode;
	}
	
	/*public Episode addEpisode(long animeId, Episode episode) {
		session = HibernateUtil.getSessionFactory().openSession();
		Anime anime= getalgo(animeId, Anime.class);
		
		//Map<Long, Episode> comments = messages.get(messageId).getComments();
		ArrayList<Anime> arreglo = new ArrayList<>();
		for (Object oneObject : session.createQuery("FROM Anime a ORDER BY a.updateDate DESC")
				.getResultList())
		{
			//arreglo.add((Anime) oneObject);
			//episode.setId( oneObject. );
			//episode.setId(( long ) (arreglo.size()+1));
			// arreglo.set()
		    //arreglo.add(episode.getId(), episode);
		}
		
		session.close();
		return episode;
	}*/
}
