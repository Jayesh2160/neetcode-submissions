class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Fixed: Changed 'char' to 'char[]'
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String newString = new String(charArray);
            if (!map.containsKey(newString)) {
                map.put(newString, new ArrayList<>());
            }
            map.get(newString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}