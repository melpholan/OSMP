package ru.melpholan.osmp.buisness.premiumcounter;

public class Result {

    private double ball;
    private int calls;
    private int errors;
    private int workHours;
    private double premium;

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getLoad() {

        double load = this.getCalls()/(this.getWorkHours()/24D);
        return load;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }



    public double getBall() {
        return ball;
    }

    public void setBall(double ball) {
        this.ball += ball + 1;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls() {
        this.calls += 1;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors += errors;
    }

    public Result() {
        this.ball = 100;
        this.calls = 0;
        this.errors = 0;
        this.workHours = 0;
        this.premium = 0;
    }

    @Override
    public String toString() {
        return "Result{" +
                "ball=" + ball +
                ", calls=" + calls +
                ", errors=" + errors +
                ", workHours=" + workHours +
                ", premium=" + premium +
                '}';
    }
}
