package lotto.controller;

import lotto.InputView;
import lotto.OutputView;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.LottoCount;
import lotto.service.LottoMachineService;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMachineService lottoService = new LottoMachineService();

    LottoCount purchaseAmount;


    public void run(){

        LottoCount lottoCount = createValidatedLottoCount();
        Lottos lottos = lottoService.run(lottoCount);

        outputView.printLottosCount(lottoCount);
        outputView.printLottos(lottos);

        LottoAnswer lottoAnswer = createValidatedLottoAnswer();

        LottoResult lottoResult = new LottoResult(lottoAnswer, lottos);
        outputView.printLottoResult(lottoResult, lottoCount);
    }


    private LottoCount createValidatedLottoCount(){
        while (true){
            try{
                int money = inputView.readMoney();
                return new LottoCount(money);

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private LottoAnswer createValidatedLottoAnswer(){
        while (true){
            try{
                List<Integer> answerNumber = inputView.readAnswer();
                int answerBonusNumber = inputView.readBonusAnswer();
                return new LottoAnswer(answerNumber, answerBonusNumber);

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
