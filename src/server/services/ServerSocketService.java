package server.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import server.controller.ServerSocketEndpoint;
import server.listener.LogListener;

public class ServerSocketService {
	Thread serverThread;
	LogListener logListener;

	public void startServer() {
		final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
		Runnable serverTask = new Runnable() {
			@Override
			public void run() {
				Server server = new Server();
				ServerConnector connector = new ServerConnector(server);
				connector.setPort(8080);
				server.addConnector(connector);
				// Setup the basic application "context" for this application at "/"
				// This is also known as the handler tree (in jetty speak)
				ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
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


}
