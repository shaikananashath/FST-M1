list1_input = input("Enter the first list of numbers (space-separated): ")
list1 = list(map(int, list1_input.split()))

list2_input = input("Enter the second list of numbers (space-separated): ")
list2 = list(map(int, list2_input.split()))

odd_from_list1 = [num for num in list1 if num % 2 != 0]

even_from_list2 = [num for num in list2 if num % 2 == 0]

new_list = odd_from_list1 + even_from_list2

print("Resulting list:", new_list)