package lotto.controller;

import lotto.InputView;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.LottoCount;
import lotto.service.LottoMachineService;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final LottoMachineService lottoService = new LottoMachineService();

    LottoCount purchaseAmount;


    public void run(){
        int money = inputView.readMoney();
        purchaseAmount = new LottoCount(money);
        Lottos lottos = lottoService.run(purchaseAmount);

        //여기에 아웃풋뷰로 lottos 출력.

        //여기에 정답 받기!
        List<Integer> answerNumber = inputView.readAnswer();
        int answerBonusNumber = inputView.readBonusAnswer();
        LottoAnswer lottoAnswer = new LottoAnswer(answerNumber, answerBonusNumber);
        LottoResult lottoResult = new LottoResult(lottoAnswer, lottos);

    }
}
