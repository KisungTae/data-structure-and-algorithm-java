package com.company.objectorienteddesign.question2review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallCentre {
    public List<Respondent> respondents = new ArrayList<>();
    public Queue<Call> calls = new LinkedList<>();

    public void dispatchCall(Call call) {
        respondents.get(0).takeCall(call);
    }

}
