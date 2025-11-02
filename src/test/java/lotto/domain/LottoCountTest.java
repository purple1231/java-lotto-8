package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("LottoCount 클래스 테스트")
class LottoCountTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void createLottoCountWithInvalidUnitPrice(){
        int money = 1500;
        assertThatThrownBy(() -> new LottoCount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 0보다 작거나 같으면 예외가 발생한다.")
    void createLottoCountWithZero(){
        int money = 0;
        assertThatThrownBy(() -> new LottoCount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 0보다 커야 합니다.");
    }



}