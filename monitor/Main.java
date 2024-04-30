package monitor;

public class Main {
    
    public static void main(String[] args) {
    	
        // Cria uma instância da classe Monitor
        Monitor monitor = new Monitor();
        
        // Cria e inicia um thread para incrementar o contador
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                monitor.increment();
            }
            System.out.println("Após incrementar: " + monitor.getCount());
        }).start();
        
        // Cria e inicia um thread para decrementar o contador
        new Thread(() -> {
            for (int i = 0; i < 750; i++) {
                monitor.decrement();
            }
            System.out.println("Após decrementar: " + monitor.getCount());
        }).start();
        
        // Espera para garantir que os threads tenham tempo de executar
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Obtém o valor atual do contador
        int count = monitor.getCount();   
        
        // Imprime o valor do contador após as operações de incremento e decremento
        System.out.println("O valor final do contador é: " + count);
    }
}


