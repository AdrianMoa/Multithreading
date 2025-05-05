package thread.creation;

public class FirstExample {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				//Code that will run in a new thread
				System.out.println("We are now in thread: "+Thread.currentThread().getName());
				System.out.println("Current thread priority is "+Thread.currentThread().getPriority());
				
				throw new RuntimeException("Intentional Exception");
			}
		});
		
		thread.setName("New Thread - Misbehaving");
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("A critial error happened in thread \""+t.getName()+"\" the error is "
						+ e.getMessage());
			}
		});
		
		System.out.println("We are in thread: " + Thread.currentThread().getName()+ " before starting a new thread.");
		thread.start();
		System.out.println("We are in thread: " + Thread.currentThread().getName()+ " after starting a new thread.");
		
		Thread.sleep(10000); //millis
	}
}
