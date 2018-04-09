package client.model;

public class ClientConfigurationSingleton {
    private static volatile ClientConfigurationSingleton clientConfiguration;
    private static Object mutex = new Object();
    public String ip;
    public String port;

    public static ClientConfigurationSingleton getInstance() {
        ClientConfigurationSingleton result = clientConfiguration;
        if (result == null) {
            synchronized (mutex) {
                result = clientConfiguration;
                if (result == null) {
                    result = new ClientConfigurationSingleton();

                }
                clientConfiguration = result;
            }
        }
        return result;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
