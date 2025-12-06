# test_calculations.py

def test_sum():
    assert 5 + 3 == 8
    assert -1 + 1 == 0
    assert 0 + 0 == 0

def test_difference():
    assert 10 - 4 == 6
    assert 0 - 5 == -5
    assert -3 - (-3) == 0

def test_product():
    assert 6 * 7 == 42
    assert 0 * 100 == 0
    assert -2 * 3 == -6

def test_quotient():
    assert 8 / 2 == 4
    assert 9 / 3 == 3
    assert 5 / 2 == 2.5