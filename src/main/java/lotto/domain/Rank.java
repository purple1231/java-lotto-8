package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000L, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000L, "3개 일치 (5,000원)"),
    MISS(0, 0L, ""); // 꽝 (0, 1, 2개 일치)

    private final int matchCount;
    private final long prizeMoney;
    private final String displayName;

    Rank(int matchCount, long prizeMoney, String displayName){
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.displayName = displayName;
    }

    public static Rank valueOf(int matchCount, boolean hasBonus){
        if (matchCount == 6){
            return FIRST;
        }
        if (matchCount == 5 && hasBonus){
            return SECOND;
        }
        if (matchCount == 5){
            return THIRD;
        }
        if (matchCount == 4){
            return FOURTH;
        }
        if (matchCount == 3){
            return FIFTH;
        }
        return MISS; // 0, 1, 2개는 모두 꽝
    }

    public long getPrizeMoney(){
        return prizeMoney;
    }

    public String getDisplayName(){
        return displayName;
    }


}

