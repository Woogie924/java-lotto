package lotto.domain;

import lotto.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTests {

    @DisplayName("로또가 1,2,3,4,5,6 이고 1등 상황 일 때 1등 로또 결과를 잘 가져오는지 테스트")
    @Test
    void getLottoResultTest() {
        LottoResult lottoResult = getLottoResult("1,2,3,4,5,6", 7);


        assertThat(lottoResult.getLottoResult().get(LottoRank.FIRST)).isEqualTo(1);
    }

    @DisplayName("로또가 1,2,3,4,5,6 이고 2등 상황 일 때 2등 로또 결과를 잘 가져오는지 테스트")
    @Test
    void getLottoResultSecondPriceTest() {
        LottoResult lottoResult = getLottoResult("1,2,3,4,5,8", 6);

        assertThat(lottoResult.getLottoResult().get(LottoRank.SECOND)).isEqualTo(1);
    }

    @DisplayName("로또가 1,2,3,4,5,6 이고 3등 상황 일 때 3등 로또 결과를 잘 가져오는지 테스")
    @Test
    void getLottoResultThirdPriceTest() {
        LottoResult lottoResult = getLottoResult("1,2,3,4,5,8", 9);

        assertThat(lottoResult.getLottoResult().get(LottoRank.THIRD)).isEqualTo(1);
    }

    @DisplayName("결과로 수익 계산이 올바른 지 테스트")
    @Test
    void validLottoCalculateProfitTest() {
        LottoResult lottoResult = getLottoResult("1,2,3,4,5,6", 7);

        assertThat(lottoResult.calculateProfitRate(14000)).isEqualTo(142857.14285714287);
    }

    private LottoResult getLottoResult(String winningLottoTickets, int bonusNumber) {

        LottoTickets lottoTickets = getLottoTickets();

        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(winningLottoTickets);

        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);

        return LottoResult.of(lottoTickets, winningLottoTicket, bonusLottoNumber);
    }

    private LottoTickets getLottoTickets() {
        LottoTicket lottoTicket = LottoTicket.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        Set<LottoTicket> totalLottoTicket = new HashSet<>();

        totalLottoTicket.add(lottoTicket);

        LottoTickets lottoTickets = LottoTickets.of(totalLottoTicket);

        return lottoTickets;
    }

}