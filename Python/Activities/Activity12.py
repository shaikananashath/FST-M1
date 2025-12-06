def recursive_sum(n):
    
    if n == 0:
        return 0

    else:
        return n + recursive_sum(n - 1)

result = recursive_sum(10)

print("The sum of numbers from 0 to 10 is:", result)