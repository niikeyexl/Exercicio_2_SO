package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSemaforo;

public class Main {

	public static void main(String[] args) {
		int qtdThread = 4;
		Semaphore farol = new Semaphore(1);
		for (int i = 0; i < qtdThread; i++) new ThreadSemaforo(farol, i).start();
		
		
	}

}
