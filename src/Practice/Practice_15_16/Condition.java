package Practice.Practice_15_16;

public class Condition {
    private int action_0, action_1, step_0, step_1;

    public Condition(int action_0, int action_1, int step_0, int step_1) {
        this.action_0 = action_0;
        this.action_1 = action_1;
        this.step_0 = step_0;
        this.step_1 = step_1;
    }
    int Next(int num){
        if(num==0)
            return step_0;
        else
            return step_1;
    }
    int Num(int num){
        if(num==0)
            return action_0;
        else
            return action_1;
    }
}
