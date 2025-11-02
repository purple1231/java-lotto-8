package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoAnswer 클래스 테스트")
class LottoAnswerTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void createLottoAnswerWithDuplicateBonusNumber(){
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6; // 당첨 번호와 중복

        assertThatThrownBy(() -> new LottoAnswer(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void createLottoAnswerWithOutOfRangeBonusNumber(){
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46; // 범위 밖

        assertThatThrownBy(() -> new LottoAnswer(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    void createLottoByOverSize(){
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 30;
        assertThatThrownBy(() -> new LottoAnswer(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumbe(){
        List<Integer> winningNumbers = List.of(1, 2, 3, 5, 5, 5);
        int bonusNumber = 30;
        assertThatThrownBy(() -> new LottoAnswer(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void createLottoByOutOfRangeNumber(){
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 555, 6);
        int bonusNumber = 30;
        assertThatThrownBy(() -> new LottoAnswer(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }


}