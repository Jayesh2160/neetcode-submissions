class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Keep a Min-Heap of size k
        // We pass a custom comparator: compare based on the map's frequency values
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );

        for (int num : countMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // Removes the element with the lowest frequency
            }
        }

        // Step 3: Build the output array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
