package lotto.domain;

import lotto.validator.InputValidator;

public class LottoCount {
    private final int money;
    private static final int LOTTO_PRICE = 1000;

    public LottoCount(int money) {
        validateMoney(money);
        this.money = money;
    }



    public int getAmount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney(){
        return money;
    }

    private void validateMoney(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
    }
}
