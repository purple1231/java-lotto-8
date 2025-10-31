package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottoCount;

import java.util.ArrayList;
import java.util.List;

public class LottoMachineService {

    public Lottos run(LottoCount purchaseAmount){
        List<Lotto> generatedLottos = new ArrayList<>();
        for(int i = 0; i < purchaseAmount.getAmount(); i++){
            Lotto createdLotto = createSingleLotto();
            generatedLottos.add(createdLotto);
        }
        return new Lottos(generatedLottos);
    }

    private Lotto createSingleLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }



}
