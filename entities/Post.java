package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Post {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
	}

	public Post(String moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void AddComment(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComment(int comentario) {
		comments.remove(comentario);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" Likes - ");
		sb.append((moment) + "\n");
		sb.append(content + "\n");
		sb.append("Comments:\n");
		int contador = 1;
		for (Comment c : comments) {
			sb.append("#" + contador + " - " + c.getText() + "\n");
			contador++;
		}
		return sb.toString();
	}
	
	public void darLike() {
		likes++;
	}
	
	public void unLike() {
		if (likes != 0) {
			likes--;
		}
	}
	
}
