import java.util.*;
//给定两个数组，编写一个函数来计算它们的交集(350)。
public class array_intersection {
    public static void main(String[] args) {
        int[] a1;
        int[] a2;
        //初始化
        a1 = new int[]{6, 2, 3, 19, 2, 80, 99, 12, 55, 1};
        a2 = new int[]{3, 2, 7, 19, 2, 2, 1};
        int[] a = ArrayIntersectionByMap(a1, a2);
        System.out.println(Arrays.toString(a));
        int[] b = ArrayIntersection(a1, a2);
        System.out.println(Arrays.toString(b));
    }

    private static int[] ArrayIntersectionByMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            //如果存在
            map.computeIfPresent(i, (k, v) -> {
                return v + 1;
            });
            //如果不存在
            map.computeIfAbsent(i, (v) -> {
                return 1;
            });
        }
        for (int i : nums2) {
            //如果存在
            map.computeIfPresent(i, (k, v) -> {
                if (v > 0) {
                    list.add(i);
                }
                return v - 1;
            });

        }
        int[] returnArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            returnArray[i] = list.get(i);
        }
        return returnArray;
    }

    private static int[] ArrayIntersection(int[] nums1, int[] nums2) {
        //数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //扩展：冒泡排序
        //sort(a1);
        //sort(a2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0, index2 = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                list.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        //定义返回的数组，长度为交集元素数量
        int[] returnArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            returnArray[i] = list.get(i);
        }
        return returnArray;
    }

    //冒泡排序
    private static void sort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
