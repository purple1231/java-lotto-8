package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현



}


//그럼 컨트롤러가 인풋 뷰를 요청해서 값을 얻은 다음(클리어)
// 서비스에게 넘겨서
// 로직을
//도메인: 로또, 당첨번호로또, 로또발급기(가격당 반복)(랜덤돌리기), 로또 몇등인가 계산해주기, 당첨내역출력(총 수익률까지)
//도메인들과 함께 수행하고 결국 정답을 컨트롤러가 리턴받아서 아웃풋뷰로 보여주면 되는거
//정정 컨트롤러는 값 = 서비스 한 다음 그다음 줄에 아웃풋뷰로 출력만 해주면 됨

//인풋뷰, 아웃풋 뷰 만들기



//https://gemini.google.com/share/772f30b55b20