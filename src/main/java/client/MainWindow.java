package client;

public class MainWindow {
	
	private int userId;
	private ClientConnection cn;
	
	public MainWindow(int userId, ClientConnection cn) {
		this.userId = userId;
		this.cn = cn;
	}
}
