package cacapalavras;

import java.util.Scanner;

public class CacaPalavras {
	
			static String tabuleiro[] = new String[] {
					
			"cllll1l",
			"alxxxxa",
			"ccafefg",
			"oppuddo",
			"ffffdxx",
			"xxxxxig",
			"hhhhhpo"
			
			};			
			
			//mapeando palavras no tabuleiro
			static int claudio [][] = new int[][] {{1,1,1},{2,1,2},{3,1,3},{4,1,4},{5,1,5},{6,1,6},{7,1,7}};
			static int lago [][] = new int [][] {{1,1,7},{2,1,7},{3,1,7},{4,1,7}};
			static int cafe[][] = new int [][]{{3,1,2},{3,1,3},{3,1,4},{3,1,5}};
			static int caco[][] = new int [][] {{1,1,1},{2,1,1},{3,1,1},{4,1,1}};
			//
			
			static String palavrasdigitadas[] = new String[4];
			static char exibirpalavras[][] = new char[tabuleiro.length][tabuleiro.length];
			static String palavraaux = "";

	public static void main(String[] args) {
		
		for(int i = 0; i < tabuleiro.length;i++) {
			
			for(int j = 0 ; j< tabuleiro[i].length();j++) {
				
				System.out.print(tabuleiro[i].charAt(j)+" ");
			}
			
			System.out.println();
			
		}
		
		System.out.println();
		
		int x = 0;
		
		inicio(x);
		
	}
	
	public static void inicio(int x) {
		
		while(x<4) {
			
		System.out.print("Digite uma palavra que esteja no tabuleiro-->");	
		Scanner entrada = new Scanner(System.in);
		String palavrateste = entrada.nextLine();
		
			for(int y = 0;y<palavrasdigitadas.length;y++) {
			
				if(palavrateste.equals(palavrasdigitadas[y])) {
				
				System.out.print("Você já digitou essa palavra\n");
				
				inicio(x);
				
				}
			
			}
		
			if(palavrateste.toUpperCase().equals(verificaPalavra(claudio).toUpperCase()) ||
					palavrateste.toUpperCase().equals(verificaPalavra(lago).toUpperCase()) ||
					palavrateste.toUpperCase().equals(verificaPalavra(cafe).toUpperCase()) ||
					palavrateste.toUpperCase().equals(verificaPalavra(caco).toUpperCase())) {
			
				if( 3-x > 0) {
				
					System.out.print("A Palavra está certa "+palavrateste.toUpperCase()+"\n"+"Ainda faltam "+(3-x)+" palavras\n");
				
				}else {
				
					System.out.print("A Palavra está certa "+palavrateste.toUpperCase()+"\n");
				
				}
				
				palavrasdigitadas[x] = palavrateste;
			
				if(x == 3) {
					
					for(int y = 0; y < exibirpalavras.length;y++) {
						
						for (int z = 0; z < exibirpalavras[y].length;z++ ) {
								
							System.out.print(exibirpalavras[y][z]+" ");
							
						}
							
						System.out.println();
					

					}
					
					System.out.println("Parabens vc acertou todas as palavras ocultas do tabuleiro");

					
					System.exit(0);
					
				}
				
				x++;
			
				System.out.println();
				
			}else{
		
				System.out.print("A Palavra está errada\n"+"Ainda faltam "+(4-x)+" palavras\n");

			}		
		}
	}

	public static String verificaPalavra(int [][] vetorpalavra) {
		
			int j = 0;
			int index = 0;
			String palavra[];
			String palavrafinal="";
			String palavratemp;
			
			for(int i = 0; i<vetorpalavra.length;i++) {

				index = vetorpalavra[i][j]-1;
				palavra = tabuleiro[index].split(" ");
				palavratemp = palavra[(vetorpalavra[i][(j+1)])-1];
				exibirpalavras[index][vetorpalavra[i][(j+2)]-1] = palavratemp.charAt((vetorpalavra[i][(j+2)])-1);
				palavrafinal += palavratemp.charAt((vetorpalavra[i][(j+2)])-1);
				
		    }
			
			return palavrafinal;
	}
}


