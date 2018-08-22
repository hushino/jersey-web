package main.resource;


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
	
	@POST
	@Path("/{animeId}")
	public Episode addEpisode(@PathParam("animeId") Long animeId, Episode episode){
		return episodeService.addEpisode(animeId,episode);
	}
	
	@PUT
	@Path( "/{animeId}" )
	public Episode putEpisode(@PathParam( "animeId" ) Long animeId, Episode episode) {
		episode.setId(animeId);
		return episodeService.putEpisode(animeId, episode);
	}
	
	@DELETE
	@Path( "/{episodeId}" )
	public void deleteEpisode(@PathParam( "episodeId" ) Long episodeId) {
		episodeService.removeEpisode(episodeId);
	}
}
