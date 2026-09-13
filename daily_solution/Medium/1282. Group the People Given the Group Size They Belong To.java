import java.util.Hashtable;
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Hashtable<Integer,List<Integer>> table = new Hashtable<>();
        //make it first hashset with store their index array like 1:{5} and 3:{0,1,2,3,4,6}
        for(int i=0;i<groupSizes.length;i++){
            if(table.containsKey(groupSizes[i]))
                table.get(groupSizes[i]).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                table.put(groupSizes[i],list);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(table.keySet());
        for(int i=0;i<table.size();i++){
            int key = keys.get(i);
            List<Integer> list = table.get(key);
            if(table.get(key).size()<key){
                result.add(table.get(key));
            }
            else{
                for (int j = 0; j < list.size(); j += key) {
                    List<Integer> part =
                        list.subList(j, Math.min(j + key, list.size()));
                    result.add(new ArrayList<>(part));
                }
            }
        }
        return result;
    }
}
