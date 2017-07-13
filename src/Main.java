import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int opcao = menu();
		
		if(opcao == 1){
			partida();
		}else{
			campeonato();
		}
	}

static int computadorEscolhe(int n,int m)
{
	if(m >= n){		
		return n;
	}else{
		
		//Retorno a sobra de n % (m+1)
		int quantRemover = n % (m+1);
		
		if(quantRemover > 0){
			return quantRemover;
		}else{
			return m;
		}
	}
}

 static int usuarioEscolhe(int n, int m) {
	
	Scanner dado = new Scanner(System.in);
	
	System.out.println("Quantas pecas vai retirar? ");
	int pecas = dado.nextInt();
	
	while (pecas > m || pecas <= 0)
	{
		System.out.println("Oops ! Jogada invalida ! Quantas pecas vai retirar? ");
		pecas = dado.nextInt();
	}
	
	return pecas;
}
	
	
static int menu()
{
	Scanner dado = new Scanner(System.in);
	
	System.out.println("Bem-vindo ao jogo do NIM! Escolha: ");
	System.out.println("1 - para jogar uma partida isolada");
	System.out.println("2 - para jogar um campeonato ");
	
	//Retorno a opcao escolhida
	return dado.nextInt();
	
}

static int partida()
{
	Scanner dado = new Scanner(System.in);
	
	//Controla a vez do computador
	boolean computerTurn = false;
	int aux;
	
	System.out.println("Quantas pecas? ");
	int n = dado.nextInt();
	
	System.out.println("Limite de pecas por jogada? ");
	int m = dado.nextInt();
	
        while (n < m || n <= 0 || m <= 0){
            System.out.println("Oops ! Quantidade invalida ! Quantas pecas? ");
            n = dado.nextInt();
	
            System.out.println("Oops ! Quantidade invalida ! Limite de pecas por jogada? ");
            m = dado.nextInt();
        }
        
	//Computador inicia a jogada se N nao for multiplo de M
	if((n % (m+1)) != 0){
		computerTurn = true;
		System.out.println("\nComputador comeca!");
		
	}else{
		System.out.println("\nVoce comeca!");
	}
	
	while (n != 0)
	{
		if(computerTurn){
			aux = computadorEscolhe(n, m);
			n -= aux;
			System.out.println("O computador retirou " + aux + " pecas.");
			System.out.println("Restam " + n + " pecas.");
			computerTurn = false;
		}else{
			aux = usuarioEscolhe(n, m);
			n -= aux;
			System.out.println("Voce retirou " + aux + " pecas.");
			System.out.println("Restam " + n + " pecas.");
			computerTurn = true;
		}
	}
	
	if(!computerTurn) 
	{
		System.out.println("\nO computador venceu!");
		return 0;
	}else{
		System.out.println("\nO Voce venceu!");
		return 1;
	}
}

//Elabora um campeonato, jogando 03 vezes consecutivas
static void campeonato()
{
	int aux;
	int voce = 0;
	int computer = 0;
	
	for (int i = 0; i < 3; i++) {
		
		System.out.println("**** Rodada " + i + " ****\n");
		
		aux = partida();
		
		if(aux == 0)
		{
			computer++;
		}else{
			voce++;
		}
		
	}
	
	System.out.println("Placar: Voce " + voce + " X " + computer + " Computador");
	
}
	

}
