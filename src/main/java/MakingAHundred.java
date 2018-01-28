public class MakingAHundred {

    private static final int TARGET_NUMBER = 100;
    private static final int[] NUMS = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private static void printAllPossibilities(int sum, int number, int index, String str) {

        if (index >= NUMS.length) {
            if (sum + number == TARGET_NUMBER) {
                System.out.println(concatStr(str, number));
            }

            return;
        }

        printAllPossibilities(sum + number, NUMS[index], index + 1, concatStr(str, number));
        printAllPossibilities(sum + number, -NUMS[index], index + 1, concatStr(str, number));
        printAllPossibilities(sum, concatenatedNumber(number, index), index + 1, str);
    }

    public static void printAllPossibilities() {
        printAllPossibilities(0, NUMS[0], 1, "");
    }

    private static int concatenatedNumber(int number, int index) {
        return number >= 0 ? 10 * number + NUMS[index] : 10 * number - NUMS[index];
    }

    private static String concatStr(String str, int num) {
        return num >= 0 ? str + " + " + num : str + " - " + - num;
    }
}
