package lotto;

import lotto.domain.*;

import java.util.Map;

public class OutputView {

    public void printLottosCount(LottoCount lottoCount){
        System.out.println(lottoCount.getAmount() + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.getNumbers());
        }

    }

    public void printLottoResult(LottoResult lottoResult, LottoCount lottoCount){
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> rankStatus = lottoResult.getRankStatus();

        System.out.printf("%s - %d개\n", Rank.FIFTH.getDisplayName(), rankStatus.get(Rank.FIFTH));
        System.out.printf("%s - %d개\n", Rank.FOURTH.getDisplayName(), rankStatus.get(Rank.FOURTH));
        System.out.printf("%s - %d개\n", Rank.THIRD.getDisplayName(), rankStatus.get(Rank.THIRD));
        System.out.printf("%s - %d개\n", Rank.SECOND.getDisplayName(), rankStatus.get(Rank.SECOND));
        System.out.printf("%s - %d개\n", Rank.FIRST.getDisplayName(), rankStatus.get(Rank.FIRST));

        double rate = lottoResult.calculateRate(lottoCount.getMoney());
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }
}
