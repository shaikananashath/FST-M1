user_input = input("Enter numbers separated by spaces: ")


number_list = list(map(int, user_input.split()))


total = sum(number_list)


print("The sum of the numbers is:", total)
