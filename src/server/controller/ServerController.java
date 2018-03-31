package server.controller;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerController extends JFrame {
    Server server;
    JButton button;


    public ServerController() {

        setTitle("My Gui");
        setSize(400, 400);

        // Create JButton and JPanel
//        JLabel label = new JLabel("Start")
        button = new JButton("Start");
        JLabel label = new JLabel("The Server connection status appears here");
        JPanel panel = new JPanel();

        // Add button to JPanel
        panel.add(button);
        panel.add(label);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (button.getText().equals("Start"))
                {


                    server = new Server();
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
                        server.join();
                    } catch (Throwable t) {
                        t.printStackTrace(System.err);
                    }


                    button.setText("Stop");


                }



                else
                {
                    button.setText("Start");
                    try {
                        server.stop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        ServerController view = new ServerController();
    }

}
