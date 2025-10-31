package lotto.domain;

import lotto.validator.InputValidator;

public class LottoCount {
    private final int money;
    private static final int LOTTO_PRICE = 1000;

    public LottoCount(int money) {
        InputValidator.validateMoney(money);
        this.money = money;
    }



    public int getAmount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney(){
        return money;
    }
}
