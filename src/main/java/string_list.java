import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class string_list {
    public static void main(String[] args) {
        //将逗号分隔的字符串转换为List
        String str = "a,b,c";
        List<String> list = Arrays.asList(str.split(","));
        System.out.println(str + " --> " + list);

        //将List转换为逗号分隔的字符串
        //1.利用Guava的Joiner
        List<String> list1 = new ArrayList<String>();
        list1.add("aa");
        list1.add("bb");
        list1.add(null);
        list1.add("cc");

        String str1 = Joiner.on(",").skipNulls().join(list1);
        System.out.println(list1 + " --> " + str1);

        //2.利用Apache Commons的StringUtils
        List<String> list2 = new ArrayList<String>();
        list2.add("xx");
        list2.add("yy");
        list2.add(null);
        list2.add("zz");
        String str2 = StringUtils.join(list2.toArray(), ",");
        System.out.println(list2 + " --> " + str2);
    }
}
