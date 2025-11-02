package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView{



    public int readMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        try{
            return Integer.parseInt(inputMoney);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public List<Integer> readAnswer(){

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputAnswer = Console.readLine();
        String[] tokens = inputAnswer.split(",");
        List<Integer> numbers = new ArrayList<>();

        try{
            for (String token : tokens) {
                numbers.add(Integer.parseInt(token.trim()));
            }
            return numbers;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표(,)로만 구성되어야 합니다.");
        }
    }


    public int readBonusAnswer(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusAnswer = Console.readLine();
        try{
            return Integer.parseInt(inputBonusAnswer);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }


}
