package br.com.softblue.java.concurrent.exercicio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	
	private static final int TAMANHO = 5;
	
	private int[] b = new int [TAMANHO];
	
	private int posInsere;
	
	private int posRemove;
	
	private int qtdeItens;
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition cond = lock.newCondition();
	
	public void inserir(int item) {
		lock.lock();
		
		try {
			while(qtdeItens == TAMANHO) {
				try {
					cond.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(qtdeItens == 0) {
				cond.signalAll();
			}
			
			b[posInsere] = item;
			posInsere = (posInsere + 1) % TAMANHO;
			qtdeItens++;
			
			imprimir();
			
		} finally {
			lock.unlock();
		}
	}
	
	public int remover() {
		lock.lock();
		
		try {
			while(qtdeItens == 0) {
				try {
					cond.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(qtdeItens == TAMANHO) {
				cond.signalAll();
			}
			
			int item = b[posRemove];
			posRemove = (posRemove + 1) % TAMANHO;
			qtdeItens--;
			
			imprimir();
			return item;
			
			} finally {
				lock.unlock();
			}
	}
	
	public void imprimir() {
		int i = posRemove;
		int qtdeImpressos = 0;
		
		boolean vazio = true;
		while(qtdeImpressos < qtdeItens) {
			vazio = false;
			System.out.println(b[i] + " ");
			i = (i + 1) % TAMANHO;
			qtdeImpressos++;
		}
		
		if(vazio) {
			System.out.println("-");
		}
		
		System.out.println();
	}

}
