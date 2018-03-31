package server.controller;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerController extends JFrame implements ActionListener {
	Server server;
	JButton button;
	Thread serverThread;
	ServerConnector connector;
	ServletContextHandler context; 

	public ServerController() {

		setTitle("My Gui");
		setSize(400, 400);

		// Create JButton and JPanel
		// JLabel label = new JLabel("Start")
		button = new JButton("Start");
		button.addActionListener(this);
		JLabel label = new JLabel("The Server connection status appears here");
		JPanel panel = new JPanel();

		// Add button to JPanel
		panel.add(button);
		panel.add(label);
		// And JPanel needs to be added to the JFrame itself!
		this.getContentPane().add(panel);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (button.getText().equals("Start")) {
			button.setText("Stop");
			startServer();
			System.out.println("Checkking  asfsafasf");
		}

		else {
			button.setText("Start");
			try {
				context.stop();
				connector.close();
				server.stop();
				serverThread.join();
				
			} catch (Exception e1) {
				System.out.println("Server Stopped");
				e1.printStackTrace();
			}

		}

	}

	private void startServer() {
//		Server server = new Server();
//        ServerConnector connector = new ServerConnector(server);
//        connector.setPort(8080);
//        server.addConnector(connector);
//        // Setup the basic application "context" for this application at "/"
//        // This is also known as the handler tree (in jetty speak)
//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setContextPath("/");
//        server.setHandler(context);
//
//        try
//        {
//            // Initialize javax.websocket layer
//            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
//
//            // Add server end point to the server
//            wscontainer.addEndpoint(ServerSocketEndpoint.class);
//
//            server.start();
//            server.dump(System.err);
//            server.join();
//        }
//        catch (Throwable t)
//        {
//            t.printStackTrace(System.err);
//        }
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				server = new Server();
				connector = new ServerConnector(server);
				connector.setPort(8080);
				server.addConnector(connector);
				// Setup the basic application "context" for this application at "/"
				// This is also known as the handler tree (in jetty speak)
				context = new ServletContextHandler(ServletContextHandler.SESSIONS);
				context.setContextPath("/");
				server.setHandler(context);

				try {
					// Initialize javax.websocket layer
					ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
					// Add server end point to the server
					wscontainer.addEndpoint(ServerSocketEndpoint.class);

					server.start();
					server.dump(System.err);
					// server.join();
				} catch (Throwable t) {
					t.printStackTrace(System.err);
				}
			}
		};
		serverThread = new Thread(serverTask);
		serverThread.start();

	}

	public static void main(String args[]) {
		new ServerController();
	}

}
