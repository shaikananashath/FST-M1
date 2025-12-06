try:
  
    print(undeclared_variable)
except NameError as e:
    print("Caught a NameError:", e)

print("Program continues running after handling the error.")