import pytest

# Fixture that initializes wallet amount to 0
@pytest.fixture
def wallet():
    return {"amount": 0}

# Parameterize test with earned, spent, expected values
@pytest.mark.parametrize("earned, spent, expected", [
    (10, 5, 5),
    (20, 5, 15),
    (0, 0, 0),
    (100, 25, 75),
    (50, 60, -10),  # Allowing negative balance for test example
])
def test_wallet_transactions(wallet, earned, spent, expected):
    # Add earned amount
    wallet["amount"] += earned
    # Spend amount
    wallet["amount"] -= spent
    # Assert final amount equals expected
    assert wallet["amount"] == expected