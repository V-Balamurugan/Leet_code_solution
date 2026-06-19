class Solution {
    public int largestAltitude(int[] gain) {
        int []altitude = new int[gain.length+1];
        altitude[0]=0;
        int temp = altitude[0];
        for(int i=1;i<altitude.length;i++){
            temp += gain[i-1];
            altitude[i]=temp; 
        }
        int result = altitude[0];
        for(int i=1;i<altitude.length;i++){
            if(result < altitude[i]){
                result = altitude[i];
            }
        }
        return result;
        
    }
}
