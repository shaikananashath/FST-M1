user_input = input("Enter numbers for the tuple (space-separated): ")


number_tuple = tuple(map(int, user_input.split()))


print("Numbers divisible by 5:")
for num in number_tuple:
    if num % 5 == 0:
        print(num)