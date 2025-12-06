import pytest

# Fixture inside the test file initially
@pytest.fixture
def number_list():
    return list(range(11))  # 0 to 10 inclusive

def test_sum_of_list(number_list):
    assert sum(number_list) == 55