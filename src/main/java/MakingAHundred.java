public class MakingAHundred {


    public static final int TARGET_NUMBER = 100;
    public static final int[] NUMS = {1, 2, 3, 4, 5, 6, 7, 8, 9};

//    public static void printAllPossibilities(int sum, int idx, String str) {
//
//
//        if(sum == TARGET_NUMBER && idx == NUMS.length - 1) {
//            System.out.println(str);
//            return;
//        }
//
//        int digit = NUMS[idx];
//
//
//        if(idx < NUMS.length - 1) {
//            idx += 1;
//            printAllPossibilities(sum + digit, idx, str + " + " + digit);
//            printAllPossibilities(sum - digit, idx, str + " - " + digit);
//
//            int concatNum = digit >= 0 ? 10 * digit + NUMS[idx] : 10 * digit - NUMS[idx];
//
//            printAllPossibilities(sum + concatNum, idx, str + " + " + concatNum);
//        }
//    }

    public static void printAllPossibilities(int sum, int idx, String str, int num) {


        if(sum == TARGET_NUMBER && idx >= NUMS.length) {
            System.out.println(str);
            return;
        }

        if(idx < NUMS.length) {
            printAllPossibilities(sum + num, idx + 1, str + " + " + num, NUMS[idx]);
            printAllPossibilities(sum + num, idx + 1, str + " - " + num, -NUMS[idx]);

            if(idx < NUMS.length - 1) {
                int concatNum = num >= 0 ? 10 * num + NUMS[idx + 1] : 10 * num - NUMS[idx + 1];
                printAllPossibilities(sum + concatNum, idx + 2, str + " + " + concatNum, concatNum);
            }
        }
    }

    public static void print() {
        printAllPossibilities(0, 0, "", NUMS[0]);
    }

    public static void main(String[] args) {

        print();
    }
}
