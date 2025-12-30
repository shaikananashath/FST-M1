# Given lists
list1 = [10, 20, 30, 40, 50]
list2 = [13, 43, 24, 40, 12]

# Print the lists
print("First List ", list1)
print("Second List ", list2)

# Declare a third list that will contain the result
thirdList = []

# Iterate through first list to get odd elements
for num in list1:
    if (num % 2 != 0):
        thirdList.append(num)
        
# Iterate through first list to get even elements
for num in list2:
    if (num % 2 == 0):
        thirdList.append(num)

# Print result
print("Third List:", thirdList)