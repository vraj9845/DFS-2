// Time Complexity: O(m*n)
//Sapce Complexity = O(length of input string)
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c  = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10 + c - '0';
            } else if(c=='[') {
                strSt.push(currStr);
                numSt.push(num);
                num=0;
                currStr= new StringBuilder();
            } else if(c==']'){
                int n=numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int k=0;k<n;k++){
                    temp.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr=parent.append(temp);
                
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
