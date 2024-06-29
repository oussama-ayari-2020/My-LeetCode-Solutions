package Blind_75_Problems.Two_Pointers.Valid_Palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            Character c1 = Character.toLowerCase(s.charAt(i));
            Character c2 = Character.toLowerCase(s.charAt(j));
            if(c1<'0' || (c1>'9' && c1<'a') || c1>'z'){
                i++;
                continue;
            }
            if(c2<'a' || (c2>'9' && c2<'a') || c2>'z'){
                j--;
                continue;
            }
            if(!c1.equals(c2))
                return false;
            else{
                j--;
                i++;
            }
        }
        return true;
    }
}

