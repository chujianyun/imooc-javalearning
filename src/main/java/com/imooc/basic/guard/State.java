package com.imooc.basic.guard;

import lombok.Data;

public abstract class State {
    protected Context context;

    protected State nextState;

    public void setContext(Context context) {
        this.context = context;
    }

    abstract void doAction();

    public Context getContext() {
        return context;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
}
