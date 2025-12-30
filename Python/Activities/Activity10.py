# Given tuple
number_tuple = (10, 20, 33, 46, 55)
print("Given list is ", number_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in number_tuple:
    if (num % 5 == 0):
        print(num)