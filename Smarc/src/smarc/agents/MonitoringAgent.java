package agents;

import network.MulticastManager;

public class MonitoringAgent extends Agent {
    private MulticastManager multicastManager;

    public MonitoringAgent(String name, MulticastManager manager) {
        super(name);
        this.multicastManager = manager;
    }

    @Override
    public void performTask() {
        try {
            System.out.println(name + " monitorando dados do sistema...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
