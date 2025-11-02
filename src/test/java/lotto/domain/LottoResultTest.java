package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@DisplayName("LottoResult 클래스 테스트")
class LottoResultTest {

    @Test
    @DisplayName("당첨 결과를 계산한다.")
    void calculateResult(){

        LottoAnswer lottoAnswer = new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7);
        Lottos purchasedLottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 5등 (3개 일치)
                new Lotto(List.of(1, 2, 3, 4, 11, 12)), // 4등 (4개 일치)
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등 (5개 + 보너스 일치)
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 꽝
        ));
        int purchaseMoney = 4000;

        LottoResult lottoResult = new LottoResult(lottoAnswer, purchasedLottos);

        Map<Rank, Integer> rankStatus = lottoResult.getRankStatus();
        assertThat(rankStatus.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankStatus.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankStatus.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankStatus.get(Rank.FIRST)).isEqualTo(0);

    }

}