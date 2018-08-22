package main.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(
		name = "Episode",
		uniqueConstraints =  @UniqueConstraint(
				name = "uk_episode_title_anime",
				columnNames = {
						"title",
						"episode",
						"parentId"
				}
		)
)
@Cacheable(true)
public class Episode implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "episode_id")
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private double episode;
	
	@Column
	private Long parentId;
	
	//@ElementCollection(targetClass=Anime.class,fetch = FetchType.EAGER)
	
	/*@ManyToMany( mappedBy = "episodes" ,fetch = FetchType.EAGER)
	private List<Anime> anime;
	
	public List<Anime> getAnime() {
		return anime;
	}
	
	public void setAnime(List<Anime> anime) {
		this.anime = anime;
	}
	*/
	// use optional=false (much faster) @OneToMany(optional = false)
	@JsonbTransient
	 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn(
			 name = "anime_id",
			 foreignKey = @ForeignKey(name = "fk_episode_anime_id")
	 )
	private Anime anime;
	
	public Anime getAnime() {
		return anime;
	}
	
	@JsonbTransient
	public void setAnime(Anime anime) {
		this.anime = anime;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
	public Episode(String title, double episode, Long parentId, Anime anime) {
		this.title = title;
		this.episode = episode;
		this.parentId = parentId;
		this.anime = anime;
	}
	
	public Episode() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long  id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getEpisode() {
		return episode;
	}
	
	public void setEpisode(double episode) {
		this.episode = episode;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
	
	@Override
	public String toString() {
		return "Episode{"+
				"id="+id+
				", title='"+title+'\''+
				", episode="+episode+
				", parentId="+parentId+
				", anime="+anime+
				", createDate="+createDate+
				", updateDate="+updateDate+
				'}';
	}
}
