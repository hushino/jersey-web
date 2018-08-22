package main.resources;


import main.entity.Anime;
import main.entity.Episode;
import main.service.EpisodeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes( MediaType.APPLICATION_JSON)
public class EpisodeResource {
	
	private EpisodeService episodeService = new EpisodeService();
	//  Solo trae los caps de un anime
	@GET
	@Path("/{animeId}")
	public List<Episode> getAllEpisodesOfAnAnime(@PathParam("animeId") Long animeId){
		return episodeService.getAllEpisodesOfAnAnime(animeId);
	}
	
	@GET
	@Path("/{animeId}/v")
	public Anime getAnimeOfAnEpisode(@PathParam("animeId") Long animeId){
		return episodeService.getAnimeOfAnEpisode(animeId);
	}
	
	/* @GET
	@Path("/{animeId}")
	public List<Episode> getAllEpisodesWithAnime(@PathParam("animeId") Long animeId){
		return episodeService.getAllEpisodesWithAnime(animeId);
	}*/
	
	@POST
	@Path("/{animeId}")
	public Episode addEpisode(@PathParam("animeId") Long animeId, Episode episode){
		return episodeService.addEpisode(animeId,episode);
	}
	
	
	/*@POST
	public Episode addEpisode(@PathParam("animeId") long animeId, Episode episode){
		return episodeService.addEpisode(animeId,episode);
	}*/
	
	/*@GET
	@Path("/{episodeId}")
	public List<Episode> getEpisodesOfAnAnime(){
	
	}*/
	
}
