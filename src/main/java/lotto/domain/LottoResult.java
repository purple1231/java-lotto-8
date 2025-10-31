package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankStatus;

    public LottoResult(LottoAnswer lottoAnswer, Lottos lottos){
        this.rankStatus = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankStatus.put(rank, 0);
        }
        calculateStatistics(lottoAnswer, lottos);
    }

    private void calculateStatistics(LottoAnswer lottoAnswer, Lottos lottos){
        for(Lotto lotto: lottos.getLottos()){
            int matchCount = matchingNumbers(lotto, lottoAnswer);
            boolean matchBonus = matchingBonus(lotto, lottoAnswer);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            rankStatus.put(rank, rankStatus.get(rank)+1);
        }
    }

    private int matchingNumbers(Lotto lotto, LottoAnswer lottoAnswer){
        int matchingNumbers = (int) lotto.getNumbers().stream()
                .filter(number -> lottoAnswer.getAnswer().contains(number)).count();
        return matchingNumbers;
    }


    private boolean matchingBonus(Lotto lotto, LottoAnswer lottoAnswer){
        return lotto.getNumbers().contains(lottoAnswer.getBonus());
    }

}
