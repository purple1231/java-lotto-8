package lotto.domain;

import java.util.List;

public class LottoAnswer {

    private final List<Integer> answer;
    private final int bonus;

    public LottoAnswer(List<Integer> answer, int bonus){
        //여기에 validate 하기

        this.answer = answer;
        this.bonus = bonus;
    }


    public List<Integer> getAnswer() {
        return answer;
    }

    public int getBonus() {
        return bonus;
    }
}
