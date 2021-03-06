package end_to_end_test;


import org.economicsl.Simulation;

/**
 * Created by taghawi on 28/03/17.
 */
public class End2EndTestMessage {
    public static final int NUM_AGENTS = 15;
    public static final int ROUNDS = 16;
    private MessageAgent[] agent;
    private Simulation simulation;

    public void init() {

        simulation = new Simulation();
        agent = new MessageAgent[NUM_AGENTS];
        agent[0] = new MessageAgent(Integer.toString(0), null, 0 % 2, simulation);
        for(int i = 1; i < NUM_AGENTS; i++) {
            agent[i] = new MessageAgent(Integer.toString(i), agent[i - 1], i % 2, simulation);
        }
        agent[0].setFriend(agent[NUM_AGENTS - 1]);
    }

    private void run() {
        for (int time = 0; time < ROUNDS; time++) {
            System.out.println("\nTime step: " + time+ "\n^^^^^^^^^^^^^");

            for (MessageAgent child: agent) {
                child.say();
            }
            for (MessageAgent child: agent) {
                child.hear();
            }
            for (MessageAgent child: agent) {
                child.step();
            }
            simulation.advance_time();
        }
    }


    public static void main(String[] args) {
        End2EndTestMessage simulation = new End2EndTestMessage();
        simulation.init();
        simulation.run();
    }
}
