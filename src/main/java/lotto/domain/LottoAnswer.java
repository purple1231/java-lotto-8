package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoAnswer {

    private final List<Integer> answer;
    private final int bonus;

    public LottoAnswer(List<Integer> answer, int bonus){

        validateAnswer(answer);
        validateBonusSize(bonus);
        validateBonusNumber(bonus, answer);

        this.answer = answer;
        this.bonus = bonus;
    }


    public List<Integer> getAnswer() {
        return answer;
    }

    public int getBonus() {
        return bonus;
    }


    //보너스랑 로또 겹치지 않게
    private void validateBonusNumber(int bonus, List<Integer> answer){
        if(answer.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateAnswer(List<Integer> numbers){
        if (numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
        for (int n : numbers){
            if (n < 1 || n > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateBonusSize(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}


