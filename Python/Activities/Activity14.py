def fibonacci(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


count = int(input("How many Fibonacci numbers to generate? "))

print("Fibonacci sequence:")
for i in range(count):
    print(fibonacci(i), end=" ")