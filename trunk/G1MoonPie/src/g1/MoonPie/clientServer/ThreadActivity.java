package g1.MoonPie.clientServer;


public class ThreadActivity implements Runnable{
	
	Thread communicationThread;
	
	
	@Override
	public void run() {
		System.out.println("inside thread");
		try {
        	System.out.println("try connect");
			ClientLauncher client = new ClientLauncher();
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
		}
		
	}
}


	



