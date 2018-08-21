package main.resources;


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
	@Path("/{episodeId}")
	public List<Episode> getAllEpisodesOfAnAnime(@PathParam("animeId") Long animeId){
		return episodeService.getAllEpisodesOfAnAnime(animeId);
	}
	
	@POST
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
