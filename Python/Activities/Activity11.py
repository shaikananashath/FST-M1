fruits = {
    "apple": 120,
    "banana": 40,
    "mango": 100,
    "orange": 80,
    "grapes": 90
}


fruit_name = input("Enter the name of the fruit you want to check: ").lower()


if fruit_name in fruits:
    print(f"Yes, {fruit_name} is available at ₹{fruits[fruit_name]} per kg.")
else:
    print(f"Sorry, {fruit_name} is not available.")