package lab1.beans.aspects.mocks;

import lab1.beans.aspects.LuckyWinnerAspect;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 13/2/16
 * Time: 8:38 PM
 */
public class LuckyWinnerAspectMock extends LuckyWinnerAspect {

    public LuckyWinnerAspectMock(int luckyPercentage) {
        super(luckyPercentage);
    }

    public static void cleanup() {
        luckyUsers.clear();
    }
}
