import pytest

@pytest.mark.parametrize("a, b, expected", [
    (5, 3, 8),
    (-1, 1, 0),
    (0, 0, 0),
])
def test_sum(a, b, expected):
    assert a + b == expected

@pytest.mark.parametrize("a, b, expected", [
    (10, 4, 6),
    (0, 5, -5),
    (-3, -3, 0),
])
def test_difference(a, b, expected):
    assert a - b == expected

@pytest.mark.activity
@pytest.mark.parametrize("a, b, expected", [
    (6, 7, 42),
    (0, 100, 0),
    (-2, 3, -6),
])
def test_product(a, b, expected):
    assert a * b == expected

@pytest.mark.activity
@pytest.mark.parametrize("a, b, expected", [
    (8, 2, 4),
    (9, 3, 3),
    (5, 2, 2.5),
])
def test_quotient(a, b, expected):
    assert a / b == expected