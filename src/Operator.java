/**
 * Control the time of shield activation and deactivation.
 *
 * @author Wenzhou Wei (903836)
 */
public class Operator extends Thread {

    private Berth berth;

    Operator(Berth berth) {
        this.berth = berth;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                // activate and deactivate the shield periodically
                sleep(Params.debrisLapse());
                getBerth().activateShield();
                sleep(Params.DEBRIS_TIME);
                getBerth().deactivateShield();
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }

    // getters and setters
    public Berth getBerth() {
        return berth;
    }

    public void setBerth(Berth berth) {
        this.berth = berth;
    }

}
