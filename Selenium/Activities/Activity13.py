from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/tables")

    print("Page title is:", driver.title)

    cols = driver.find_elements(
        By.XPATH,
        "//table[contains(@class, 'table-auto')]/thead/tr/th"
    )

    print("Number of columns:", len(cols))

    rows = driver.find_elements(
        By.XPATH,
        "//table[contains(@class, 'table-auto')]/tbody/tr"
    )

    print("Number of rows:", len(rows))

    third_row = driver.find_elements(
        By.XPATH,
        "//table[contains(@class, 'table-auto')]/tbody/tr[3]/td"
    )

    print("Third row cell values:")

    for cell in third_row:
        print(cell.text)

    cell_value = driver.find_element(
        By.XPATH,
        "//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"
    )

    print("Second row, second cell value:", cell_value.text)