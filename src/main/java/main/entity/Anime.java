package main.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Cacheable(true)
public class Anime implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "anime_id")
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String data;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "anime", cascade = CascadeType.ALL)
	private List<Episode> episode = new ArrayList<>();
	/*@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "ANIME_EPISODE", joinColumns = { @JoinColumn(name = "ANIME_ID") },
			inverseJoinColumns = {@JoinColumn(name = "EPISODE_ID") })
	private List<Episode> episodes = new ArrayList<Episode>();
	
	public List<Episode> getEpisodes() {
		return this.episodes;
	}
	
	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}
	*/
	public Anime(String title, String data) {
		this.title = title;
		this.data = data;
	}
	
	public Anime(){
	
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
}