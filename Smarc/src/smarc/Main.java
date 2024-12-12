import agents.EvaluationAgent;
import agents.MonitoringAgent;
import network.MulticastManager;

public class Main {
    public static void main(String[] args) {
        try {
            MulticastManager manager = new MulticastManager("228.5.6.7", 5000);

            // Inicializando agentes
            Thread evaluationAgent = new Thread(new EvaluationAgent("Agente de Avaliação", manager));
            Thread monitoringAgent = new Thread(new MonitoringAgent("Agente de Monitoramento", manager));

            evaluationAgent.start();
            monitoringAgent.start();

            System.out.println("Sistema SMARC iniciado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}