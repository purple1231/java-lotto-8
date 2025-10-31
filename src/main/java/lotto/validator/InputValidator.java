package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateMoney(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
    }

    public static void validateAnswer(List<Integer> numbers){
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

    public static void validateBonus(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
