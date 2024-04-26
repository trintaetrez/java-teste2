package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

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
				case 3:
					if (posts.size() == 0) {
						System.out.println("Nenhum post realizado ainda.");
					} else {
						for (Post post : posts) {
							System.out.println(post.toString());
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
