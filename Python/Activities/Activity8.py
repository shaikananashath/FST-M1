user_input = input("Enter numbers separated by spaces: ")

number_list = list(map(int, user_input.split()))


if len(number_list) > 0 and number_list[0] == number_list[-1]:
    print("True - The first and last numbers are the same.")
else:
    print("False - The first and last numbers are different.")