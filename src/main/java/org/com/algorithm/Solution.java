package org.com.algorithm;


public class Solution {
    public Solution() {
    }

    /*
请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
函数 myAtoi(string s) 的算法如下：
空格：读入字符串并丢弃无用的前导空格（" "）
符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
返回整数作为最终结果。
* */
    public static int myAtoi(String s) {
        StringBuffer stringBuffer = new StringBuffer(s.trim());
        stringBuffer.trimToSize();
        if (stringBuffer.length() == 0) {
            return 0;
        }
        long result = 0, symbol = 1;
        switch (stringBuffer.charAt(0)) {
            case '-':
                symbol = -1;
                stringBuffer.deleteCharAt(0);
                break;
            case '+':
                stringBuffer.deleteCharAt(0);
                break;
        }
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) < '0' || stringBuffer.charAt(i) > '9') {
                result = result * symbol;
                return (int) result;
            }
            result = result * 10 + (stringBuffer.charAt(i) - '0');
            if (result > Integer.MAX_VALUE) {
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        result = result * symbol;
        return (int) result;
    }

    /*
    * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    例如，121 是回文，而 123 不是。
    *
    * 进阶：你能不将整数转为字符串来解决这个问题吗？
    * */
    public static boolean isPalindromeV0(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int temp = x;
        int result = 0;
        while (temp != 0) {
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        return result == x;
    }

    public static boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * @param s
     * @param p
     *
     * @return
     */
    public static boolean isMatch(String s, String p) {
        StringBuilder ss = new StringBuilder(s);
        StringBuilder pp = new StringBuilder(p);
        if (s.length() != p.length()) return false;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) != pp.charAt(i) && pp.charAt(i) != '.') {
                return false;
            }

        }
        return false;
    }

    /**
     * 88. 合并两个有序数组
     * 逆向双指针
     *
     * @param nums1 数组1
     * @param m     长度
     * @param nums2 数组2
     * @param n     长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[l--] = nums1[m - 1];
                m--;
            } else {
                nums1[l--] = nums2[n - 1];
                n--;
            }

        }
    }

    /**
     * 27. 移除元素
     *
     * @param nums 数组
     * @param val  移除的元素
     *
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
