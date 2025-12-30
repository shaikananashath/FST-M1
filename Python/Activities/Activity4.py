us1 = input("What is Player 1's name? ")
us2 = input("What is Player 2's name? ")


while True:
    
    us1_ans = input(us1 + ", do you want to choose rock, paper or scissors? ").lower()
    
    us2_ans = input(us2 + ", do you want to choose rock, paper or scissors? ").lower()
    
    if us1_ans == us2_ans:
        print("It's a tie!")
    elif us1_ans == 'rock':
        if us2_ans == 'scissors':
            print("Rock wins!")
        else:
            print("Paper wins!")
    elif us1_ans == 'scissors':
        if us2_ans == 'paper':
            print("Scissors win!")
        else:
            print("Rock wins!")
    elif us1_ans == 'paper':
        if us2_ans == 'rock':
            print("Paper wins!")
        else:
            print("Scissors win!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")

    repeat = input("Do you want to play another round? Yes/No: ").lower()
    
    if(repeat == "yes"):
        pass

    elif(repeat == "no"):
        raise SystemExit

    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit