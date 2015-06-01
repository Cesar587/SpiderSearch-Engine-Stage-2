package Hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class PoolHilos {
	
	public PoolHilos(int cantidad){
		ExecutorService hilos = Executors.newFixedThreadPool(cantidad);
		
	}

}
