class Solution {
    public boolean isAnagram(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();

        if(len1!=len2) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0;i<len1;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}
