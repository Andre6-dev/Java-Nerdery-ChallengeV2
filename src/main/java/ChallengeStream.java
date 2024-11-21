/* (C)2024 */
import java.util.List;
import mocks.CallCostObject;
import mocks.CallSummary;
import mocks.CardWinner;
import mocks.TotalSummary;

public class ChallengeStream {

    private static final double INTERNATIONAL_FIRST_3_MIN = 7.56;
    private static final double INTERNATIONAL_ADDITIONAL_MIN = 3.03;
    private static final double NATIONAL_FIRST_3_MIN = 1.20;
    private static final double NATIONAL_ADDITIONAL_MIN = 0.48;
    private static final double LOCAL_PER_MIN = 0.2;
    private static final int BASE_MINUTES = 3;

    private static final String INTERNATIONAL = "International";
    private static final String NATIONAL = "National";
    private static final String LOCAL = "Local";

    /**
     * Design a solution to calculate what to pay for a set of phone calls. The function must receive an
     * array of objects that will contain the identifier, type and duration attributes. For the type attribute,
     * the only valid values are: National, International and Local
     *
     * The criteria for calculating the cost of each call is as follows:
     *
     * International: first 3 minutes $ 7.56 -> $ 3.03 for each additional minute
     * National: first 3 minutes $ 1.20 -> $ 0.48 per additional minute
     * Local: $ 0.2 per minute.
     *
     * The function must return the total calls, the details of each call (the detail received + the cost of the call)
     * and the total to pay taking into account all calls. The solution must be done only using streams.
     *
     * @param {Call[]} calls - Call's information to be processed
     *
     * @returns {CallsResponse}  - Processed information
     */
    public TotalSummary calculateCost(List<CallCostObject> costObjectList) {
        // YOUR CODE HERE...

        List<CallSummary> callSummaries = costObjectList.stream()
                .map(call -> new CallSummary(call, calculateCallCost(call)))
                .toList();

        // get the total cost of all calls
        double totalCost = callSummaries.stream()
                .mapToDouble(CallSummary::getTotalCost)
                .sum();

        // Validate the type of the call to get the size if it is not National, International or Local dont count it
        long totalCalls = callSummaries.stream()
                .filter(call -> call.getCallCostObject().getType().equals("National") ||
                        call.getCallCostObject().getType().equals("International") ||
                        call.getCallCostObject().getType().equals("Local"))
                .count();

        return new TotalSummary(
                callSummaries,
                (int) totalCalls,
                totalCost);
    }

    private Double calculateCallCost(CallCostObject call) {
        return switch (call.getType()) {
            case INTERNATIONAL -> calculateCostByType(call.getDuration(), INTERNATIONAL);
            case NATIONAL -> calculateCostByType(call.getDuration(), NATIONAL);
            case LOCAL -> calculateCostByType(call.getDuration(), LOCAL);
            default -> 0.0;
        };
    }

    private double calculateCostByType(int duration, String type) {
        double total = 0.00;
        double first3MinRate;
        double additionalMinRate;

        switch (type) {
            case INTERNATIONAL -> {
                first3MinRate = INTERNATIONAL_FIRST_3_MIN;
                additionalMinRate = INTERNATIONAL_ADDITIONAL_MIN;
            }
            case NATIONAL -> {
                first3MinRate = NATIONAL_FIRST_3_MIN;
                additionalMinRate = NATIONAL_ADDITIONAL_MIN;
            }
            case LOCAL -> {
                return duration * LOCAL_PER_MIN;
            }
            default -> throw new IllegalArgumentException("Invalid call type");
        }

        if (duration <= BASE_MINUTES) {
            total = first3MinRate * duration;
        } else {
            total = (additionalMinRate * (duration - BASE_MINUTES)) + (BASE_MINUTES * first3MinRate);
        }

        return total;
    }

    /**
     * One stack containing five numbered cards from 0-9 are given to both players. Calculate which hand has winning number.
     * The winning number is calculated by which hard produces the highest two-digit number.
     *
     * calculateWinningHand([2, 5, 2, 6, 9], [3, 7, 3, 1, 2]) ➞ true
     *  P1 can make the number 96
     *  P2 can make the number 73
     *  P1 win the round since 96 > 73
     *
     * The function must return which player hand is the winner and the two-digit number produced. The solution must contain streams.
     *
     * @param player1  hand, player2 hand
     */
    public CardWinner calculateWinningHand(List<Integer> player1, List<Integer> player2) {

        int player1Max = player1.stream()
                // create a stream of all possible two-digit numbers
                .flatMap(d1 -> player1.stream()
                        .filter(d2 -> !d2.equals(d1)) // ensure that the two digits are different
                        .map(d2 -> d1 * 10 + d2)) // combine the two digits to form a two-digit number
                .max(Integer::compareTo)// get the highest two-digit number
                .orElse(0);

        int player2Max = player2.stream()
                .flatMap(d1 -> player2.stream()
                        .filter(d2 -> !d2.equals(d1))
                        .map(d2 -> d1 * 10 + d2))
                .max(Integer::compareTo)
                .orElse(0);

        // return the winner and the winning number and if bot players have the same number return TIE
        return new CardWinner(player1Max > player2Max
                ? "P1" : player1Max == player2Max
                ? "TIE" : "P2",
                Math.max(player1Max, player2Max));
    }
}
