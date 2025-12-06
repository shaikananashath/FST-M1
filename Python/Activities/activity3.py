# Get choices from both players
player1 = input("Player 1, enter rock, paper, or scissors: ").lower()
player2 = input("Player 2, enter rock, paper, or scissors: ").lower()

# Determine the winner
if player1 == player2:
    print("It's a tie!")

elif player1 == "rock":
    if player2 == "scissors":
        print("Player 1 wins! Rock beats scissors.")
    elif player2 == "paper":
        print("Player 2 wins! Paper beats rock.")
    else:
        print("Invalid input from Player 2.")

elif player1 == "paper":
    if player2 == "rock":
        print("Player 1 wins! Paper beats rock.")
    elif player2 == "scissors":
        print("Player 2 wins! Scissors beats paper.")
    else:
        print("Invalid input from Player 2.")

elif player1 == "scissors":
    if player2 == "paper":
        print("Player 1 wins! Scissors beats paper.")
    elif player2 == "rock":
        print("Player 2 wins! Rock beats scissors.")
    else:
        print("Invalid input from Player 2.")

else:
    print("Invalid input from Player 1.")