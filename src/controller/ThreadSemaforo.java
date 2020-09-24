package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforo extends Thread {
	private static final String DIR[] = {"Direita", "Cima", "Esquerda", "Baixo"};
	private Semaphore semaforo;
	private int sentido;
	public ThreadSemaforo(Semaphore sem, int dir) {
		this.semaforo = sem;
		this.sentido = dir;
	}
	
	@Override
	public void run() {
		atravessando();
	}

	private void atravessando() {
		int dir_o = (this.sentido + 2) % 4;
		try {
			this.semaforo.acquire();
			System.out.println("O carro está atravessando do sentido de " + DIR[this.sentido] + " para " + DIR[dir_o]);
			sleep(3000);
			System.out.println("O carro atravessou no sentido de " + DIR[this.sentido] + " para " + DIR[dir_o]);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.semaforo.release();
		}
		
	}

}
