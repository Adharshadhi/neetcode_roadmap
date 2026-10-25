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

5) **Missing Number** -> Without sorting, the trick is to find the **actual sum and expected sum** while iterating. Then return the difference.
6) **Maximum Sub Array** -> The key logic is that **whenever we add a negative number to the current sum it will reduce the total sum**. So only if the number is positive we carry forward it otherwise ignore. Needs to have two trackers one for the currentSum and other for the maxSum.

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);

currentSum checks whether adding the current value increases currentSum or not (either Start a new subarray from the current element → nums[i] or Extend the existing subarray → currentSum + nums[i]). If not, just start fresh from the current value. maxSum gets updated only when we get a value of currentSum greater than current maxSum.

7) **Group Anagrams** -> Key is to store the groups in a str -> list of strs. We need to sort each value first. For that convert the string to charArray and then use Arrays.sort(). Then we can use getOrDefault. If already sorted str is present, we would add the current string to the existing list. Else we create new empty arraylist and add.

            for(String str : strs){
                  char[] charArr = str.toCharArray();
                  Arrays.sort(charArr);
                  String sorted = new String(charArr);
                  List<String> stsList = anagramMap.getOrDefault(sorted, new ArrayList<>());
                  stsList.add(str);
                  anagramMap.put(sorted, stsList);
              }
