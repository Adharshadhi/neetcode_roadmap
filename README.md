# neetcode_roadmap
NeetCode 150 - Pattern Based Approach


#Cheat Sheet

1) **Contains Duplicates** -> Hash based approach. Insert elements into a HashSet(add()) and if any add method calls returns false, then duplicate present.
  
2) **Valid Anagram** -> Hash Map / int array (in case of lower cases only). Use **getOrDefault** method specifically. For first string, add the number of occurrences and for second string subtract. Both addition and subtraction should happen simultaneously.

   map.put(s.charAt(i), map.getOrDefault(s.charAt(i) , 0) + 1);
   map.put(t.charAt(i), map.getOrDefault(t.charAt(i) , 0) - 1);

3) **Two Sum** -> Use HashMap to store in the format **remaining after subtracting from target : index**. Check if the current element is present in the map. If it does, it means that the partner element is already present. So return the **current index, index stored in the map**.

      if(targetMap.get(nums[i]) != null){
          return new int[]{targetMap.get(nums[i]), i};
      }else{
          int balance = target - nums[i];
          targetMap.put(balance, i);
      }

4) **Best Time to Buy and Sell Stock** -> We need to keep track of the minimum price to buy and check what would be the profit if we sell on each day (**profit = buying price - price on that day**). If it exceeds current profit, update the max profit.
      if(prices[i] < buyPrice){
          buyPrice = prices[i];
      }else{
          profit = Math.max(profit, prices[i] - buyPrice);
      }
