package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView{



    public int readMoney(){
        while (true){
            System.out.println("로또를 구입할 금액을 입력하세요:");
            try{
                return getMoneyInput();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력하세요.");
            }
        }
    }

    private int getMoneyInput(){
        String inputMoney = Console.readLine();
        int Money = Integer.parseInt(inputMoney);
        InputValidator.validateMoney(Money);
        return Money; //예외 전파
    }

    public List<Integer> readAnswer(){
        while(true){
            System.out.println("당첨 금액을 입력하세요:");
            try{
                return getAnswerInput();
            }catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자와 콤마를 사용하세요");
            }
        }
    }

    private List<Integer> getAnswerInput(){ // 이거 answer객체 도메인 자체에서 설정하게 고치기
        String inputAnswer = Console.readLine();
        String[] tokens = inputAnswer.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            token = token.trim();
            if (!token.isEmpty()) {
                numbers.add(Integer.parseInt(token));
            }
        }
        InputValidator.validateAnswer(numbers);
        return numbers;
    }

    public int readBonusAnswer(){
        while(true){
            System.out.println("보너스 금액을 입력하세요:");
            try{
                return getBonusAnswerInput();
            }catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력하세요.");
            }
        }
    }

    private int getBonusAnswerInput(){
        String inputBonusAnswer = Console.readLine();
        int bonusAnswer = Integer.parseInt(inputBonusAnswer);
        InputValidator.validateBonus(bonusAnswer);
        return bonusAnswer;
    }



}
