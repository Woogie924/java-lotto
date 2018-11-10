package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨번호만_맞은_것이_있다() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(lotto.match(winningNumber)).isEqualTo(3);
        assertThat(lotto.matchBonus(winningNumber)).isFalse();
    }

    @Test
    public void 당첨번호와_보너스번호_동시에_맞은_것이_있다() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(lotto.match(winningNumber)).isEqualTo(3);
        assertThat(lotto.matchBonus(winningNumber)).isTrue();
    }
}