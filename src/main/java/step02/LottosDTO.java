package step02;

import java.util.List;

import static step02.LottoConfig.*;

public class LottosDTO {
    private List<LottoNumbers> lottos;
    private LottoCount lottoCount;


    public void setLottos(List<LottoNumbers> lottoNumbers) {
        this.lottos = lottoNumbers;
    }

    public String getLottosToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoNumbers lottoNumbers : lottos) {
            stringBuilder.append(START_LOTTO_SYMBOL)
                    .append(lottoNumbers.getLottoNumbersResult().getLottoNumbersToString())
                    .append(END_LOTTO_SYMBOL)
                    .append(LINE_BRAKE);
        }
        return stringBuilder.toString();
    }

    public void setLottoCount(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return lottoCount.getCount();
    }
}
