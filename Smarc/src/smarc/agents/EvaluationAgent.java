package agents;

import network.MulticastManager;

public class EvaluationAgent extends Agent {
    private MulticastManager multicastManager;

    public EvaluationAgent(String name, MulticastManager manager) {
        super(name);
        this.multicastManager = manager;
    }

    @Override
    public void performTask() {
        try {
            System.out.println(name + " enviando dados de avaliação...");
            String message = "Avaliação Cardiológica Realizada";
            multicastManager.sendMessage(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
