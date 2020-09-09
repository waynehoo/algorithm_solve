//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""
public class max_prefix {
    public static void main(String[] args) {
        //String[] strings = new String[]{"flower","flow","flight"};
        String[] strings = new String[]{"dog", "racecar", "car"};
        //String[] strings = new String[]{};  //空数组测试
        String aa = longestCommonPrefix1(strings);
        System.out.println(aa);
    }


    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = "";
        //把数组第一个元素当做前缀，如果不是共同前缀则减一位继续循环
        for (int i = 0; i < strs[0].length(); i++) {
            prefix = strs[0].substring(0, strs[0].length() - i);
            int count = 0;
            for (String s : strs) {
                if (s.indexOf(prefix) != 0 && prefix.length() > 1)
                    break;
                if (s.indexOf(prefix) != 0 && prefix.length() == 1)
                    return "";
                count++;
                if (count == strs.length)
                    return prefix;
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix1(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
