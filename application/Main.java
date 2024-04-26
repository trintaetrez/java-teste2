package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Post;
import utilities.Menu;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@                                            @");
		System.out.println("@   Social Choke - The bjj true connection   @");
		System.out.println("@                                            @");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("OSSS !!");
		System.out.println("Bem vindo a Social Choke !! A rede social que conecta os amantes da arte suave !");
		Menu menu = new Menu(sc);
		menu.showMenu();
		List<Post> posts = new ArrayList<>();
		int op = menu.getOp();
		while (op != 0) {
			switch (op) {
				case 1:
					String currentDate = sdf.format(new Date());
					System.out.print("Digite o título do post: ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("Digite o conteúdo: ");
					String content =  sc.nextLine();
					posts.add(new Post(currentDate, title, content, 0));
					System.out.println();
					System.out.println("Post feito.");
					menu.showMenu();
					op = menu.getOp();
					break;
				case 2:
					if (posts.size() == 0) {
						System.out.println("Nenhum post realizado ainda.");
					} else {
						int contador = 1;
						for (Post post : posts) {
							System.out.println(contador + " - " + post.toString());
							contador++;
						}
						System.out.print("Digite o número do post a ser removido: ");
						int postRemovido = sc.nextInt();
						posts.remove(postRemovido - 1);
						System.out.println("Post removido.");
					}
					menu.showMenu();
					op = menu.getOp();
					break;
				case 3:
					if (posts.size() == 0) {
						System.out.println("Nenhum post realizado ainda.");
					} else {
						int contador = 1;
						for (Post post : posts) {
							System.out.println(contador + " - " + post.toString());
							contador++;
						}
					}
					menu.showMenu();
					op = menu.getOp();
					break;
				case 4:
					if (posts.size() == 0) {
						System.out.println("Nenhum post realizado ainda.");
					} else {
						int contador = 1;
						for (Post post : posts) {
							System.out.println(contador + " - " + post.toString());
							contador++;
						}
						System.out.print("Digite o número do Post que você quer comentar: ");
						int numeroPost = sc.nextInt();
						for (Post post: posts) {
							if (posts.indexOf(post) == (numeroPost-1)) {
								System.out.print("Digite o comentário: ");
								sc.nextLine();
								String comentario = sc.nextLine();
								post.AddComment(new Comment(comentario));
								System.out.println("Comentário adicionado.");
							} else {
								System.out.println("Esse Post não existe.");
							}
						}
					}
					menu.showMenu();
					op = menu.getOp();
					break;
				case 5:
					if (posts.size() == 0) {
						System.out.println("Nenhum post realizado ainda.");
					} else {
						int contador = 1;
						for (Post post : posts) {
							System.out.println(contador + " - " + post.toString());
							contador++;
						}
						System.out.print("Digite o número do Post que você quer remover o comentário: ");
						int numeroPost = sc.nextInt();
						for (Post post: posts) {
							if (posts.indexOf(post) == (numeroPost-1)) {
								System.out.print("Digite o número do comentário que você quer remover: ");
								int comentario = sc.nextInt();
								post.removeComment(comentario-1);
								System.out.println("Comentário excluído.");
							} else {
								System.out.println("Esse Post não existe.");
							}
						}
					}
					menu.showMenu();
					op = menu.getOp();
					break;
					
			}
		}
		System.out.println();
		System.out.println("Programa encerrado.");
		
		sc.close();

	}

}
